package jpa.one.to.one.uni.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.one.to.one.uni.entity.Course;
import jpa.one.to.one.uni.entity.Instructor;
import jpa.one.to.one.uni.entity.InstructorDetail;
import jpa.one.to.one.uni.entity.Review;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	@Transactional
	public void save(InstructorDetail instructorDetail) {
		entityManager.persist(instructorDetail);

	}

	@Override
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstruById(int theId) {
		Instructor temp = entityManager.find(Instructor.class, theId);
		entityManager.remove(temp);
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.merge(instructor);
	}

	@Override
	public List<Course> findCourseByInstructorId(int theId) {
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= :data", Course.class);
		query.setParameter("data", theId);
		List<Course> course = query.getResultList();
		return course;
	}

	@Override
	public Instructor findInstructorByJoinFetch(int theId) {
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "JOIN FETCH i.courses "
				+ "JOIN FETCH i.instructorDetail " + "where i.id =:data", Instructor.class);
		query.setParameter("data", theId);
		Instructor ins = query.getSingleResult();
		return ins;
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		entityManager.merge(instructor);

	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		Instructor instructor = entityManager.find(Instructor.class, theId);

		List<Course> courses = instructor.getCourse();

		for (Course tempCourse : courses) {
			tempCourse.setInstructor(null);
		}
		entityManager.remove(instructor);
	}

	@Override
	public Course findCourseAndReviewByCourseId(int theId) {
		TypedQuery<Course> query = entityManager
				.createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "where c.id =:data", Course.class);
		query.setParameter("data", theId);

		Course course = query.getSingleResult();
		return course;
	}

	@Override
	@Transactional
	public void save(Course tempCourse) {
		entityManager.persist(tempCourse);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		Course course = entityManager.find(Course.class, theId);
//List<Review> reviews = course.getReviews(); // not required both table delete at same time because of CascadeType
//for (Review review : reviews) {
//	review.setComment(null);
//}
		entityManager.remove(course);

	}

}

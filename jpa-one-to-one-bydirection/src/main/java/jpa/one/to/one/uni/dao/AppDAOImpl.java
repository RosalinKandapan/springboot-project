package jpa.one.to.one.uni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jpa.one.to.one.uni.entity.Instructor;
import jpa.one.to.one.uni.entity.InstructorDetail;

@Repository
public class AppDAOImpl implements AppDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Transactional
	public void save(InstructorDetail instructorDetail) {
		entityManager.persist(instructorDetail);
		
		
	}

	@Override
	public InstructorDetail findInstructorById(int theId) {
	return	entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstruById(int theId) {
		Instructor temp= entityManager.find(Instructor.class, theId);
		entityManager.remove(temp);
	}

	@Override
	public void save(Instructor instructor) {
		// TODO Auto-generated method stub
		
	}

	
}

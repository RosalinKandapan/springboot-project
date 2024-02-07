package jpa.one.to.one.uni;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jpa.one.to.one.uni.dao.AppDAO;
import jpa.one.to.one.uni.entity.Course;
import jpa.one.to.one.uni.entity.Instructor;
import jpa.one.to.one.uni.entity.InstructorDetail;

@SpringBootApplication
public class JpaOneToOneUnidirectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneUnidirectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			System.out.println("Hello i am spring boot project");
			// createInstructorWithCourses(appDAO);
			// findInstructor(appDAO);
			// deleteInstructorDetails(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			//findInstructorWithCourses(appDAO);
			//findInstructorwithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			deleteInstructor(appDAO);

		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 4;
		appDAO.deleteInstructorById(theId);
		
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		tempInstructor.setLastName("Maria");
		tempInstructor.setEmail("xyz@@gmail.com");
		appDAO.update(tempInstructor);
	}

	private void findInstructorwithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorByJoinFetch(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourse());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		// System.out.println(tempInstructor.getCourse());

		// find course for instructor
		List<Course> courses = appDAO.findCourseByInstructorId(theId);
		// associate courses
		tempInstructor.setCourse(courses);
		List<Course> courseOfInstructor = tempInstructor.getCourse();
		courseOfInstructor.stream().forEach(System.out::println);
		// System.out.println(tempInstructor.getCourse());

		// System.out.println(courses);

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("johney", "row1", "abc@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http:///", "codechallenge");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail); // it will save data in both tables
		appDAO.save(tempInstructorDetail);

		// create some course
		Course course1 = new Course("dsaCourse2");
		Course course2 = new Course("SpringbotCourse2");

		tempInstructor.add(course1);
		tempInstructor.add(course2);
		// tempInstructor.setCourse(course1);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourse());

		appDAO.save(tempInstructor);

	}

	private void deleteInstructorDetails(AppDAO appDAO) {
		appDAO.deleteInstruById(107);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 103;
//	Instructor temp = appDAO.findInstructorById(theId);
		Instructor temp = appDAO.findInstructorById(theId);
		System.out.println(temp);
		System.out.println(temp.getInstructor());
	}

	private void createInstructor(AppDAO appDAO) {
		InstructorDetail instructorDetail = new InstructorDetail("http:///", "code");
		Instructor instructor = new Instructor("john167y", "row1", "abc@gmail.com");
		// associate the objects
		instructorDetail.setInstructor(instructor); // it will save data in both tables
		appDAO.save(instructorDetail);
	}
}

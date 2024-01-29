package jpa.one.to.one.uni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jpa.one.to.one.uni.dao.AppDAO;
import jpa.one.to.one.uni.entity.Instructor;
import jpa.one.to.one.uni.entity.InstructorDetail;

@SpringBootApplication
public class JpaOneToOneUnidirectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneUnidirectionApplication.class, args);
	}
@Bean
 public CommandLineRunner commandLineRunner(AppDAO appDAO) {
	 
	 return runner->{
		 System.out.println("Hello i am spring boot project");
		// createInstructor(appDAO);
		 //findInstructor(appDAO);
		 deleteInstructorDetails(appDAO);
	 };
  }
private void deleteInstructorDetails(AppDAO appDAO) {
	appDAO.deleteInstruById(102);
}
private void findInstructor(AppDAO appDAO) {
	int theId = 100;
	Instructor temp = appDAO.findInstructorById(theId);
    System.out.println(temp);
    System.out.println(temp.getInstructorDetail());
}
private void createInstructor(AppDAO appDAO) {
	Instructor instructor = new Instructor("john1","row1","abc@gmail.com");
	InstructorDetail instructorDetail = new InstructorDetail("http:///" , "code");
	//associate the objects
	instructor.setInstructorDetail(instructorDetail); // it will save data in both tables
	appDAO.save(instructor);
}
}

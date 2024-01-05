package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {
		return runner ->{
			//createStudent(studentDAO);
			
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
		//	QueryForStudent(studentDAO);
		//	QueryForStudentByLastName(studentDAO);
			//readStudent(studentDAO);
		};
	}
	
//	private void createStudent(StudentDAO studentDAO) {
//	
//		Student tempStudent = new Student( "Rosalin", "Kandapan", "test@gmail" );
//		studentDAO.save(tempStudent);
//		System.out.println("saved student id:" +tempStudent.getId());
//	}
	
	private void createMultipleStudent(StudentDAO studentDAO) {
		
		Student tempStudent1 = new Student( "student1", "abc", "test@gmail" );
		Student tempStudent2 = new Student( "student2", "xyz", "test@gmail" );
		Student tempStudent3 = new Student( "student3", "mno", "test@gmail" );
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
	}
private void readStudent(StudentDAO studentDAO) {
		Student tempStudent4 = new Student( "student4", "pqr", "test@gmail" );
		studentDAO.save(tempStudent4);
		Student  student=studentDAO.findById(tempStudent4.getId());
		student.setEmail("rosa@gmail.com");
		studentDAO.update(student);
	studentDAO.delete(tempStudent4.getId());
		System.out.println("find student is: "+student);
		int rowNos= studentDAO.deleteAll();
		System.out.println("rowNos" +rowNos);
 }
private void QueryForStudent(StudentDAO studentDAO) {
	List<Student> students =studentDAO.findAll();
	for(Student student: students) {
		System.out.println("student is: "+student);
	}
  }
private void QueryForStudentByLastName(StudentDAO studentDAO) {
	List<Student> students =studentDAO.findByLastName("mno");
	for(Student student: students) {
		System.out.println("student is: "+student);
	}
  }

}

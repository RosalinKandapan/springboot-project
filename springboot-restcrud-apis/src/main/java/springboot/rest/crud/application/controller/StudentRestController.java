package springboot.rest.crud.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import springboot.rest.crud.application.entity.Student;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	
	private List<Student> theStudent;
	
	//define PostConstruct to load the student data
	@PostConstruct
	public void loadDate() {
		theStudent = new ArrayList<>();
		theStudent.add(new Student("ramya","kho"));
		theStudent.add(new Student("rashi", "kho"));
	}
	
@GetMapping("/students")
public List<Student> getAllStudent (){
	return theStudent;
		
	}
@GetMapping("/students/{studentId}")
public Student getStudent (@PathVariable int studentId){
	if((studentId>=theStudent.size())|| (studentId<0 )) {
		throw new StudentNotFoundException("Student Not Found-" + studentId);
	}
	return theStudent.get(studentId);
		
	}

@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
	
	StudentErrorResponse error = new StudentErrorResponse();
	error.setStatus(HttpStatus.NOT_FOUND.value());
	error.setMessage("student id not found");
	error.setTimestamp(System.currentTimeMillis());
	
	return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	
}
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
	
	StudentErrorResponse error = new StudentErrorResponse();
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	error.setMessage(exception.getMessage());
	error.setTimestamp(System.currentTimeMillis());
	
	return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	
}
}

package springboot.rest.crud.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
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

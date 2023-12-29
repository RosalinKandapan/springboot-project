package springboot.rest.crud.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.rest.crud.application.entity.Student;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	@GetMapping("/student")
public List<Student> getAllStudent (){
		
		List<Student> theStudent = new ArrayList<>();
		theStudent.add(new Student("ramya","kho"));
		theStudent.add(new Student("rashi", "kho"));
	return theStudent;
		
	}
}

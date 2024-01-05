package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.entity.Student;
@Service
public interface StudentDAO {
	
 void save(Student student);

 Student findById(long id);
 
  List<Student> findAll();
  
  List<Student> findByLastName(String theLastName);
  
  void update(Student student);
 
  void delete(long id);
  
  int deleteAll();
}

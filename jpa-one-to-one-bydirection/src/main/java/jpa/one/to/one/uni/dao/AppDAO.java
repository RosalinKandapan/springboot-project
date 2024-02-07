package jpa.one.to.one.uni.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jpa.one.to.one.uni.entity.Instructor;
import jpa.one.to.one.uni.entity.InstructorDetail;
//@Service
public interface AppDAO {
	
	void save (InstructorDetail instructorDetail);
	
	//Instructor findInstructorById( int theId);
	
	InstructorDetail findInstructorById( int theId);
	
	void  deleteInstruById (int theId);

	void save(Instructor instructor);

	//void save(Instructor instructor);
	
}

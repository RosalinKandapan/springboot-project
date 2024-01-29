package jpa.one.to.one.uni.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jpa.one.to.one.uni.entity.Instructor;
//@Service
public interface AppDAO {
	
	void save (Instructor instructor);
	
	Instructor findInstructorById( int theId);
	
	void  deleteInstruById (int theId);
	
}

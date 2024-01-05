package com.luv2code.cruddemo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Service
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//@PersistenceContext
	private  EntityManager entityManager;
@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager =entityManager;
	}
@Override
@Transactional
public  void save(Student student) {
		entityManager.persist(student);
	}
@Override
public  Student findById(long id) {
	return entityManager.find(Student.class, id);
 }
@Override
public List<Student> findAll() {
	//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class); //retrive all student
	TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class); //lastname will be ascending order
	return theQuery.getResultList();
}
@Override
public List<Student> findByLastName(String theLastName) {
	TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where  lastName=:theData", Student.class); //particular lastname student object will return
	theQuery.setParameter("theData", theLastName);
	return theQuery.getResultList();
 }
@Override
@Transactional
public void update(Student student) {
 entityManager.merge(student);	
}
@Override
@Transactional
public void delete(long id) {
Student student = entityManager.find(Student.class, id);	
entityManager.remove(student);
}

@Override
@Transactional
public int deleteAll() {
int  numofrows= entityManager.createQuery("DELETE FROM Student").executeUpdate(); 
return numofrows;
 }
}
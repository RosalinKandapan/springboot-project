package jpa.one.to.one.uni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jpa.one.to.one.uni.entity.Instructor;

@Repository
public class AppDAOImpl implements AppDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
		
		
	}

	@Override
	public Instructor findInstructorById(int theId) {
	return	entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstruById(int theId) {
		Instructor temp= entityManager.find(Instructor.class, theId);
		entityManager.remove(temp);
	}

	
}

package spring.boot.rest.crud.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import spring.boot.rest.crud.employee.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	//define field of entity manager
	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theentityManager) {
		entityManager = theentityManager;
	}
	
	@Override
	public List<Employee> finsAll() {
		//create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the result
		return employees;
	}

}

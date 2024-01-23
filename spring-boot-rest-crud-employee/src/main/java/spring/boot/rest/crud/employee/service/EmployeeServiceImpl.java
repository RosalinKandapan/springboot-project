package spring.boot.rest.crud.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.rest.crud.employee.dao.EmployeeDAO;
import spring.boot.rest.crud.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private  EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
	        employeeDAO = theEmployeeDAO;
	}
	@Override
	public List<Employee> findAll() {
		return employeeDAO.finsAll();
	}

	
}

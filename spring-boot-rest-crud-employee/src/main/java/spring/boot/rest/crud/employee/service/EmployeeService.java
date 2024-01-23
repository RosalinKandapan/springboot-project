package spring.boot.rest.crud.employee.service;

import java.util.List;

import spring.boot.rest.crud.employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

}

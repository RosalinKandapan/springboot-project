package spring.boot.rest.crud.employee.dao;

import java.util.List;

import spring.boot.rest.crud.employee.entity.Employee;

public interface EmployeeDAO {

	List<Employee> finsAll();
}

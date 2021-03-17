package com.app.repo;

import java.util.List;

import com.app.entity.Employee;

public interface EmployeeRepo {

	public Boolean saveEmployee(Employee employee);

	public List<Employee> listOfEmployees();
}

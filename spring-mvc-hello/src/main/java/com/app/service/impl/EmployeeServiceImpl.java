package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Boolean saveOrUpdate(Employee employee) {
		return employeeRepository.saveOrUpdate(employee);
	}

	public Boolean deleteEmployee(Integer id) {
		return employeeRepository.deleteEmployee(id);
	}

	public Employee getEmployeeById(Integer id) {
		return employeeRepository.getEmployeeById(id);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.getEmployees();
	}

}

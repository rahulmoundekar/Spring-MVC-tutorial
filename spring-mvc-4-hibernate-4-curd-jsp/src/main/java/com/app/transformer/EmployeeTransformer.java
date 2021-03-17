package com.app.transformer;

import com.app.dto.EmployeeDto;
import com.app.entity.Employee;

public class EmployeeTransformer {

	public static Employee employeeBeanToEnity(EmployeeDto employeeDto) {

		Employee employee = new Employee();
		if (employee.getId() != null)
			employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		return employee;
	}

}

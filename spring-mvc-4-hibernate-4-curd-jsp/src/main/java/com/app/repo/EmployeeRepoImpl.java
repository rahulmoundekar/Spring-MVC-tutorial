package com.app.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	@Autowired
	private SessionFactory sessionFactory;

	Boolean flag = Boolean.FALSE;

	@Override
	public Boolean saveEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		flag = Boolean.TRUE;
		return flag;
	}

	@Override
	public List<Employee> listOfEmployees() {
		return sessionFactory.openSession().createCriteria(Employee.class).list();
	}

}

package com.blakelong.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blakelong.springboot.cruddemo.entity.Employee;


//***************** JPA API DAO Implementation ********************


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		
		// create query
		Query query = entityManager.createQuery("FROM Employee");
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Employee dbEmployee = entityManager.merge(employee);
		
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
//		Query query = entityManager/createQuery("DELETE FROM Employee WHERE id=:employeeId");
		
//		query.setParameter("employeeId", id);
	}
}

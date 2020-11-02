package com.blakelong.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blakelong.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	// define field for EntityManager and inject as instance of EntityManager
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		// save or update based on id being 0 or not
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery("DELETE FROM Employee WHERE id=:employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}

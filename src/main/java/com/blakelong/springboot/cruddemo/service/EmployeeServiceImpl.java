package com.blakelong.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blakelong.springboot.cruddemo.dao.EmployeeDAO;
import com.blakelong.springboot.cruddemo.dao.EmployeeRepository;
import com.blakelong.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
//	@Autowired
//	@Qualifier("employeeDAOJpaImpl")
//	EmployeeDAO employeeDAO;
	
	// JPA provides @Transactional out of the box
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
//	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
//	@Transactional
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return employee;
	}

	@Override
//	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
//	@Transactional
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}

package com.blakelong.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blakelong.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// CRUD methods now available from Spring Data JPA
}

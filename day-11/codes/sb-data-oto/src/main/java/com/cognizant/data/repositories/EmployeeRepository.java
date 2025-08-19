package com.cognizant.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.data.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

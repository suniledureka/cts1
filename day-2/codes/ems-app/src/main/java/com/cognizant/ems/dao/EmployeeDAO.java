package com.cognizant.ems.dao;

import java.util.List;

import com.cognizant.ems.models.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee emp);
	public List<Employee> listEmployees();
}

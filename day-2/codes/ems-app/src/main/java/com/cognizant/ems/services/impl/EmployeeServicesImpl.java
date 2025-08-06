package com.cognizant.ems.services.impl;

import java.util.List;

import com.cognizant.ems.dao.EmployeeDAO;
import com.cognizant.ems.models.Employee;
import com.cognizant.ems.services.EmployeeServices;

public class EmployeeServicesImpl implements EmployeeServices {
	private EmployeeDAO empDAO;
	
	public EmployeeServicesImpl(EmployeeDAO empDAO) {
		super();
		this.empDAO = empDAO;
	}

	@Override
	public void addEmployee(Employee emp) {
		boolean addStatus = empDAO.addEmployee(emp);
		if(addStatus)
			System.out.println("Employee Saved to Data Store");
		else
			System.err.println("Employee with Employee ID: "+ emp.getEmployeeId() + " already exists!!!" );
	}

	@Override
	public void listEmployees() {
		List<Employee> emps = empDAO.listEmployees();
		emps.stream().forEach(System.out::println);
	}

}

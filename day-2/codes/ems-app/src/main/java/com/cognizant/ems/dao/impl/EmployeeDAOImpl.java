package com.cognizant.ems.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.ems.dao.EmployeeDAO;
import com.cognizant.ems.models.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private List<Employee> emps = new ArrayList<Employee>();
	
	@Override
	public boolean addEmployee(Employee emp) {
		for(Employee e : emps) {
			if(emp.getEmployeeId().equals(e.getEmployeeId())) {
				return false;
			}
		}
		
		//add new employee to list
		emps.add(emp);
		return true;
	}

	@Override
	public List<Employee> listEmployees() {
		return emps;
	}

}

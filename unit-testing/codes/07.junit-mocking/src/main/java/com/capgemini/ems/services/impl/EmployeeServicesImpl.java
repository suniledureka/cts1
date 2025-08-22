package com.capgemini.ems.services.impl;

import java.util.List;

import com.capgemini.ems.services.EmployeeServices;
import com.cognizant.ems.dao.EmployeeDAO;

public class EmployeeServicesImpl implements EmployeeServices {
	private EmployeeDAO dao;
	
	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String getEmployeeNameById(int eid) {
		String empName = dao.findEmployeeNameById(eid);
		return empName;
	}

	@Override
	public List<String> findAllNames() {
		List<String> empNames = dao.findEmployeeNames();
		if(empNames.isEmpty())
			return null;
		
		return empNames;
	}	
}

package com.cognizant.ems.dao;

import java.util.List;

public interface EmployeeDAO {
	public String findEmployeeNameById(int eid);
	
	public List<String> findEmployeeNames();
}

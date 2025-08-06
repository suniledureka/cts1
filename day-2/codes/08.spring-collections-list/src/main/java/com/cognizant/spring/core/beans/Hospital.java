package com.cognizant.spring.core.beans;

import java.util.List;

public class Hospital {
	private String hospitalName;
	private List<String> deptNames;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public List<String> getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(List<String> deptNames) {
		this.deptNames = deptNames;
	}
}

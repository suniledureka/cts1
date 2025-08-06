package com.cognizant.spring.core.beans;

import java.util.Set;
import java.util.Set;

public class Hospital {
	private String hospitalName;
	private Set<String> deptNames;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Set<String> getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(Set<String> deptNames) {
		this.deptNames = deptNames;
	}

}

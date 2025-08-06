package com.cognizant.spring.core.beans;

import java.util.Map;

public class Hospital {
	private String hospitalName;
	private Map<String, String> deptsHeads;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Map<String, String> getDeptsHeads() {
		return deptsHeads;
	}

	public void setDeptsHeads(Map<String, String> deptsHeads) {
		this.deptsHeads = deptsHeads;
	}
}
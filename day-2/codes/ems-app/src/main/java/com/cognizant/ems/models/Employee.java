package com.cognizant.ems.models;

public class Employee {
	private Integer employeeId;
	private String employeeName;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return String.format("Employee [ %d   %-20s ]", employeeId, employeeName);
	}

}

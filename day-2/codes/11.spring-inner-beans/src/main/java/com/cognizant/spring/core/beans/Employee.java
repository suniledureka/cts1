package com.cognizant.spring.core.beans;

public class Employee {
	private Integer employeeNo;
	private String employeeName;
	private Address employeeAddress;

	public Integer getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeName=" + employeeName + "]";
	}

}

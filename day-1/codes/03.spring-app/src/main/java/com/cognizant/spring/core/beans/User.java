package com.cognizant.spring.core.beans;

public class User {
	private String firstName;
	private String lastName;

	public User() {
		System.out.println("no argument constructor");
	}

	public User(String firstName, String lastName) {
		System.out.println("2 args constructor");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		System.out.println("inside getFirstName() method");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("inside setFirstName() method");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("inside getLastName() method");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("inside setLastName() method");
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public void myInit1() {
		System.out.println("user-defined initialization-1");
	}

	public void myInit2() {
		System.out.println("user-defined initialization-2");
	}	
	
	public void myDestroy() {
		System.out.println("user-defined destructor");
	}
}

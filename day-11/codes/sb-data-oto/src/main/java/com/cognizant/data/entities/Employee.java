package com.cognizant.data.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	private String employeeName;
	
	//@OneToOne(cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addr_id")
	private Address employeeAddress;
}

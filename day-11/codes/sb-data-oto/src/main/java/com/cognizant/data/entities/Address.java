package com.cognizant.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	private Integer adddressId;
	private String street;
	private String city;
	private String state;
}

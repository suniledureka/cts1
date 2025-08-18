package com.cognizant.irctc.models;

import java.time.LocalDate;

import com.cognizant.irctc.controllers.adapters.LocalDateAdapter;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Passenger {
	@NotNull(message = "required")
	private String passengerName;
	
	@NotEmpty(message = "fromStatic is Required")
	private String fromStation;
	
	@NotBlank(message = "toStation is Required")
	private String toStation;	
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@Future
	//@FutureOrPresent
	//@Past
	//@PastOrPresent
	private LocalDate dateOfJourney;
	
	@NotNull
	@Size(min = 3, max = 6)
	private String trainNo;
}

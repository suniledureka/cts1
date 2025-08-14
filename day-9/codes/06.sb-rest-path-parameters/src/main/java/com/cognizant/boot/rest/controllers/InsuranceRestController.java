package com.cognizant.boot.rest.controllers;

import java.time.LocalDate;
import java.time.Year;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class InsuranceRestController {
	
	@GetMapping("/{name}/{yob}")
	public ResponseEntity<?> checkEligibilityforPolicy(@PathVariable String name,
													   @PathVariable Integer yob){
		//-- age should be >= 20 for this insurance eligibility
		boolean isEligible = checkEligibility(yob);
		
		if(isEligible)
			return ResponseEntity.ok(name + ", can enroll for this Policy");
		
		return ResponseEntity.badRequest().build();
	}

	private boolean checkEligibility(Integer yob) {
		Year year = Year.now();
		int currentYear = year.getValue();
		//int currentYear = LocalDate.now().getYear();
		int age = currentYear - yob;
		return age >= 20 ? true : false;
	}
}

package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cibil")
public class CibilRestController {
	
	//@GetMapping(path = "/score/{name}/{pan}")
	@GetMapping(path = "/{name}/{pan}/score")
	public ResponseEntity<?> findCibilScore(@PathVariable("name") String customerName, 
											@PathVariable(value = "pan", required = false) String pan){
		if(pan != null && pan.length() == 10) {
			//get the cibil score from data store
			int cibilScore = 798;
			String msg = String.format("Hi %s, your PAN is %s, & your CIBIL Score is %d", customerName, pan, cibilScore);
			return ResponseEntity.ok().body(msg);
		}else {
			return ResponseEntity.badRequest().body("Please provide a Valid PAN");
		}
	}
}

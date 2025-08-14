package com.cognizant.boot.rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateRestController {

	@GetMapping(path = {"/date", "/today"})
	public ResponseEntity<String> showTodaysDateAndTime() {
		LocalDateTime localDt = LocalDateTime.now();
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		String dateTime = localDt.format(dtFormatter);
		
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.CREATED);
		
		//---- include response headers in ResponseEntity ------
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("company", "Cognizant");
		responseHeaders.add("location", "Hyderabad");
		responseHeaders.add("contact", "Vamsi");
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, responseHeaders, HttpStatus.OK);
		//return responseEntity;
		
		ResponseEntity<String> responseEntity = ResponseEntity.ok(dateTime);
		//return responseEntity;
		
		//return ResponseEntity.ok(dateTime);
		//return ResponseEntity.ok().body(dateTime);
		return ResponseEntity.badRequest().body(dateTime);
	}
}

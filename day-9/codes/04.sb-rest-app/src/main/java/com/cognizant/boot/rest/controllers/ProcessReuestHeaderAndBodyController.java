package com.cognizant.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProcessReuestHeaderAndBodyController {
	
	@PostMapping(path = "/data")
	public ResponseEntity<?> processRequestHeaderAndData(@RequestHeader("Host") String hostName,
														 @RequestHeader(name = "company", required=false, defaultValue = "NA") String company,
														 @RequestBody(required = false) String requestData){
		String responseText = String.format("Host: %s\nCompany: %s\nRequest Data: %s", hostName, company, requestData);
		
		ResponseEntity<String> respEntity = new  ResponseEntity<String>(responseText, HttpStatus.OK);
		if(requestData==null)
			//respEntity = new  ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			respEntity = ResponseEntity.badRequest().build();
		
		return respEntity;
	}
}

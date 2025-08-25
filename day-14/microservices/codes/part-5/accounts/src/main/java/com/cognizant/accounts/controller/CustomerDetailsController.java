package com.cognizant.accounts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accounts.dto.CustomerDetailsDto;
import com.cognizant.accounts.service.ICustomerDetailsService;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@Validated
@AllArgsConstructor
public class CustomerDetailsController {
	private ICustomerDetailsService service;
	
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber){
      CustomerDetailsDto custDetailsDto = service.fetchCustomerDetails(mobileNumber);
      return ResponseEntity.ok().body(custDetailsDto);
    }

}

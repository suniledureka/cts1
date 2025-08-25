package com.cognizant.accounts.service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.accounts.dto.LoansDto;


@FeignClient("LOANS")
public interface LoansFeignClient {
	   @GetMapping("/api/fetch")
	   public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber); 
}

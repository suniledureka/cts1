package com.cognizant.accounts.service;

import com.cognizant.accounts.dto.CustomerDetailsDto;

public interface ICustomerDetailsService {
	
	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);

}

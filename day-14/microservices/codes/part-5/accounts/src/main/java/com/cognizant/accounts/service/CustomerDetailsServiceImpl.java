package com.cognizant.accounts.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.accounts.dto.AccountsDto;
import com.cognizant.accounts.dto.CardsDto;
import com.cognizant.accounts.dto.CustomerDetailsDto;
import com.cognizant.accounts.dto.LoansDto;
import com.cognizant.accounts.entity.Accounts;
import com.cognizant.accounts.entity.Customer;
import com.cognizant.accounts.exception.ResourceNotFoundException;
import com.cognizant.accounts.mapper.AccountsMapper;
import com.cognizant.accounts.mapper.CustomerMapper;
import com.cognizant.accounts.repository.AccountsRepository;
import com.cognizant.accounts.repository.CustomerRepository;
import com.cognizant.accounts.service.clients.CardsFeignClient;
import com.cognizant.accounts.service.clients.LoansFeignClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerDetailsServiceImpl implements ICustomerDetailsService {
	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    
	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccounts(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoans(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCards(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
	}
}

package com.cognizant.accounts.dto;

import lombok.Data;

@Data
public class CustomerDetailsDto {
	private String name;
	private String email;
	private String mobileNumber;
	private AccountsDto accounts;

	private CardsDto cards;
	private LoansDto loans;

}

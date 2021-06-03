package com.india.icicibank.service;




import com.india.icicibank.dto.AccountDetailsDto;
import com.india.icicibank.dto.CustomerRegistrationDto;
import com.india.icicibank.entity.Account;
import com.india.icicibank.entity.Customer;
import com.india.icicibank.exception.CustomerNotFoundException;
import com.india.icicibank.exception.FromAccountNumberNotFoundException;

public interface CustomerRegistrationService {

	public String addNewCustomerDetails(CustomerRegistrationDto customerRegistrationDto) throws CustomerNotFoundException;
	public  AccountDetailsDto getAccountDetails(Long accountNo) ;

	

}

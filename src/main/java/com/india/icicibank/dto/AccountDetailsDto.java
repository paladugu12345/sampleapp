package com.india.icicibank.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.india.icicibank.entity.Customer;

public class AccountDetailsDto {
	@Digits(integer = 8, fraction = 1, message = "InValid accountNumber")
	private long accountNumber;
	@NotEmpty(message = "ifsccode should not be empty")
	@Size(min = 8, max = 20,message = " ifsccode should less then 20 character only")
	private String ifsccode;
	@NotEmpty(message = "balance should not be empty")
	@NotNull(message = "please provide valid balance")
	@Size(min = 5, max = 10, message = "please provide valid balance")
	private Double openingbalance;
	private Double currentbalance;
	//private long customerId;
	private String accountType;
	private String branchAddress;
	private Customer customerDetails; 
	
    public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Double getOpeningbalance() {
		return openingbalance;
	}

	public void setOpeningbalance(Double openingbalance) {
		this.openingbalance = openingbalance;
	}

	public Double getCurrentbalance() {
		return currentbalance;
	}

	public void setCurrentbalance(Double currentbalance) {
		this.currentbalance = currentbalance;
	}
	
	
//	public long getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

		// TODO Auto-generated method stub
		
	
	
}

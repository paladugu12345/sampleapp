package com.india.icicibank.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "accountNumber")
	private long accountNumber;
	private String ifsccode;
    private Double currentbalance;
	private Double openingbalance;
	private String accountType;
	private String branchAddress;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customerDetails;

	//	private long customerId;
	public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
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
	public Double getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(Double currentbalance) {
		this.currentbalance = currentbalance;
	}
	public Double getOpeningbalance() {
		return openingbalance;
	}
	public void setOpeningbalance(Double openingbalance) {
		this.openingbalance = openingbalance;
	}
	
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
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	/*public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}*/
	
	
}

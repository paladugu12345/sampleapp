package com.india.icicibank.entity;


import java.sql.Timestamp;
//import java.util.Date
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Transaction  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transacionId;
	private Timestamp transactionDate;
	private long accountNo;
	//private long toAccount;
	private Double amount;
	private Double currentBal;
	private String credit_debit;
	private String remarks;
	
	
	public long getTransacionId() {
		return transacionId;
	}
	public void setTransacionId(long transacionId) {
		this.transacionId = transacionId;
	}
	/*public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}*/
	/*public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
*/	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getCurrentBal() {
		return currentBal;
	}
	public void setCurrentBal(Double currentBal) {
		this.currentBal = currentBal;
	}
	public String getCredit_debit() {
		return credit_debit;
	}
	public void setCredit_debit(String credit_debit) {
		this.credit_debit = credit_debit;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	
	
	
	
}
	
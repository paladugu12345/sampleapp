package com.india.icicibank.service;

import java.util.List;

import com.india.icicibank.dto.FundTransferRequestDto;
import com.india.icicibank.entity.Transaction;
import com.india.icicibank.exception.FromAccountNumberNotFoundException;
import com.india.icicibank.exception.InavalidAccountException;
import com.india.icicibank.exception.InsufficientBalanceException;
import com.india.icicibank.exception.ToAccountNumberNotFoundException;

public interface FundTranferService {
	public List<Transaction> sendMoney(FundTransferRequestDto fundTransferRequestDto) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException,InavalidAccountException;
}

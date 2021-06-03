package com.india.icicibank.service;

import java.text.ParseException;
import java.util.List;

import com.india.icicibank.dto.EstatementDto;
import com.india.icicibank.entity.Transaction;

public interface MonthlyEstatementService {
	public List<Transaction> getMonthlyStatement(Long acno, String year,String month) throws ParseException; //throws ParseException

	public List<Transaction> monthlyStatement(EstatementDto statement);

	

}

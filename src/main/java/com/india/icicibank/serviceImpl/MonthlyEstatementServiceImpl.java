
package com.india.icicibank.serviceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.icicibank.dto.EstatementDto;
import com.india.icicibank.entity.Transaction;
import com.india.icicibank.repository.TransactionHistoryRepository;
import com.india.icicibank.service.MonthlyEstatementService;

@Service
public class MonthlyEstatementServiceImpl implements MonthlyEstatementService {
	@Autowired
	public TransactionHistoryRepository transHistoryRepo;

	@Override
	public List<Transaction> getMonthlyStatement(Long acno, String year,String month) throws ParseException 
	{
		int monthValue = Integer.valueOf(month);
		int yearValue = Integer.valueOf(year);
		
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.clear();
		calendar1.set(Calendar.MONTH, monthValue - 1);
		calendar1.set(Calendar.YEAR, yearValue);
		calendar1.set(Calendar.DATE, 01);
		Calendar fromdate = calendar1;
		
		LocalDateTime fromdate2 = getLocalDateTime(fromdate);
		int lastdate = calendar1.getActualMaximum(Calendar.DATE);
		calendar2.set(Calendar.MONTH, monthValue - 1);
		calendar2.set(Calendar.YEAR, yearValue);
		calendar2.set(Calendar.DATE, lastdate);
		Calendar todate = calendar2;
		
		LocalDateTime todate2 = getLocalDateTime(todate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = fromdate2.format(formatter);
		String toDateTime = todate2.format(formatter);
		
		java.util.Date transdate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formatDateTime);
		java.util.Date transdate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(toDateTime);
		
		Timestamp startDate = new Timestamp(transdate1.getTime());
		Timestamp endDate = new Timestamp(transdate2.getTime());
		
		List<Transaction> transList = transHistoryRepo.getTransDataByacNoAndDate(acno, startDate, endDate);
		return transList;
	}

	private static LocalDateTime getLocalDateTime(Calendar calendar) {

		return LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
	}


	@Override
	public List<Transaction> monthlyStatement(EstatementDto statement) {
		List<Transaction> monthlyStatement=new ArrayList<Transaction>();
		List<Transaction> details=transHistoryRepo.findByAccountNo(statement.getAccountNo());
		System.out.println("trans Size:"+details.size());
		for (Transaction transactionDetails : details) {
			Transaction transactionStatement=new Transaction(); 
			if(transactionDetails.getTransactionDate().getMonth()+1==statement.getMonth() &&
					transactionDetails.getTransactionDate().getYear()+1900==statement.getYear()	) {
				transactionStatement.setAccountNo(transactionDetails.getAccountNo());
				transactionStatement.setAmount(transactionDetails.getAmount());
				//transactionStatement.setToAccount(transactionDetails.getToAccount());
				transactionStatement.setTransacionId(transactionDetails.getTransacionId());
				transactionStatement.setTransactionDate(transactionDetails.getTransactionDate());
				monthlyStatement.add(transactionStatement);
			}
			
			
		}
		
		return monthlyStatement;
	}
}

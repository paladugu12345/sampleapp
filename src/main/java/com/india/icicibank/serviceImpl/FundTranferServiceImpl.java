package com.india.icicibank.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.icicibank.dto.FundTransferRequestDto;
import com.india.icicibank.entity.Account;
import com.india.icicibank.entity.Transaction;
import com.india.icicibank.exception.FromAccountNumberNotFoundException;
import com.india.icicibank.exception.InavalidAccountException;
import com.india.icicibank.exception.InsufficientBalanceException;
import com.india.icicibank.exception.ToAccountNumberNotFoundException;
import com.india.icicibank.repository.BankAccountDetailsRepository;
import com.india.icicibank.repository.TransactionHistoryRepository;
import com.india.icicibank.service.FundTranferService;
@Service
public class FundTranferServiceImpl implements FundTranferService{
	@Autowired
	public BankAccountDetailsRepository bankAccDetailsRepo;
	@Autowired
	public TransactionHistoryRepository transHistoryRepo;
	
	@Override
	public List<Transaction> sendMoney(FundTransferRequestDto fundTransferRequestDto) throws InsufficientBalanceException, FromAccountNumberNotFoundException, ToAccountNumberNotFoundException, InavalidAccountException {
		Transaction sourceAcc= new Transaction();
		Transaction targetAcc= new Transaction();
		List<Transaction> listTransHistroy=new ArrayList<Transaction>();
		 java.util.Date date=new java.util.Date();
         long time=date.getTime();
         Timestamp ts=new Timestamp(time);

		Optional<Account> fromacc = bankAccDetailsRepo.findByAccountNumber(fundTransferRequestDto.getFromAccount());
		if (fromacc.isPresent()) {
			Optional<Account> toacc = bankAccDetailsRepo.findByAccountNumber(fundTransferRequestDto.getToAccount());
			if (toacc.isPresent()) {
		long fromAccountNumber = fundTransferRequestDto.getFromAccount();
        long toAccountNumber = fundTransferRequestDto.getToAccount();
        if(fromAccountNumber==toAccountNumber)
        	throw new InavalidAccountException("from and to accountnumber is same");
        Account fromAccount = fromacc.get();
        Account toAccount = toacc.get();
        
        if (fromAccount.getCurrentbalance() >= fundTransferRequestDto.getAmount()) {
        	double fromaccbal=fromAccount.getCurrentbalance() - fundTransferRequestDto.getAmount();
        	double toAccbal=toAccount.getCurrentbalance() + fundTransferRequestDto.getAmount();
        	fromAccount.setCurrentbalance((fromAccount.getCurrentbalance() - fundTransferRequestDto.getAmount()));
       	     sourceAcc.setAccountNo(fromAccountNumber);
       	     //sourceAcc.setToAccount(toAccountNumber);
        	 sourceAcc.setAmount(fundTransferRequestDto.getAmount());
       	     sourceAcc.setCurrentBal(fromaccbal);
       	     sourceAcc.setCredit_debit("debit");
       	     sourceAcc.setRemarks(fundTransferRequestDto.getRemarks());
             sourceAcc.setTransactionDate(ts);
        	 bankAccDetailsRepo.save(fromAccount);
        	 Transaction transaction1= transHistoryRepo.save(sourceAcc);
        	 toAccount.setCurrentbalance((toAccount.getCurrentbalance() + fundTransferRequestDto.getAmount()));

        	 targetAcc.setAccountNo(toAccountNumber);
        	// targetAcc.setToAccount(fromAccountNumber);
        	 targetAcc.setAmount(fundTransferRequestDto.getAmount());
        	 targetAcc.setCurrentBal(toAccbal);
        	 targetAcc.setCredit_debit("credit");
        	 targetAcc.setRemarks(fundTransferRequestDto.getRemarks());
        	 targetAcc.setTransactionDate(ts);
        	 bankAccDetailsRepo.save(toAccount);
        	 Transaction transaction2= transHistoryRepo.save(targetAcc);
        	 listTransHistroy.add(transaction1);
        	 listTransHistroy.add(transaction2);
        }
        else {
			throw new InsufficientBalanceException("Insufficiant Amount !!!!");
		}

	} else {
		throw new ToAccountNumberNotFoundException("To Account number Not found");
	}
} else {
	throw new FromAccountNumberNotFoundException("From Account Number Not Found");
}
		return listTransHistroy;

}
}

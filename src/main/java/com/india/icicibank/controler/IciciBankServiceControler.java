package com.india.icicibank.controler;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.india.icicibank.dto.AccountDetailsDto;
import com.india.icicibank.dto.CustomerRegistrationDto;
import com.india.icicibank.dto.EstatementDto;
import com.india.icicibank.dto.FundTransferRequestDto;
import com.india.icicibank.entity.Account;
import com.india.icicibank.entity.Customer;
import com.india.icicibank.entity.Transaction;
import com.india.icicibank.exception.CustomerNotFoundException;
import com.india.icicibank.exception.FromAccountNumberNotFoundException;
import com.india.icicibank.exception.InsufficientBalanceException;
import com.india.icicibank.exception.ToAccountNumberNotFoundException;
import com.india.icicibank.service.CustomerRegistrationService;
import com.india.icicibank.service.FundTranferService;
import com.india.icicibank.service.MonthlyEstatementService;

@Validated
@RestController
@RequestMapping("/icicibankdetails")
public class IciciBankServiceControler {
	@Autowired
	private CustomerRegistrationService customerRegistrationService ;
	@Autowired
	public FundTranferService fundTranferService;
	@Autowired
	public MonthlyEstatementService monthlyEstmtService;
	
@PostMapping("/addnewcustomer")	
public ResponseEntity<String> customerRegistration(@Valid @RequestBody  CustomerRegistrationDto customerRegistrationDto) throws Exception
{
		String response= customerRegistrationService.addNewCustomerDetails(customerRegistrationDto);
		return new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.OK);
	}

@PostMapping("/fundtranfer")
public List<Transaction> sendMoney(@Valid @RequestBody FundTransferRequestDto fundTransferRequestDto) throws Exception
{
	return fundTranferService.sendMoney(fundTransferRequestDto);

}

@GetMapping("/acouunt/{accountNo}")
public AccountDetailsDto getAccountDetails(@PathVariable Long accountNo)
{
	return customerRegistrationService.getAccountDetails(accountNo);
	
}
/*@GetMapping("/acouunt/{accountNo}")
public AccountDetailsDto getAccountDetails(@PathVariable Long accountNo) throws FromAccountNumberNotFoundException
{
	return customerRegistrationService.getAccountDetails(accountNo);
	
}*/


@GetMapping("/montlystatement/{fromAccount}/{year}/{month}")
public List<Transaction> getMiniStatement(@Valid @PathVariable("fromAccount")  long fromAccount,
		@PathVariable("year") String year,@PathVariable("month") String month) throws ParseException {
	List<Transaction> statement = monthlyEstmtService.getMonthlyStatement(fromAccount, year,month);
	return statement;
}

@PostMapping("/monthlyStatement")
public List<Transaction>  monthlyStatement(@Valid @RequestBody EstatementDto statement) {
	return monthlyEstmtService.monthlyStatement(statement);
	
}

}

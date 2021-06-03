package com.india.icicibank.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.india.icicibank.dto.AccountDetailsDto;
import com.india.icicibank.dto.CustomerRegistrationDto;
import com.india.icicibank.entity.Account;
import com.india.icicibank.entity.Customer;
import com.india.icicibank.exception.CustomerNotFoundException;
import com.india.icicibank.exception.FromAccountNumberNotFoundException;
import com.india.icicibank.repository.BankAccountDetailsRepository;
import com.india.icicibank.repository.CustomerDetailRepository;
import com.india.icicibank.repository.TransactionHistoryRepository;
import com.india.icicibank.service.CustomerRegistrationService;
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{

	@Autowired
	public CustomerDetailRepository customerDetailRep;
	@Autowired
	public BankAccountDetailsRepository bankAccdetails;
	@Autowired
	public TransactionHistoryRepository iciciBankTransDetRepo;
	@Override
	public String addNewCustomerDetails(CustomerRegistrationDto customerRegistrationDto) throws CustomerNotFoundException {
		Customer newcustomerDetils=new Customer();
		Account acc=new Account();
		if(customerRegistrationDto!=null)
		{
			
			Customer panDetails = customerDetailRep.findByPannumber(customerRegistrationDto.getPannumber());
			/*try
			{*/
			if(panDetails==null)
			{
				BeanUtils.copyProperties(customerRegistrationDto, newcustomerDetils);
				customerDetailRep.save(newcustomerDetils);
				AccountDetailsDto accDetailsDto=new AccountDetailsDto();
				accDetailsDto.setAccountNumber(accnoGeneration());
				accDetailsDto.setAccountType("saving");
				accDetailsDto.setIfsccode("icici1044");
				accDetailsDto.setBranchAddress("hyd");
				accDetailsDto.setOpeningbalance(10000.00);
				accDetailsDto.setCurrentbalance(10000.00);
				accDetailsDto.setCustomerDetails(newcustomerDetils);
				//accDetailsDto.setCustomerId(newcustomerDetils.getCustomerId());
				BeanUtils.copyProperties(accDetailsDto, acc);
				bankAccdetails.save(acc);
			}
			
			
			else if(newcustomerDetils.getPannumber().equalsIgnoreCase(panDetails.getPannumber()))
			{
				
				//return "customer allready existing";

				throw new NullPointerException("customer allready existing");

			}else if(!(newcustomerDetils.getPannumber().equalsIgnoreCase(panDetails.getPannumber())))
			{
				BeanUtils.copyProperties(customerRegistrationDto, newcustomerDetils);
				customerDetailRep.save(newcustomerDetils);
				
				AccountDetailsDto accDetailsDto=new AccountDetailsDto();
				accDetailsDto.setAccountNumber(accnoGeneration());
				accDetailsDto.setAccountType("saving");
				accDetailsDto.setIfsccode("icici1044");
				accDetailsDto.setBranchAddress("hyd");
				accDetailsDto.setOpeningbalance(10000.00);
				accDetailsDto.setCurrentbalance(10000.00);
				accDetailsDto.setCustomerDetails(newcustomerDetils);

				//accDetailsDto.setCustomerId(newcustomerDetils.getCustomerId());
				BeanUtils.copyProperties(accDetailsDto, acc);
				bankAccdetails.save(acc);
			}
			
		//}
//			catch(NullPointerException e)
//			{
//				return "customer allready existing";
//			}
		}
		else
		{
			throw new CustomerNotFoundException("customer doesn't have valid input data");


		}
		return "customer registered successfully";
			
		}

	public static int accnoGeneration() {
		int n=9;
	    int m = (int) Math.pow(10, n - 1);
	    return m + new Random().nextInt(9 * m);
	}

	@Override
	public AccountDetailsDto getAccountDetails(Long accountNo)  {
		// TODO Auto-generated method stub
		AccountDetailsDto accountDetailsDto=new AccountDetailsDto();
		//accountDetailsDto=bankAccdetails.findByAccountNumber(accountNo);
		Optional<Account> account= bankAccdetails.findByAccountNumber(accountNo);
		if(account.isPresent())
		{
		
		Account acc=account.get();
		accountDetailsDto.setAccountNumber(acc.getAccountNumber());
		accountDetailsDto.setCurrentbalance(acc.getCurrentbalance());
		accountDetailsDto.setOpeningbalance(acc.getOpeningbalance());
		return accountDetailsDto; 

		}
	
		return null;
	}

}

	

	





package com.india.icicibank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.india.icicibank.dto.AccountDetailsDto;
import com.india.icicibank.entity.Account;

public interface BankAccountDetailsRepository extends JpaRepository<Account,Long> {


	@Query(" select accdetl from Account accdetl where accountNumber=:accountNumber")
	public Optional<Account> findByAccountNumber(@Param("accountNumber") long accountNumber);

	//@Query(" select accdetl from Account accdetl where accountNumber=:accountNumber")
//	public Account findByAccountDetails(@Param("accountNumber") long accountNumber);


}

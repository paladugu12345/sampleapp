package com.india.icicibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.india.icicibank.entity.Account;
import com.india.icicibank.entity.Customer;

@Repository

public interface CustomerDetailRepository extends JpaRepository<Customer,Long>{
	Customer findByPannumber(String pannumber);


}

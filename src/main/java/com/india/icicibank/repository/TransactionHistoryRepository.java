package com.india.icicibank.repository;


import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.india.icicibank.entity.Transaction;

public interface TransactionHistoryRepository extends JpaRepository<Transaction,Long>{

	
	@Query(value="select *from transaction  where account_no=:frmaccount and transaction_date between :transdate1 and :transdate2", nativeQuery=true)
	public List<Transaction> getTransDataByacNoAndDate(@Param("frmaccount")long frmaccount,@Param("transdate1") Timestamp transdate1, @Param("transdate2")Timestamp transdate2);

	public  List<Transaction> findByAccountNo(Long accountNo) ;




}

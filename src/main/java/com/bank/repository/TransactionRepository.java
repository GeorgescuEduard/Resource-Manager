package com.bank.repository;


import com.bank.models.Transaction;
import com.bank.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Wallet> {

    public List<Transaction> findByid(Long id);
}

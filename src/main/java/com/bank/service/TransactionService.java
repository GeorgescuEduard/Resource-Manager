package com.bank.service;

import com.bank.models.Transaction;

import java.util.List;

public interface TransactionService {

    public Transaction findTransaction(Long transaction);

    public List<Transaction> findAllTransactions();

    public List<Transaction> findUserTransaction(Long id);

    public Transaction add(Transaction transaction);

    public Transaction update(Transaction transaction);

    public void delete(Long id);
}

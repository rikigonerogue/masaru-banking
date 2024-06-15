package com.sda.masarubanking.service;

import com.sda.masarubanking.model.Transaction;
import com.sda.masarubanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}

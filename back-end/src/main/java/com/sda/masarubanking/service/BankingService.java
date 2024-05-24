package com.sda.masarubanking.service;

import com.sda.masarubanking.entity.Account;
import com.sda.masarubanking.entity.Savings;
import com.sda.masarubanking.repository.AccountRepository;
import com.sda.masarubanking.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SavingsRepository savingsRepository;


    public double checkAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    public void depositToAccount(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void withdrawFromAccount(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    // Savings methods
    public double checkSavingsBalance(Long savingsId) {
        Savings savings = savingsRepository.findById(savingsId).orElseThrow(() -> new RuntimeException("Savings account not found"));
        return savings.getBalance();
    }

    public void depositToSavings(Long savingsId, double amount) {
        Savings savings = savingsRepository.findById(savingsId).orElseThrow(() -> new RuntimeException("Savings account not found"));
        savings.setBalance(savings.getBalance() + amount);
        savingsRepository.save(savings);
    }

    public void withdrawFromSavings(Long savingsId, double amount) {
        Savings savings = savingsRepository.findById(savingsId).orElseThrow(() -> new RuntimeException("Savings account not found"));
        if (savings.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        savings.setBalance(savings.getBalance() - amount);
        savingsRepository.save(savings);
    }
}
package com.sda.masarubanking.service;

/*public interface AccountService {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
} */

import com.sda.masarubanking.entity.Account;
import com.sda.masarubanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deposit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void withdraw(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }
}
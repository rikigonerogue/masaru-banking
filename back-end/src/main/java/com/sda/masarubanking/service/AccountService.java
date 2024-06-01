package com.sda.masarubanking.service;


import com.sda.masarubanking.converter.AccountConverter;
import com.sda.masarubanking.dto.AccountDTO;
import com.sda.masarubanking.entity.Account;
import com.sda.masarubanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*@Service
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

    public List<Account> withdraw(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        public Account createAccount (AccountDTO accountDTO){
            Account account = new Account();
            account.setAccountName(accountDTO.getAccountName());
            account.setBalance(accountDTO.getInitialDeposit());
            return accountRepository.save(account);


            public List<Account> getAllAccounts () {
                return accountRepository.findAll();

            }
        }
    }


}*/

/*@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(accountConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        return accountConverter.convertToDTO(account);
    }

    public void deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountConverter.convertToEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountConverter.convertToDTO(savedAccount);

    }
}*/

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountConverter.convertToEntity(accountDTO);
        account.setBalance(accountDTO.getBalance());
        account.setType(accountDTO.getType());
        Account savedAccount = accountRepository.save(account);
        return accountConverter.convertToDTO(savedAccount);
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(accountConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        return accountConverter.convertToDTO(account);
    }

    public void deposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void withdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    public Double getAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    public void savingsDeposit(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (!"Savings".equalsIgnoreCase(account.getType())) {
            throw new RuntimeException("Account is not a savings account");
        }
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void savingsWithdraw(Long accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (!"Savings".equalsIgnoreCase(account.getType())) {
            throw new RuntimeException("Account is not a savings account");
        }
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    public Double getSavingsBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        if (!"Savings".equalsIgnoreCase(account.getType())) {
            throw new RuntimeException("Account is not a savings account");
        }
        return account.getBalance();
    }
}
package com.sda.masarubanking.controller;

import com.sda.masarubanking.dto.AccountDTO;
import com.sda.masarubanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banking/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @GetMapping("")
    public List<AccountDTO> getAll() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public AccountDTO getAccount(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PostMapping("/1/deposit")
    public void deposit(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("/1/withdraw")
    public void withdraw(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.withdraw(accountId, amount);
    }

    @GetMapping("/1/balance")
    public Double getAccountBalance(@PathVariable Long accountId) {
        return accountService.getAccountBalance(accountId);
    }

    @PostMapping("/1/savings/deposit")
    public void savingsDeposit(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.savingsDeposit(accountId, amount);
    }

    @PostMapping("/1/savings/withdraw")
    public void savingsWithdraw(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.savingsWithdraw(accountId, amount);
    }

    @GetMapping("/1/savings/balance")
    public Double getSavingsBalance(@PathVariable Long accountId) {
        return accountService.getSavingsBalance(accountId);
    }
}


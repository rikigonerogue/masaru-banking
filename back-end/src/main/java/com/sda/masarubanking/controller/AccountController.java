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

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.withdraw(accountId, amount);
    }

    @GetMapping("/{accountId}/balance")
    public Double getAccountBalance(@PathVariable Long accountId) {
        return accountService.getAccountBalance(accountId);
    }

    @PostMapping("/{accountId}/savings/deposit")
    public void savingsDeposit(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.savingsDeposit(accountId, amount);
    }

    @PostMapping("/{accountId}/savings/withdraw")
    public void savingsWithdraw(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.savingsWithdraw(accountId, amount);
    }

    @GetMapping("/{accountId}/savings/balance")
    public Double getSavingsBalance(@PathVariable Long accountId) {
        return accountService.getSavingsBalance(accountId);
    }
}





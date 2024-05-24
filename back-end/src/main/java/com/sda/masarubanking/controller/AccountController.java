package com.sda.masarubanking.controller;


import com.sda.masarubanking.entity.Account;
import com.sda.masarubanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}/balance1")
    public Account getAccount(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PostMapping("/{accountId}/deposit1")
    public void deposit(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw1")
    public void withdraw(@PathVariable Long accountId, @RequestBody Double amount) {
        accountService.withdraw(accountId, amount);
    }
}
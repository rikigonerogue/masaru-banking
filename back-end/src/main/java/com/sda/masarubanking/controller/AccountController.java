package com.sda.masarubanking.controller;


import com.sda.masarubanking.dto.AccountDTO;
import com.sda.masarubanking.entity.Account;
import com.sda.masarubanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banking/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public List<AccountDTO> getAll() {
        return null;
    }

    @GetMapping("/{accountId}/")
    public Account getAccount(@PathVariable Long accountId) {
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
}
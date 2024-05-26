package com.sda.masarubanking.controller;

import com.sda.masarubanking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private BankingService bankingService;


    @GetMapping("/account/{accountId}/balance")
    public double checkAccountBalance(@PathVariable Long accountId) {
        return bankingService.checkAccountBalance(accountId);
    }

    @PostMapping("/account/{accountId}/deposit")
    public void depositToAccount(@PathVariable Long accountId, @RequestBody Double amount) {
        bankingService.depositToAccount(accountId, amount);
    }

    @PostMapping("/account/{accountId}/withdraw")
    public void withdrawFromAccount(@PathVariable Long accountId, @RequestBody Double amount) {
        bankingService.withdrawFromAccount(accountId, amount);
    }

}



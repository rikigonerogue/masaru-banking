package com.sda.masarubanking.controller;

import com.sda.masarubanking.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking/savings")
public class SavingsController {

    @Autowired
    private SavingsService savingsService;

    @GetMapping("/{savingsId}/balance3")
    public double checkSavingsBalance(@PathVariable Long savingsId) {
        return savingsService.checkSavingsBalance(savingsId);
    }

    @PostMapping("/{savingsId}/deposit3")
    public void depositToSavings(@PathVariable Long savingsId, @RequestBody Double amount) {
        savingsService.depositToSavings(savingsId, amount);
    }

    @PostMapping("/{savingsId}/withdraw3")
    public void withdrawFromSavings(@PathVariable Long savingsId, @RequestBody Double amount) {
        savingsService.withdrawFromSavings(savingsId, amount);
    }
}
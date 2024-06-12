package com.sda.masarubanking.service;

import com.sda.masarubanking.entity.Savings;
import com.sda.masarubanking.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

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
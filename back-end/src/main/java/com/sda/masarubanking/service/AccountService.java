package com.sda.masarubanking.service;

public interface AccountService {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

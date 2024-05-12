package com.sda.masarubanking.Service;

public interface AccountService {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

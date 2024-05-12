package com.sda.masarubanking.Service;

import java.util.Scanner;

public class BankingService implements AccountService {
    private double balance = 0;
    private Scanner scanner;

    @Override
    public void checkBalance() {
        System.out.println("Your current balance is $" + balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " has been deposited to your account.");
        checkBalance();
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds...");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " has been withdrawn from your account.");
            checkBalance();
        }
    }

    public void start() {
        scanner = new Scanner(System.in);
        int option = 0;
        while (option != 5) {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    manageSavings();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nWelcome to Masaru Banking!\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Manage Savings");
        System.out.println("5. Exit");
        System.out.print("\nEnter an option: ");
    }

    private void manageSavings() {
        SavingsService savingsService = new SavingsService();
        savingsService.manageSavings();
    }

    private void exit() {
        System.out.println("Thank you for banking with Masaru. Have a great day!");
        System.exit(0);
    }
}

package com.sda.masarubanking.service;

import java.util.Scanner;

public class SavingsService implements AccountService {
    private double savings = 0;
    private Scanner scanner;

    @Override
    public void checkBalance() {
        System.out.println("Your savings balance is $" + savings);
    }

    @Override
    public void deposit(double amount) {
        savings += amount;
        System.out.println("$" + amount + " has been deposited to your savings account.");
        checkBalance();
    }

    @Override
    public void withdraw(double amount) {
        // Implement withdrawal logic for savings (if needed)
    }

    public void manageSavings() {
        scanner = new Scanner(System.in);
        int option = 0;
        while (option != 3) {
            displaySavingsMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit to savings: $");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displaySavingsMenu() {
        System.out.println("\nSavings Menu:");
        System.out.println("1. Check Savings Balance");
        System.out.println("2. Deposit to Savings");
        System.out.println("3. Exit to Main Menu");
        System.out.print("Enter an option: ");
    }
}
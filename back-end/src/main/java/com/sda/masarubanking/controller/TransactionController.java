package com.sda.masarubanking.controller;


import com.sda.masarubanking.model.Transaction;
import com.sda.masarubanking.service.TransactionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam double amount, HttpSession session) {
        if (session.getAttribute("username") != null) {
            transactionService.addTransaction("deposit", amount);
            return ResponseEntity.ok("Deposit successful");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam double amount, HttpSession session) {
        if (session.getAttribute("username") != null) {
            transactionService.addTransaction("withdraw", amount);
            return ResponseEntity.ok("Withdrawal successful");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return ResponseEntity.ok(transactionService.getTransactions());
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}

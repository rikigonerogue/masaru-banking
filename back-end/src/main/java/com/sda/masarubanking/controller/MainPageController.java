package com.sda.masarubanking.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainPageController {

    @GetMapping("/main-page")
    public ResponseEntity<String> mainPage(HttpSession session) {
        if (session.getAttribute("username") != null) {
            return ResponseEntity.ok("Main Page");
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }
}
package com.sda.masarubanking.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AuthService {
    private static final String AUTH_FILE = "src/main/resources/auth.txt";

    public boolean authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(AUTH_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
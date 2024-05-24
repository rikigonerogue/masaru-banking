package com.sda.masarubanking.controller;

import com.sda.masarubanking.dto.PasswordRecoveryRequest;
import com.sda.masarubanking.dto.PasswordResetRequest;
import com.sda.masarubanking.dto.UserDTO;
import com.sda.masarubanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
    }

    @PostMapping("/recover-password")
    public void recoverPassword(@RequestBody PasswordRecoveryRequest request) {
        userService.recoverPassword(request);
    }

    @PostMapping("/reset-password")
    public void resetPassword(@RequestBody PasswordResetRequest request) {
        userService.resetPassword(request);
    }
}
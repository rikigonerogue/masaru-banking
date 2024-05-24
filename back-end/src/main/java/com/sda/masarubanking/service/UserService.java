package com.sda.masarubanking.service;


import com.sda.masarubanking.dto.PasswordRecoveryRequest;
import com.sda.masarubanking.dto.PasswordResetRequest;
import com.sda.masarubanking.dto.UserDTO;
import com.sda.masarubanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
    }

    public void recoverPassword(PasswordRecoveryRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            user.setResetToken(UUID.randomUUID().toString());
            userRepository.save(user);

        }
    }

    public void resetPassword(PasswordResetRequest request) {
        User user = userRepository.findByResetToken(request.getToken());
        if (user != null) {
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            user.setResetToken(null);
            userRepository.save(user);
        }
    }
}
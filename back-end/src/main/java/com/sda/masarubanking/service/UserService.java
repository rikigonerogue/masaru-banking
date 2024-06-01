package com.sda.masarubanking.service;


import com.sda.masarubanking.converter.UserConverter;
//import com.sda.masarubanking.dto.PasswordRecoveryRequest;
//import com.sda.masarubanking.dto.PasswordResetRequest;
import com.sda.masarubanking.dto.UserDTO;
import com.sda.masarubanking.entity.User;
import com.sda.masarubanking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = userConverter.convertToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User registeredUser = userRepository.save(user);
        return userConverter.convertToDTO(registeredUser);
       
    }


    }



  /*public UserDTO registerUser(UserDTO userDTO) {
        User user = userConverter.convertToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public UserDTO convertToDTO(User user) {
        return userConverter.convertToDTO(user);
    }

    private String generateUniqueAccountId() {
        String accountId;
        do {
            accountId = UUID.randomUUID().toString();
        } while (userRepository.existsByAccountId(accountId));
        return accountId;
    }
}
   /* public void recoverPassword(PasswordRecoveryRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            user.setResetToken(UUID.randomUUID().toString());
            userRepository.save(user);

        }*/


  /*  public void resetPassword(PasswordResetRequest request) {
        User user = userRepository.findByResetToken(request.getToken());
        if (user != null) {
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            user.setResetToken(null);
            userRepository.save(user);
        }
    }
}*/
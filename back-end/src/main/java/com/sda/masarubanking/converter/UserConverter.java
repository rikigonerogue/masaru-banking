package com.sda.masarubanking.converter;

import com.sda.masarubanking.dto.UserDTO;
import com.sda.masarubanking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword()); //This will be encoded in the service (i think..)
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        // like hell imma include the password in the DTO (security reasons)
        return userDTO;
    }
}

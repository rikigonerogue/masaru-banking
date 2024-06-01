package com.sda.masarubanking.repository;


import com.sda.masarubanking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}

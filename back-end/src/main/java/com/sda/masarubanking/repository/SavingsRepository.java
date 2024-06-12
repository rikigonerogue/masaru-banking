package com.sda.masarubanking.repository;

import com.sda.masarubanking.entity.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}

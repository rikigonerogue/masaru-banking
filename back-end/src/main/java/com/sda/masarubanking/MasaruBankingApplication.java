package com.sda.masarubanking;

import com.sda.masarubanking.service.BankingService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasaruBankingApplication {

	public static void main(String[] args) {
		BankingService bankingService = new BankingService();
		bankingService.start();
	}
}


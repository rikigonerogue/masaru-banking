package com.sda.masarubanking.Main;

import com.sda.masarubanking.Service.BankingService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasaruBankingApplication {

	public static void main(String[] args) {
		BankingService bankingService = new BankingService();
		bankingService.start();
	}
}
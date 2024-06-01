package com.sda.masarubanking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* TODO - controller should get DTO
controller validates the DTO
controller passes DTO to service
Service calls the converter to convert DTO into entity (usually conversion in converter, which is autowired in service)
service calls the repository to persist entity into the database


*/


@SpringBootApplication
public class MasaruBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasaruBankingApplication.class, args);

	}
}

/* TODO
    	- create endpoint to create acc using DTO,
 		- implement method getAllAccounts,
 		- verify using postman.

 		// TODO - configure {accountId}, work on endpoints, write operation business
 		    logic(withdraw, deposit, balance check), verify endpoints using postman.


 */
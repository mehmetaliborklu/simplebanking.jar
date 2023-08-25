package com.eteration.simplebanking;

import com.eteration.simplebanking.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InsufficientBalanceException {

		Account account = new Account("MEHMET ALİ", "45679");
		account.post(new DepositTransaction(1000));
		account.post(new WithdrawalTransaction(200));
		account.post(new PhoneBillPaymentTransaction("Vodafone", "5423345566", 96.50));

		System.out.println(account.getBalance());

	}

}

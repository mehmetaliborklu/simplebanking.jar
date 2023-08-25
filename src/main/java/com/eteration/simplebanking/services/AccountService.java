package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;

public class AccountService {

    public Account findAccount(String accountNumber) {
        if (accountNumber.equals("17892")) {
            return new Account("Jim", "17892");
        } else {
            return null;
        }
    }

}

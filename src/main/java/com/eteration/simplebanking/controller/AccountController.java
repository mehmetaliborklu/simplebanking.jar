package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountController<T> {

    private AccountService service;
    private Account account;
    public ResponseEntity<T> getAccount(String accountNumber) {
        try {
            account = service.findAccount(accountNumber);
            return (ResponseEntity<T>) ResponseEntity.ok(account);
        } catch (Exception e) {
            return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new TransactionStatus("Hata", "Beklenmeyen bir hata oluştu"));
        }


    }

    public ResponseEntity<TransactionStatus> credit(String accountNumber, DepositTransaction depositTransaction) {
        try {
            account = service.findAccount(accountNumber);
            account.post(new DepositTransaction(depositTransaction.getAmount()));
            return ResponseEntity.ok( new TransactionStatus("OK", "Hesabınıza para girişi oldu."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new TransactionStatus("Hata", "Beklenmeyen bir hata oluştu"));
        }

    }
    public ResponseEntity<TransactionStatus> debit(String accountNumber, WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        account = service.findAccount(accountNumber);
        if (withdrawalTransaction.getAmount() > account.getBalance()) {
            throw new InsufficientBalanceException();
        }
        account.post(new WithdrawalTransaction(withdrawalTransaction.getAmount()));
        return ResponseEntity.ok(new TransactionStatus("OK", "Hesabınızdan para çıkışı oldu."));
    }
}
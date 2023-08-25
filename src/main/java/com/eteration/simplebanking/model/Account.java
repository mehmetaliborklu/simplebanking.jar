package com.eteration.simplebanking.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String owner;
    private String accountNumber;
    private double balance = 0;

    private List<Transaction> transactions = new ArrayList<>();

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public void credit(double amount) {
        post(new DepositTransaction(amount));
    }

    public void debit(double amount) throws InsufficientBalanceException {
        post(new WithdrawalTransaction(amount));
    }

    public void post(DepositTransaction depositTransaction) {
        DepositTransaction transaction = new DepositTransaction(depositTransaction.getAmount());
        this.balance = transaction.createDepositTransaction(balance);
        transactions.add(transaction);
    }

    public void post(WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        double amount = withdrawalTransaction.getAmount();
        controlAmountWithDrawn(amount);
        WithdrawalTransaction transaction = new WithdrawalTransaction(amount);
        this.balance = transaction.createWithdrawalTransaction(balance);
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private void controlAmountWithDrawn(double amount) throws InsufficientBalanceException {
        if (Double.compare(balance, amount) < 0) {
            throw new InsufficientBalanceException("Hesap Bakiyesi Yetersiz, Lütfen Tekrar Deneyiniz");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

}

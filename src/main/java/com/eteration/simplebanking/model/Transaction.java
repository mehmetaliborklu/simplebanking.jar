package com.eteration.simplebanking.model;

import java.time.LocalDateTime;

public abstract class Transaction {
    private double amount;
    private LocalDateTime createDate;

    Transaction(double amount) {
        this.amount = amount;
        this.createDate = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return createDate;
    }

    public double createDepositTransaction(double mainAmount) {
        return mainAmount+this.amount;
    }

    public double createWithdrawalTransaction(double mainAmount) {
        return mainAmount-this.amount;
    }

}

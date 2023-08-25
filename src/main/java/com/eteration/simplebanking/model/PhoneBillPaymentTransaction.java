package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction {

    private String payee;
    private String phoneNumber;
    private double amount;

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, double amount) {
        super(amount);
        this.payee       = payee;
        this.phoneNumber = phoneNumber;
        this.amount      = amount;
    }
}

package com.eteration.simplebanking.controller;

public class TransactionStatus <T>{
    private String status;
    private T body;

    public TransactionStatus(String status, T body) {
        this.status = status;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}

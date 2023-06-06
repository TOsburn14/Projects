package com.techelevator.exceptions.accounts;

public class InsufficientMinimumBalanceException extends Exception {

    private double feeAmount;

    public InsufficientMinimumBalanceException(String message, double feeAmount) {
        super(message);
        this.feeAmount = feeAmount;
    }

    public double getFeeAmount() {
        return feeAmount;
    }
}

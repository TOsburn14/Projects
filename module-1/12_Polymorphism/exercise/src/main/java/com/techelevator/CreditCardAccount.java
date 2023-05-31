package com.techelevator;

public class CreditCardAccount implements Accountable{

    //Variables
    private String accountHolder;
    private String accountNumber;
    private int debt = 0;

    //Getters


    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    //Constructor
    public CreditCardAccount(String accountHolder,String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    //Methods
    public int pay(int amountToPay){
        return debt-=amountToPay;
    }
    public int charge(int amountToCharge){
        return debt += amountToCharge;
    }

    @Override
    public int getBalance() {
        return -debt;
    }
}

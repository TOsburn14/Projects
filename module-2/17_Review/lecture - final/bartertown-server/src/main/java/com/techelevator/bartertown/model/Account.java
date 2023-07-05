package com.techelevator.bartertown.model;

public class Account {

    private int barterCredit;

    public Account() {

    }

    public Account(int barterCredit) {
        this.barterCredit = barterCredit;
    }

    public int getBarterCredit() {
        return barterCredit;
    }

    public void setBarterCredit(int barterCredit) {
        this.barterCredit = barterCredit;
    }

}

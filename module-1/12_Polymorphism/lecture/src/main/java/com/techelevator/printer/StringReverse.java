package com.techelevator.printer;

public class StringReverse implements Printable {

    private String stringToReverse;

    public StringReverse(String stringToReverse) {
        this.stringToReverse = stringToReverse;
    }

    public void showReversedString() {
        String reversed = new StringBuilder(stringToReverse).reverse().toString();

        System.out.println(reversed);
    }

    @Override
    public void print() {
        showReversedString();
    }
}

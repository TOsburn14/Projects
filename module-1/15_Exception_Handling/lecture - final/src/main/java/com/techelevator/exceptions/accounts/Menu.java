package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class Menu {

    private final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome to the Java Blue bank");
    }

    public int getAmountFromUser() {

        int amount = 0;
        while (true) {
            System.out.print("Amount to withdraw >>> ");
            String userInput = in.nextLine();

            try {
                amount = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid amount");
            }
        }

        return amount;

    }

    public void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println();
    }

    public void showWithdrawSucceessMessage(int amount) {
        System.out.println(amount + " was withdrawn");
    }

    public void showUserFeeWasAdded(double feeAmount) {
        System.out.println("Balance below minimum required balance.  A $" + feeAmount + " was added.");
    }



}

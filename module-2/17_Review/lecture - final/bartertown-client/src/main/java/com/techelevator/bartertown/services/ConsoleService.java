package com.techelevator.bartertown.services;


import com.techelevator.bartertown.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("  ____             _              _____                   ");
        System.out.println(" | __ )  __ _ _ __| |_ ___ _ __  |_   _|____        _____   ");
        System.out.println(" |  _ \\ / _` | '__| __/ _ \\ '__|   | |/ _ \\ \\ /\\ / / '_  \\ ");
        System.out.println(" | |_) | (_| | |  | ||  __/ |      | | (_) \\ V  V /| | | |");
        System.out.println(" |____/ \\__,_|_|   \\__\\___|_|      |_|\\___/ \\_/\\_/ |_| |_|");
        System.out.println("     " );
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu(int credits) {
        System.out.println();
        System.out.println("1: Send an item");
        System.out.println("2: View items received");
        System.out.println("3: View history");
        System.out.println("0: Exit");
        System.out.println("---------------------------------");
        System.out.print(ANSI_YELLOW);
        System.out.printf("Current credits: %1s%n", credits);
        System.out.println(ANSI_RESET);


    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username (must be all lowercase): ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printNotice(String message) {
        System.out.println("** " + message + " **");
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}

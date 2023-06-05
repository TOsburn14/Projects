package com.techelevator.exceptions;

import java.util.Scanner;


public class ExceptionsLecture {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int number = 0;

        while (true) {
            System.out.print("Input a whole number >>> ");
            String userSelection = input.nextLine();

            try {
                number = Integer.parseInt(userSelection);
                System.out.println("This only prints when there is no exception");
                break;
            } catch (NumberFormatException e) {
                System.out.println("A number is required, please try again");
            }
        }


        System.out.println("Your number was " + number);
    }

}

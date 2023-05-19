package com.techelevator;

import java.util.Scanner;

public class TEMart {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        String[] products = new String[4];
        products[0] = "Shirt,402.99";
        products[1] = "Car,0.10";
        products[2] = "Cats,42";
        products[3] = "Waffles,2000.26";


        System.out.println("*****************************");
        System.out.println(" Welcome to TE Mart");
        System.out.println("*****************************");
        System.out.println();

        System.out.println("What is your name?");
        String userName = userInput.nextLine();

        System.out.print("Hello ");
        System.out.print(userName);
        System.out.println(", here is what is available");

        while (true) {
            for (int i = 0; i < products.length; i++) {
                String[] partsOfString = products[i].split(",");
                System.out.println((i + 1) + ") " + partsOfString[0]);
            }

            System.out.print("Item to view >>>");
            String itemNumberFromUser = userInput.nextLine();
            int itemNumber = Integer.parseInt(itemNumberFromUser);
            String itemUserSelected = products[itemNumber - 1];

            String[] partsOfItem = itemUserSelected.split(",");

            String nameOfItem = partsOfItem[0];
            String priceOfItem = partsOfItem[1];

            double price = Double.parseDouble(priceOfItem);
            double tax = price * .075;

            System.out.printf("%1s price: $%1.2f tax: $%1.2f %n", nameOfItem, price, tax);

            System.out.println();
            System.out.print("Would you like to select another product (Y/N)? ");
            String userChoice = userInput.nextLine();

            if (userChoice.equals("N")) {
                System.out.println("Thank you");
                break;
            }
        }


    }
}

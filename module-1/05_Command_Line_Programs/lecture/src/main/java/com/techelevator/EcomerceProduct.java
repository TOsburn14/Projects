package com.techelevator;

import java.util.Scanner;

public class EcomerceProduct {
    /*
    1. Welcome User
    2. Ask User their name
    3. Show list of products
    4. Have user select their product
    5. Show that product
    6. Ask if the user wants to see another product?
     */

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String[] productList = new String[4];
        productList[0] = "Shirt,402.99";
        productList[1] = "Car, 0.10";
        productList[2] = "Waffles,2000.26";
        productList[3] = "Cats,42";

        System.out.println("**************");
        System.out.println(" Welcome to TE Mart, where we sell the products you never need!");
        System.out.println("**************");
        System.out.println();

        System.out.println("What is your name?");
        String nameOfUser = userInput.nextLine();

        System.out.print("Hello, ");
        System.out.print(nameOfUser);

        System.out.println(" What product would you like?");
        while (true) {
            for (int i = 0; i < productList.length; i++) {
                String[] partsOfString = productList[i].split(",");
                System.out.println((i + 1) + ") " + partsOfString[0]);
            }
            System.out.print("Item to view >>>");
            String itemNumberFromUser = userInput.nextLine();
            int itemNumber = Integer.parseInt(itemNumberFromUser);
            String itemUserSelected = productList[itemNumber - 1];

            String[] partsOfItem = itemUserSelected.split(",");

            String nameOfItem = partsOfItem[0];
            String priceOfItem = partsOfItem[1];

            double price = Double.parseDouble(priceOfItem);
            double tax = price * .075;

            System.out.printf("%1s price: $%1.2f tax: $%1.2f", nameOfItem, price, tax);

            System.out.println();
            System.out.print("Would you like to select another useless item? (Y/N)? ");
            String userChoice = userInput.nextLine();

            if (userChoice.equals("N")){
                System.out.println("Thank You");
                break;
            }
        }
    }
}
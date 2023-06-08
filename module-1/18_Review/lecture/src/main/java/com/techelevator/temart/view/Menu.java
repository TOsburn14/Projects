package com.techelevator.temart.view;

import com.techelevator.temart.model.StoreItem;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner in = new Scanner(System.in);

    public void showWelcomeScreen() {
        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();
    }

    public String getInventoryFileFromUser(){
        System.out.println("Inventory File >>>");
      //  return in.nextLine();
        //TODO: Remove hardcoded value before complete
        return "inventory.csv";
    }

    public void tellUserFileNotFound(){
        System.out.println("Inventory file not found");
    }
    public String getChoiceFromMainMenu(){
        System.out.println("S)how Items");
        System.out.println("Q)uit");
        return in.nextLine();
    }

    public void tellUserInvalidSelection(){
        System.out.println("Invalid selection, please try again");
    }

    public void displayInventory (Map<String, StoreItem> inventory) {
        for (Map.Entry<String,StoreItem> entry : inventory.entrySet()) {
            System.out.printf("%1s : %1s : $%1.2f %n", entry.getKey(),
                    entry.getValue().getName(),entry.getValue().getPrice());
        }
        System.out.println();
    }
}

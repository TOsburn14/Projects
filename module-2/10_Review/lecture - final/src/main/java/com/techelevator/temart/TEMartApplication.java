package com.techelevator.temart;

import com.techelevator.temart.model.StoreItem;
import com.techelevator.temart.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;


public class TEMartApplication {

    private Menu menu;
    private Store store;

    public static void main(String[] args) {
        Menu menu = new Menu();
        TEMartApplication app = new TEMartApplication(menu);
        app.run();
    }

    public TEMartApplication(Menu menu) {
        this.menu = menu;
    }

    public void run() {

        while (true) {
            String inventoryFilename = menu.getInventoryFileFromUser();
            try {
                store = new Store(inventoryFilename);
                break;
            } catch (FileNotFoundException e) {
                menu.tellUserFileNotFound();
            }
        }

        menu.showWelcomeScreen();

        while (true) {
            String userSelection = menu.getChoiceFromMainMenu();
            if (userSelection.equalsIgnoreCase("S")) {
                showItems();
            } else if (userSelection.equalsIgnoreCase("Q")) {
                break;
            } else {
                menu.tellUserInvalidSelection();
            }
        }

    }

    private void showItems() {
        Map<String, StoreItem> inventory = store.getInventory();
        menu.displayInventory(inventory);
    }

}

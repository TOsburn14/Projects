package com.techelevator.temart;

import com.techelevator.temart.dao.FileInventoryReader;
import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.JdbcInventoryDao;
import com.techelevator.temart.exception.DaoException;
import com.techelevator.temart.model.StoreItem;
import com.techelevator.temart.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;

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

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/temart");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");


        while (true) {
            String inventoryFilename = menu.getInventoryFileFromUser();
            InventoryDao inventoryReader = new JdbcInventoryDao(dataSource); //new FileInventoryReader(inventoryFilename);
            try {
                store = new Store(inventoryReader);
                break;
            } catch (DaoException e) {
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

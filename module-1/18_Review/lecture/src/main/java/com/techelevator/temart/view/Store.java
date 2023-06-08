package com.techelevator.temart.view;

import com.techelevator.temart.model.FileInventoryReader;
import com.techelevator.temart.model.StoreItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class Store {

    private Map<String, StoreItem> inventory;

    public Store(String inventoryFilename) throws FileNotFoundException {
        FileInventoryReader inventoryReader = new FileInventoryReader(inventoryFilename);
        inventory = inventoryReader.loadInventory();
    }

    public Map<String, StoreItem> getInventory() {
        return this.inventory;
    }
}

package com.techelevator.temart;

import com.techelevator.temart.dao.FileInventoryReader;
import com.techelevator.temart.model.StoreItem;

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

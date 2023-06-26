package com.techelevator.temart;

import com.techelevator.temart.dao.FileInventoryReader;
import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.model.StoreItem;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.Map;

public class Store {

    private Map<String, StoreItem> inventory;

    public Store(InventoryDao inventoryReader) {
        inventory = inventoryReader.loadInventory();
    }



    public Map<String, StoreItem> getInventory() {
        return this.inventory;
    }


}

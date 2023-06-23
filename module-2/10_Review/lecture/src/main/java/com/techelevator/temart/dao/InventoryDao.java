package com.techelevator.temart.dao;

import com.techelevator.temart.model.StoreItem;

import java.io.FileNotFoundException;
import java.util.Map;

public interface InventoryDao {

    Map<String, StoreItem> loadInventory() throws FileNotFoundException;
}

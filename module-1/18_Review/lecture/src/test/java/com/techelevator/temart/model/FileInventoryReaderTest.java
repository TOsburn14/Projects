package com.techelevator.temart.model;
import org.junit.*;

import java.io.FileNotFoundException;
import java.util.Map;

public class FileInventoryReaderTest {

    private FileInventoryReader target;

    @Before
    public void setup(){
        target = new FileInventoryReader("inventory.csv");
    }

    @Test
    public void load_inventory_from_file() throws FileNotFoundException {
        Map<String,StoreItem> inventory = target.loadInventory();
        Assert.assertEquals(5,inventory.size());
    }
}

package com.techelevator.temart.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileInventoryReader {

    private String filename;

    public FileInventoryReader(String inventoryFilename) {
        this.filename = inventoryFilename;
    }

    public Map<String, StoreItem> loadInventory() throws FileNotFoundException {

        Map<String, StoreItem> inventory = new LinkedHashMap<String, StoreItem>();

        File inventoryFile = new File(filename);

        try (Scanner fileScanner = new Scanner(inventoryFile)) {

            while (fileScanner.hasNextLine()) {
                String lineFromFile = fileScanner.nextLine();
                StoreItem currentItem = buildStoreItemFromLine(lineFromFile);
                inventory.put(currentItem.getSku(), currentItem);
            }

        }

        return inventory;
    }

    private StoreItem buildStoreItemFromLine(String lineFromFile) {
        String[] itemParts = lineFromFile.split("\\|");

        String productCode = itemParts[0];
        String sku = itemParts[1];
        String name = itemParts[2];
        String description = itemParts[3];
        double price = Double.parseDouble(itemParts[4]);

        StoreItem item = null;

        if (productCode.equalsIgnoreCase("C")) {
            item = new Clothing();
        } else if (productCode.equalsIgnoreCase("G")) {
            item = new Grocery();
        } else if (productCode.equalsIgnoreCase("B")) {
            item = new Book();
        } else if (productCode.equalsIgnoreCase("E")) {
            item = new Electronic();
        }

        item.setSku(sku);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        return item;
    }

}

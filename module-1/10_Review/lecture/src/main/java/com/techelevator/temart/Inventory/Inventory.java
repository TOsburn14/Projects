package com.techelevator.temart.Inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Product> products = new HashMap<String, Product>();

    public Inventory() {
        buildInventory();
    }

    public Map<String,Product> getProductsInInventory(){
        return products;
    }

    public Product getProductBySku(String sku) {
        return products.get(sku);
    }

    private void buildInventory(){

        Product happiness = new Product("HAP01");
        happiness.setName("Happiness");
        happiness.setPrice(1000000);
        happiness.setDescription("Pretty Good");
        happiness.setWeightInOz(10);

        products.put("HAP01", happiness);

        Product liquor = new Product("LIQ02", "Liquor", 15.5, 5, "Happiness");
        products.put("LIQ02",liquor);

        products.put("COFE",new Product("COFE", "Coffee", 5.29, 1, "It's Coffee"));

        products.put("LIQ03", new Product("LIQ03", "Vodka", 27.18, 10, "Sanctioned Happiness"));



    }
}



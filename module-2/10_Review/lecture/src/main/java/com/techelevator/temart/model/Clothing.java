package com.techelevator.temart.model;

public class Clothing extends StoreItem {

    public Clothing() {
    }

    public Clothing(String sku, String name, String description, double price) {
        super(sku, name, description, price);
    }

    @Override
    public String getProductType() {
        return "Clothing";
    }

}

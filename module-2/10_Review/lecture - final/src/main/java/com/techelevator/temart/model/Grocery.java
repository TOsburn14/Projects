package com.techelevator.temart.model;

public class Grocery extends StoreItem {

    public Grocery() {
    }

    public Grocery(String sku, String name, String description, double price) {
        super(sku, name, description, price);
    }

    @Override
    public String getProductType() {
        return "Grocery";
    }
}

package com.techelevator.temart.model;

public class Homegood extends StoreItem {

    public Homegood() {
    }

    public Homegood(String sku, String name, String description, double price) {
        super(sku, name, description, price);
    }

    @Override
    public String getProductType() {
        return "Electronic";
    }
}

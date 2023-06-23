package com.techelevator.temart.model;

public class Book extends StoreItem {

    public Book() {
    }

    public Book(String sku, String name, String description, double price) {
        super(sku, name, description, price);
    }

    @Override
    public String getProductType() {
        return "Book";
    }
}

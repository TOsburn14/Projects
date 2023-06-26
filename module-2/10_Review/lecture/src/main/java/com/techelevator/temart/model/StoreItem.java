package com.techelevator.temart.model;

import java.util.Objects;

public abstract class StoreItem {

    private String sku;
    private String name;
    private String description;
    private double price;

    public StoreItem() {
    }

    public StoreItem(String sku, String name, String description, double price) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public abstract String getProductType();

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreItem storeItem = (StoreItem) o;
        return Double.compare(storeItem.price, price) == 0 && Objects.equals(sku, storeItem.sku) && Objects.equals(name, storeItem.name) && Objects.equals(description, storeItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, description, price);
    }
}

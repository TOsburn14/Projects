package com.techelevator.temart.Inventory;

import java.math.BigDecimal;

public class Product {

   private static final double BASE_SHIPPING_COST = 5.00;


    //Variables
    private String sku;
    private String name;
    private double price;
    private int weightInOz;
    private String description;
    private boolean perishable = false;

    //Getters
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getWeightInOz() {
        return weightInOz;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPerishable() {
        return perishable;
    }




    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeightInOz(int weightInOz) {
        this.weightInOz = weightInOz;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }




    //Constructor
    public Product (String sku){
        this.sku = sku;
    }
    public Product(String sku, String name, double price, int weightInOz, String description){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.weightInOz = weightInOz;
        this.description = description;
    }



    //Method

    //If weight <= 5 then use the base
    //If weight is between 5 & 10, 150% of the cost
    //If weight is over 10, shipping * 2

    public double getShippingCost(){
        double shippingCost = BASE_SHIPPING_COST;

        if (weightInOz > 5 && weightInOz < 10){
            shippingCost *= 1.5;
        } else if (weightInOz > 10) {
            shippingCost *= 2;
        }

        if (perishable){
            shippingCost *= 2;
        }
        return shippingCost;
    }

    public double getTotalCostWithShipping(){
        return price + getShippingCost();
    }

}

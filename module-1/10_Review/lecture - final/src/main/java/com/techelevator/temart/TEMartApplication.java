package com.techelevator.temart;


import com.techelevator.temart.inventory.Inventory;
import com.techelevator.temart.inventory.Product;

import java.util.Map;
import java.util.Scanner;

public class TEMartApplication {

    public static void main(String[] args) {

        Inventory storeInventory = new Inventory();
        Scanner userInput = new Scanner(System.in);

        System.out.println("**************************");
        System.out.println(" Welcome to TE Mart ");
        System.out.println("**************************");
        System.out.println();

        System.out.println("Products for Sale");

        for (Map.Entry<String, Product> mapEntry : storeInventory.getProductsInInventory().entrySet()) {
            Product currentProduct = mapEntry.getValue();
            System.out.printf("%-8s %-20s $%1.2f %n", currentProduct.getSku(),
                    currentProduct.getName(), currentProduct.getPrice() );
        }

        System.out.println();
        System.out.println("Select a product by sku >>> ");
        String skuSelectedByUser = userInput.nextLine();

        Product productSelectedByUser = storeInventory.getProductBySku(skuSelectedByUser);

        System.out.println();
        System.out.println("Name: " + productSelectedByUser.getName());
        System.out.printf("Price: $%1.2f %n", productSelectedByUser.getPrice());
        System.out.println("Description: " + productSelectedByUser.getDescription());
        System.out.println("Weight: " + productSelectedByUser.getWeightInOz());
        System.out.printf("Shipping Cost: $%1.2f %n", productSelectedByUser.getShippingCost());
        System.out.printf("Your total cost: $%1.2f %n", productSelectedByUser.getTotalCostWithShipping());

    }

}

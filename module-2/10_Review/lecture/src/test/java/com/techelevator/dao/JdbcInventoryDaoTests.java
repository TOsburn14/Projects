package com.techelevator.dao;

import com.techelevator.temart.model.*;
import org.junit.*;

import java.util.List;

public class JdbcInventoryDaoTests {

    private static final StoreItem CLOTHING_PRODUCT_1 = new Clothing("C01", "Test Clothing 1",
            "Test Clothing 1 Description", 24.98);
    private static final StoreItem GROCERY_PRODUCT_1 = new Grocery("G01", "Test Grocery 1",
            "Test Grocery 1 Description",8.99);
    private static final StoreItem HOMEGOOD_PRODUCT_1 = new Homegood("H01", "Test Home Goods 1",
            "Test Home Goods 1 Description",5.55);
    private static final StoreItem BOOK_PRODUCT_1 = new Book("B01", "Test Book 1",
            "Test Book 1 Description - taxable", 19.95);
    private static final StoreItem BOOK_PRODUCT_2 = new Book("B02", "Test Book 2",
            "Test Book 2 Description - nontaxable", 39.95);




}

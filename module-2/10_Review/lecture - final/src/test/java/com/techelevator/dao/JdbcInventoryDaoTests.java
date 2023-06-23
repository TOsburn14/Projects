package com.techelevator.dao;

import com.techelevator.temart.dao.InventoryDao;
import com.techelevator.temart.dao.JdbcInventoryDao;
import com.techelevator.temart.model.*;
import org.junit.*;

import java.util.List;
import java.util.Map;

public class JdbcInventoryDaoTests extends BaseDaoTests {

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


    private InventoryDao sut;

    @Before
    public void setup() {
        sut = new JdbcInventoryDao(dataSource);
    }

    @Test
    public void get_all_products() {
        Map<String, StoreItem> inventory = sut.loadInventory();
        Assert.assertEquals(5, inventory.size());
        Assert.assertEquals(CLOTHING_PRODUCT_1, inventory.get(CLOTHING_PRODUCT_1.getSku()));
    }

}

package com.techelevator.temart.dao;

import com.techelevator.temart.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class JdbcInventoryDao implements InventoryDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Map<String, StoreItem> loadInventory() {
        Map<String, StoreItem> inventoryItems = new HashMap<String, StoreItem>();

        String sql = "SELECT sku, product_type.type, product_type.name AS product_type_name, " +
                "product.name AS product_name, description, perishable, price, weight_in_lbs, taxable " +
                "FROM product " +
                "JOIN product_type ON product.product_type = product_type.id;";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()){
            StoreItem item = mapRowToItem( rows );
            inventoryItems.put(item.getSku(),item);
        }

        return inventoryItems;
    }

    private StoreItem mapRowToItem(SqlRowSet row){
        StoreItem item = null;

        String productCode = row.getString("type");

        if (productCode.equalsIgnoreCase("C")) {
            item = new Clothing();
        } else if (productCode.equalsIgnoreCase("G")) {
            item = new Grocery();
        } else if (productCode.equalsIgnoreCase("B")) {
            item = new Book();
        } else if (productCode.equalsIgnoreCase("H")) {
            item = new Homegood();
        }

        item.setSku(row.getString("sku"));
        item.setName(row.getString("product_name"));
        item.setDescription(row.getString("description"));
        item.setPrice(row.getDouble("price"));

        return item;
    }
}

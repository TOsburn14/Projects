package com.techelevator.temart.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcInventoryDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate();
    }
}

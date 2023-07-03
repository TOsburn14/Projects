package com.techelevator.bartertown.dao;

import com.techelevator.bartertown.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Account getAccountForUser(int userId) {
        int barterCredits = 0;
        String sql = "SELECT barter_credits FROM account WHERE user_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        if (rows.next()) {
            barterCredits = rows.getInt("barter_credits" );
        }
        return new Account(barterCredits);
    }
}

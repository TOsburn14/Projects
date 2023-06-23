package com.techelevator.temart.dao;

import com.techelevator.temart.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcWishlistDao implements WishlistDao {

    private static final String SELECT_FROM_WISHLIST = "SELECT id, name, date_created FROM wish_list";

    private JdbcTemplate jdbcTemplate;

    public JdbcWishlistDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Wishlist> getAll() {
        List<Wishlist> wishlists = new ArrayList<Wishlist>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_FROM_WISHLIST);
        while (rows.next()) {
            wishlists.add( mapRowToWishlist(rows) );
        }
        return wishlists;
    }

    private Wishlist mapRowToWishlist(SqlRowSet rows) {
        Wishlist wishlist = new Wishlist();
        wishlist.setId( rows.getInt("id") );
        wishlist.setName( rows.getString("name") );
        if (rows.getTimestamp("date_created") != null) {
            wishlist.setDateCreated( rows.getTimestamp("date_created").toLocalDateTime());
        }
        return wishlist;
    }

    @Override
    public Wishlist getById(int id) {
        return null;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        return null;
    }

    @Override
    public void update(Wishlist wishlist) {

    }

    @Override
    public void delete(Wishlist wishlist) {

    }
}

package com.techelevator.temart.dao;

import com.techelevator.temart.exception.DaoException;
import com.techelevator.temart.model.Wishlist;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcWishlistDao implements WishlistDao{

    private static final String SELECT_FROM_WISHLIST = "SELECT id, name, date_created FROM wish_list";

    private JdbcTemplate jdbcTemplate;
    public JdbcWishlistDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Wishlist> getAll() {
        List<Wishlist> wishlists = new ArrayList<Wishlist>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_FROM_WISHLIST);
        while (rows.next()){
            wishlists.add(mapRowToWishlist(rows));
        }
        return wishlists;
    }



    @Override
    public Wishlist getById(int id) {
        Wishlist wishlist = null;
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SELECT_FROM_WISHLIST + " WHERE id = ?", id);
        if (rows.next()) {
            wishlist = mapRowToWishlist(rows);
        }
        return wishlist;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        String sql = "INSERT INTO wish_list (name, date_created) VALUES (?,?) RETURNING id";
        int newId = jdbcTemplate.queryForObject(sql,int.class,wishlist.getName(),wishlist.getDateCreated());
        wishlist.setId(newId);
        return wishlist;
    }

    @Override
    public void update(Wishlist wishlist) {
        String sql = "UPDATE wish_list SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,wishlist.getName(),wishlist.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM wish_list WHERE id = ?";
        String sql2 = "DELETE FROM product_wish_list WHERE wish_list_id = ?";
        jdbcTemplate.update(sql2,id);
        jdbcTemplate.update(sql,id);
    }
    private Wishlist mapRowToWishlist(SqlRowSet rows){
        Wishlist wishlist = new Wishlist();
        wishlist.setId(rows.getInt("id"));
        wishlist.setName(rows.getString("name"));
        if (rows.getTimestamp("date_created") != null){
            wishlist.setDateCreated(rows.getTimestamp("date_created").toLocalDateTime());
        }
        return wishlist;
    }
}

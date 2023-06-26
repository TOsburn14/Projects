package com.techelevator.temart.dao;

import com.techelevator.temart.model.Wishlist;

import java.util.List;

public interface WishlistDao {

    List<Wishlist> getAll();
    Wishlist getById(int id);
    Wishlist create(Wishlist wishlist);
    void update(Wishlist wishlist);
    void delete(int id);


}

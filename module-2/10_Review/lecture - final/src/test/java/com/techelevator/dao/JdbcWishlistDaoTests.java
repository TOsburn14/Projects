package com.techelevator.dao;

import com.techelevator.temart.dao.JdbcWishlistDao;
import com.techelevator.temart.dao.WishlistDao;
import com.techelevator.temart.model.Wishlist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class JdbcWishlistDaoTests extends BaseDaoTests {

    private static final Wishlist WISHLIST_1 = new Wishlist(1, "Test Wishlist 1", LocalDateTime.parse("2022-06-15T10:15"));
    
    private WishlistDao sut;

    @Before
    public void setup() {
        sut = new JdbcWishlistDao(dataSource);
    }

    @Test
    public void get_all_wishlists() {
        List<Wishlist> wishlistList = sut.getAll();
        Assert.assertEquals(3, wishlistList.size());
        Assert.assertTrue(wishlistList.contains(WISHLIST_1));
    }

}

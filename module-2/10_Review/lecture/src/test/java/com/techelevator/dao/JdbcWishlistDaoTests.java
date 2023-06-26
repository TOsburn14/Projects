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

    private static final Wishlist WISHLIST_1 = new Wishlist(1,"Test Wishlist 1", LocalDateTime.parse("2022-06-15T10:15"));

    private WishlistDao sut;

    @Before
    public void setup(){
        sut = new JdbcWishlistDao(dataSource);
    }


    @Test
    public void get_all_wishlists(){
        List<Wishlist> wishlistList = sut.getAll();
        Assert.assertEquals(3,wishlistList.size());
        Assert.assertTrue(wishlistList.contains(WISHLIST_1));
    }

    @Test
    public void create_wishlist(){
        Wishlist newWishlist = new Wishlist(0,"NEW TEST WISHLIST",LocalDateTime.parse("2022-06-15T10:15"));
        sut.create(newWishlist);
        Assert.assertTrue(newWishlist.getId() > 0);
        Wishlist wishlistFromDb = sut.getById(newWishlist.getId());
        Assert.assertEquals(newWishlist,wishlistFromDb);
    }
    @Test
    public void get_wishlist_by_id(){
        Wishlist wishlistFromDatabase = sut.getById(1);
        Assert.assertEquals(WISHLIST_1,wishlistFromDatabase);
    }

    @Test
    public void update_wishlist(){
        Wishlist wishlistToUpdate = sut.getById(2);
        wishlistToUpdate.setName("Updated Name");
        sut.update(wishlistToUpdate);
        Wishlist wishlistAfterUpdate = sut.getById(2);
        Assert.assertEquals(wishlistToUpdate,wishlistAfterUpdate);
    }
    @Test
    public void delete_wishlist(){
        sut.delete(3);
        Assert.assertNull(sut.getById(3));
    }

    @Test
    public void get_all_returns_empty_list(){
        sut.delete(1);
        sut.delete(2);
        sut.delete(3);
        List<Wishlist> wishlistList = sut.getAll();
        Assert.assertEquals(0,wishlistList.size());
    }
    @Test
    public void get_by_id_returns_null(){
        Assert.assertNull(sut.getById(99));
    }
}

package com.techelevator;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;
import java.sql.Array;
import java.sql.ClientInfoStatus;
import java.util.List;

public class Lucky13Tests {
    private Lucky13 target;
    @Before
    public void setup(){
        target = new Lucky13();
    }

    @Test
    public void number_is_null(){
        int[] array = null;
        boolean result = target.getLucky(array);
        Assert.assertFalse(result);
    }
    @Test
    public void numbers_are_negative(){
        int[] array = {-1,-2,-3};
        boolean result = target.getLucky(array);
        Assert.assertFalse(result);
    }
    @Test
    public void numbers_are_even(){
        int[] array = {0,2,4};
        boolean result = target.getLucky(array);
        Assert.assertTrue(result);
    }
    @Test
    public void numbers_are_odd(){
        int[] array = {1,3,5,7};
        boolean result = target.getLucky(array);
        Assert.assertFalse(result);
    }
    @Test
    public void numbers_are_odd_but_not_1_and_3(){
        int[] array = {5,7,9,15};
        boolean result = target.getLucky(array);
        Assert.assertTrue(result);
    }
    @Test
    public void numbers_are_11_and_13(){
        int[] array = {11,13,15};
        boolean result = target.getLucky(array);
        Assert.assertTrue(result);
    }

}

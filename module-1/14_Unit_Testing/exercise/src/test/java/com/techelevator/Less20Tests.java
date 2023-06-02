package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {
    private Less20 target;

    @Before
    public void setup(){
        target = new Less20();
    }

    @Test
    public void two_less_than_20(){
        boolean expected = target.isLessThanMultipleOf20(18);
        Assert.assertTrue(expected);
    }
    @Test
    public void number_is_20(){
        boolean result = target.isLessThanMultipleOf20(20);
        Assert.assertFalse(result);
    }
    @Test
    public void one_over_20(){
        boolean result = target.isLessThanMultipleOf20(21);
        Assert.assertFalse(result);
    }
    @Test
    public void one_less_than_40(){
        boolean result = target.isLessThanMultipleOf20(39) ;
        Assert.assertTrue(result);
    }
    @Test
    public void number_40(){
        boolean result = target.isLessThanMultipleOf20(40) ;
        Assert.assertFalse(result);
    }
    @Test
    public void negative_number(){
        boolean result = target.isLessThanMultipleOf20(-7) ;
        Assert.assertFalse(result);
    }
}

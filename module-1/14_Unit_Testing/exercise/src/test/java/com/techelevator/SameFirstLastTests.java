package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTests {
    private SameFirstLast target;

    @Before
    public void setup(){
        target = new SameFirstLast();
    }

    @Test
    public void all_the_same_number(){
        int[] array = {4,4,4};
        boolean result = target.isItTheSame(array);
        Assert.assertTrue(result);
    }
    @Test
    public void every_number_is_different(){
        int[] array = {2,4,6,8};
        boolean result = target.isItTheSame(array);
        Assert.assertFalse(result);
    }
    @Test
    public void numbers_have_negatives(){
        int[] array = {-7,3,0,-7};
        boolean result = target.isItTheSame(array);
        Assert.assertTrue(result);
    }
    @Test
    public void only_one_number(){
        int[] array = {1};
        boolean result = target.isItTheSame(array);
        Assert.assertTrue(result);
    }
}

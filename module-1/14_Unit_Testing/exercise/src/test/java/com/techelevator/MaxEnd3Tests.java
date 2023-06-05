package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

public class MaxEnd3Tests {
    private MaxEnd3 target;

    @Before
    public void setup(){
        target = new MaxEnd3();
    }
    @Test
    public void returns_largest_int(){
        int[] array = {4,7,13};
        int[] result = target.makeArray(array);
        int[] expected = {13,13,13};
        Assert.assertArrayEquals(expected,result);
    }

    @Test
    public void returns_largest_negative(){
        int[] array = {-3,5,-1};
        int[] result = target.makeArray(array);
        int[] expected = {-1,-1,-1};
        Assert.assertArrayEquals(expected,result);
    }
    @Test
    public void returns_when_all_are_same(){
        int[] array = {15,15,15};
        int[] result = target.makeArray(array);
        int[] expected = {15,15,15};
        Assert.assertArrayEquals(expected,result);
    }
    @Test
    public void too_many_numbers_in_array(){
        int[] array = {14,13,2,8};
        int[] result = target.makeArray(array);
        Assert.assertNull(result);
    }

}

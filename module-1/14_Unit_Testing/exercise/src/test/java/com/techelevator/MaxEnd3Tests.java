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
        Assert.assertEquals(expected,result);
    }
}

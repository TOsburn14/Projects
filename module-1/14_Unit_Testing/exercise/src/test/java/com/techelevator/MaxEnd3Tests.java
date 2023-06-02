package com.techelevator;

import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Array;

public class MaxEnd3Tests {
    private MaxEnd3 target;

    @Before
    public void setup(){
        target = new MaxEnd3();
    }
    @After
    public void null_array(){
        Array[] array = null;
        Array result = target.makeArray(array);
    }
}

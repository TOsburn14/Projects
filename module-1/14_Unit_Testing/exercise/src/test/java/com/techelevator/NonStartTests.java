package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTests {
    private NonStart target;

    @Before
    public void setup(){
        target = new NonStart();
    }

    @Test
    public void words_hello_and_there(){
        String result = target.getPartialString("Hello", "There");
        String expected = "ellohere";
        Assert.assertEquals(expected,result);
    }
    @Test
    public void words_are_only_1_letter(){
        String result = target.getPartialString("L","O");
        String expected = "";
        Assert.assertEquals(expected,result);
    }
    @Test
    public void only_one_word(){
        String result = target.getPartialString("","Hello");
        String expected = "ello";
        Assert.assertEquals(expected,result);
    }
    @Test
    public void words_with_spaces(){
        String result = target.getPartialString("Testing", "This Out");
        String expected = "estinghis Out";
        Assert.assertEquals(expected,result);
    }
}

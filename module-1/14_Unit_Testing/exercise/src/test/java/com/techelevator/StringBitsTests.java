package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class StringBitsTests {
    private StringBits target;

    @Before
    public void setup(){
        target = new StringBits();
    }
    @Test
    public void string_is_null(){
        String expected = "";
        String str1 = target.getBits(null);
        Assert.assertEquals(expected,str1);
    }
    @Test
    public void word_is_only_one_letter(){
        String expected = "H";
        String result = target.getBits("H");
        Assert.assertEquals(expected,result);
    }
    @Test
    public void empty_string(){
        String expected = "";
        String result = target.getBits("");
        Assert.assertEquals(expected,result);
    }
    @Test
    public void word_returns_hello(){
        String expected = "Hello";
        String result = target.getBits("Heeololeo");
        Assert.assertEquals(expected,result);
    }
    @Test
    public void words_with_spaces(){
        String expected = "HelloHello";
        String result = target.getBits("Heeololeo Heeololeo");
        Assert.assertEquals(expected,result);
    }
}

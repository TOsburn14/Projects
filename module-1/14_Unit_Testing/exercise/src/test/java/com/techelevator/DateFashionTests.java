package com.techelevator;
import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTests {
    private DateFashion target;

    @Before
    public void setup(){
        target = new DateFashion();
    }
    @Test
    public void you_have_style_of_5_date_is_10(){
        int expected = 2;
        int actual = target.getATable(5,10);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void you_have_style_of_5_date_is_5(){
        int expected = 1;
        int actual = target.getATable(5,5);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void you_have_style_of_1_date_is_1(){
        int expected = 0;
        int actual = target.getATable(1,1);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void you_have_style_of_5_date_is_12_she_settled(){
        int expected = 2;
        int actual = target.getATable(5,12);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void you_are_ugly_she_is_hot(){
        int expected = 0;
        int actual = target.getATable(-2,15);
        Assert.assertEquals(expected,actual);
    }
}

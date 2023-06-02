package com.techelevator;
import org.junit.*;
public class FrontTimesTests {
    private FrontTimes target;
    @Before
    public void setup(){
        target = new FrontTimes();
    }

    @Test
    public void chocolate_is_chochocho(){
        String expected = "ChoChoCho";
        String actual = target.generateString("Chocolate",3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void word_is_null(){
        String expected = "";
        String actual = target.generateString(null,3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void word_is_hi(){
        String expected = "HiHiHiHi";
        String actual = target.generateString("Hi",4);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void empty_word(){
        String expected = "";
        String actual = target.generateString("",5);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void letter_is_C(){
        String expected = "CCCCCC";
        String actual = target.generateString("C",6);
        Assert.assertEquals(expected,actual);
    }
}

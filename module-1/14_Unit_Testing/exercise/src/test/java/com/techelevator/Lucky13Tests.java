package com.techelevator;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Tests {
    private Lucky13 target;
    @Before
    public void setup(){
        target = new Lucky13();
    }

    @Test
    public void number_is_null(){
        int actual = target.getLucky();
    }
}

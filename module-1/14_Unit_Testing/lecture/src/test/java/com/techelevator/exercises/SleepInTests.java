package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SleepInTests {

    private SleepIn target;

    @Before
    public void setup() {
        target = new SleepIn();
    }
    @Test
    public void sleep_in_when_weekday_and_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true,true);
        // Assert
        Assert.assertTrue(result);
    }

    @After
    public void cleanup(){
        //Tests should not have System.out.println() in them
        System.out.println("The After was called");
    }


    @Test
    public void do_not_sleep_in_when_weekday_and_not_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true,false);
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void when_not_a_weekday_and_on_vacation() {
        boolean result = target.sleepIn(false,true);
        Assert.assertTrue(result);
    }

    @Test
    public void sleep_in_when_not_weekday_and_not_vacation() {
        boolean result = target.sleepIn(false,false);
        Assert.assertTrue(result);
    }

}

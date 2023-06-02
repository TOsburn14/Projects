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

    @After
    public void cleanup() {
        // Tests should not have System.out.println() in them
        System.out.println("The After was called");
    }

    @Test
    public void sleep_in_when_weekday_and_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true, true);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void do_not_sleep_in_when_weekday_and_not_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true, false);
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void sleep_in_when_not_weekday_and_on_vacation() {
        Assert.assertTrue( target.sleepIn(false, true) );
    }

    @Test
    public void sleep_in_when_not_weekday_and_not_on_vacation() {
        Assert.assertTrue( target.sleepIn(false, false ) );
    }

}

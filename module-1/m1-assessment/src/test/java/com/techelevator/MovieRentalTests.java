package com.techelevator;

import org.junit.Before;
import org.junit.Test;


public class MovieRentalTests {
    private MovieRental target;

    @Before
    public void setup(){
        target = new MovieRental();
    }

    @Test
    public void does_this_thing_work(){
        String title = "Star Wars";
        String format = "VHS";
        boolean isPremium = true;
        double expected = 1.99;
        double result = target.priceOfRental(format,isPremium);
        //Ha. It actually freaking works
        }
    }


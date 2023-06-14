package com.techelevator;
import org.junit.*;
public class MovieRentalTests {
    private MovieRental movieRental;


    @Before
    public void setup(){
        movieRental = new MovieRental("Test","DVD",true);
    }
    @Test
    public void rental_price_for_premium_dvd(){
        Assert.assertEquals(2.99,movieRental.getRentalPrice(),0.009);
    }
    @Test
    public void calculate_late_fee_3_days(){
        Assert.assertEquals(19.99,movieRental.calculateLateFee(3),0.009);
    }

}

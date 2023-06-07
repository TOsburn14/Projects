package com.techelevator;

public class MovieRental {

    private String title;

    private String format;

    private boolean isPremiumMovie = false;

    private double rentalPrice = 0.00;

    public MovieRental() {

    }


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }

    public void setPremiumMovie(boolean premiumMovie) {
        isPremiumMovie = premiumMovie;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public MovieRental(String title,String format, boolean isPremiumMovie){
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }
    public double priceOfRental (String format, boolean isPremiumMovie){
        if (this.format == String.valueOf(format.equals("VHS"))){
            rentalPrice = .99;
        }
        if (this.format == String.valueOf(format.equals("DVD"))){
            rentalPrice = 1.99;
        }
        if (this.format == String.valueOf(format.equals("BluRay"))){
            rentalPrice = 2.99;
        }
        if (isPremiumMovie == true){
            rentalPrice += 1.00;
        }
        return rentalPrice;
        }

    public double isMovieLate(int daysLate){
        double lateFee = 0.00;
        if (daysLate >= 3){
            lateFee += 19.99;
        }
        if (daysLate == 2){
            lateFee += 3.99;
        }
        if(daysLate == 1){
            lateFee += 1.99;
        }else {
            return lateFee;
        }
        return lateFee;
    }



}



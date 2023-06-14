package com.techelevator;

public class MovieRental {

    private String title;

    private String format;

    private boolean isPremiumMovie;

    public MovieRental(String title,String format, boolean isPremiumMovie){
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }
    public double getRentalPrice(){
        double costOfRental = 0.00;
        if (format.equalsIgnoreCase("VHS")){
            costOfRental = 0.99;
        }
        if (format.equalsIgnoreCase("DVD")){
            costOfRental = 1.99;
        }
        if (format.equalsIgnoreCase("Blu-Ray")){
            costOfRental = 2.99;
        }

        if (isPremiumMovie){
            costOfRental += 1;
        }
        return costOfRental;
    }
    public double calculateLateFee(int daysLate){
        if (daysLate == 1){
            return 1.99;
        }
        if (daysLate == 2){
            return 3.99;
        }
        if (daysLate >= 3){
            return 19.99;
        }
        return 0;
    }
    public String getFormat() {
        return format;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }
    @Override
    public String toString(){
        return "MOVIE - " + title + " - " + format + " " + getRentalPrice();
    }









}



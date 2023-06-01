package com.techelevator.farm;

public class MusicBox implements Singable, Sellable {


    @Override
    public double getPrice() {
        return 15;
    }

    @Override
    public String getName() {
        return "Farm made Musicbox";
    }

    @Override
    public String getSound() {
        return "Lalalalala!";
    }
}

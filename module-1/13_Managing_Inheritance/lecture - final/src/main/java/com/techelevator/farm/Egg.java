package com.techelevator.farm;

public class Egg implements Sellable {

    @Override
    public String getName() {
        return "Egg";
    }

    @Override
    public double getPrice() {
        return .25;
    }
}

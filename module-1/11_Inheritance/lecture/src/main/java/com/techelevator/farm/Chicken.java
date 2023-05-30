package com.techelevator.farm;

public class Chicken extends FarmAnimal{

    public Chicken() {
        super("Chicken","Cluck");
    }

    @Override
    public String getSound() {
        return "THIS IS THE CHICKEN!!!";
    }
}

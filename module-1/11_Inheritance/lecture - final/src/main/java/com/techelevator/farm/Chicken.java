package com.techelevator.farm;

public class Chicken extends FarmAnimal {

    public Chicken() {
        super("Chicken", "Cluck");
    }

    public void layEgg() {
        System.out.println("The Chicken laid a egg!");
    }

    @Override
    public String getSound() {
        return "THIS IS THE CHICKEN!!!";
    }
}

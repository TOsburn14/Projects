package com.techelevator.farm;

public class Sheep extends FarmAnimal {

    public Sheep() {
        super("Sheep", "baa!", 500);
    }

    public void jump() {
        System.out.println("The sheep jumped!");
    }

}

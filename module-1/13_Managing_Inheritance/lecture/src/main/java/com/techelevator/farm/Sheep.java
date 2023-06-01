package com.techelevator.farm;

import java.security.PublicKey;

public class Sheep extends FarmAnimal {

    public Sheep() {
        super("Sheep", "baa!", 500);
    }

    public void jump() {
        System.out.println("The sheep jumped!");
    }

    public void eat() {
        System.out.println("The sheep bites");
    }
}

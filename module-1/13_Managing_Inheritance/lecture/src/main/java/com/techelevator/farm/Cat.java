package com.techelevator.farm;

public class Cat extends FarmAnimal{

    public Cat() {
        super("Cat","Meow!",100);
    }


    @Override
    public void eat() {
        System.out.println("The cat bites");
    }

/*
    getSound() cannot be overridden because it is marked final in super class
 */
//    @Override
//    public String getSound() {
//        return "MEOW!!!!";
//    }

}

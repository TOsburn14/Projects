package com.techelevator.farm;

/*
    The final keyword when applied to a class makes it so that
    class cannot be extended as a super class
 */
public final class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "Meow!", 100);
    }

    @Override
    public void eat() {
        System.out.println("The cat bites");
    }



    /*
        getSound() cannot be Overridden because it is marked final in the super class
     */
//    @Override
//    public String getSound() {
//        return "MEOW!!!!!";
//    }

}

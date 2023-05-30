package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmApp {

    public static void main(String[] args) {
        Cow theCow = new Cow();
        Chicken theChicken = new Chicken();

        System.out.println(theCow.getName());
        System.out.println(theChicken.getName());

        List<FarmAnimal> animalsOnTheFarm = new ArrayList<FarmAnimal>();
        animalsOnTheFarm.add(theCow);
        animalsOnTheFarm.add(theChicken);


        for (FarmAnimal animal : animalsOnTheFarm) {
            System.out.println( animal.toString() );
        }
    }
}

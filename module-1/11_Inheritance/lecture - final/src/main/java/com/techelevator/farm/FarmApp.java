package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class FarmApp {

    public static void main(String[] args) {

        Cow theCow = new Cow();
        Chicken theChicken = new Chicken();

        System.out.println(theCow.getName());
        System.out.println(theChicken.getName());

        theChicken.layEgg();

        List<FarmAnimal> animalsOnTheFarm = new ArrayList<FarmAnimal>();
        animalsOnTheFarm.add(theCow);
        animalsOnTheFarm.add(theChicken);

        for (FarmAnimal animal : animalsOnTheFarm) {
            // println() calls toString() behind the scenes so toString() is not actually needed here
            System.out.println( animal.toString() );
        }
    }
}

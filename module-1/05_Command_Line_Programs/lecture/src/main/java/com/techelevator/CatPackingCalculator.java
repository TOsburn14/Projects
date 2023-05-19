package com.techelevator;

import java.util.Scanner;

public class CatPackingCalculator {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        double avgVolumeOfHouseCat = 0.083;
        double estimatedPackingDensityOfCat = 0.5;

        System.out.println("What is the length of your container in feet: ");
        String lengthFromUser = userInput.nextLine();

        System.out.println("What is the width of your container in feet:  ");
        String widthFromUser = userInput.nextLine();

        System.out.println("What is the height of your container in feet:  ");
        String heightFromUser = userInput.nextLine();



        int lengthOfContainer = Integer.parseInt(lengthFromUser);
        int widthOfContainer = Integer.parseInt(widthFromUser);
        int heightOfContainer = Integer.parseInt(heightFromUser);

        int containerVolume = lengthOfContainer * widthOfContainer * heightOfContainer;
        double catsByVolume = containerVolume / avgVolumeOfHouseCat;
        double catsThatCanBePacked = catsByVolume * estimatedPackingDensityOfCat;

        System.out.printf("%1.0f cats can be packed in this container", catsThatCanBePacked );
    }
}

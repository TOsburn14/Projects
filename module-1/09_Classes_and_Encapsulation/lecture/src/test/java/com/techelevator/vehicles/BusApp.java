package com.techelevator.vehicles;

public class BusApp {
    public static void main(String[] args) {

        Bus busOne = new Bus();
        Bus busTwo = new Bus();

        busOne.setRouteName("High Street");
        busTwo.setRouteName("Front Street");

        System.out.println( "Bus is one is the " + busOne.getRouteName() );
        busOne.openDoor();


        busOne.addGas(20);
        System.out.println("The bus now has " + busOne.getGallonsOfGas());

        boolean ableToBoard = busOne.board();

        busTwo.board(10);
    }

}


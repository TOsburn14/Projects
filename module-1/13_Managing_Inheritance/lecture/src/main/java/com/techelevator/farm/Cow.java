package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!", 2500);
	}

	public void eat() {
		System.out.println("The cow bites");
	}

}
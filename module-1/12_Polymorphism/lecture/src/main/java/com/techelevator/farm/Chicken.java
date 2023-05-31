package com.techelevator.farm;

public class Chicken implements Singable {

	public Chicken() {
		super();
	}

	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String getName() {
		return "Chicken";
	}

	@Override
	public String getSound() {
		return "Cluck!";
	}
}
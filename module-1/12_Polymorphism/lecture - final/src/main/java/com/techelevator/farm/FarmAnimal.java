package com.techelevator.farm;

public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private double price;

	public FarmAnimal(String name, String sound, double price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public double getPrice() {
		return price;
	}

}
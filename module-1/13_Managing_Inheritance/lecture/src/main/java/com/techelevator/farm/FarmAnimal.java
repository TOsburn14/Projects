package com.techelevator.farm;

public abstract class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private double price;
	private boolean sleep = false;

	public FarmAnimal(String name, String sound, double price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	// An Abstract method forces a subclass to have that method and provide implementation
	// code for it, unless the subclass itself is abstract
	public abstract void eat();

	public String getName() {
		return name;
	}

	public final String getSound() {
		if (sleep) {
			return "Zzzzzz...";
		}
		return sound;
	}

	public double getPrice() {
		return price;
	}

	public void sleep() {
		this.sleep = true;
	}

	public void wake() {
		this.sleep = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FarmAnimal == false){
			return false;
		}
		FarmAnimal other = (FarmAnimal) obj;
		if (other.getName().equals(this.name) && other.getSound().equals(this.sound) && other.getPrice() == this.price){
			return true;
		}
		return false;
	}

}
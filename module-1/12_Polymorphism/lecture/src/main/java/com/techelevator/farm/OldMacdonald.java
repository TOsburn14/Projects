package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] singers = new Singable[] {
				(Singable) new Cow(), new Chicken(), (Singable) new Sheep()
		};


		FarmAnimal[] farmAnimals = new FarmAnimal[] {
		new Cow(), new FarmAnimal(), new Sheep(),};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}


	}
}
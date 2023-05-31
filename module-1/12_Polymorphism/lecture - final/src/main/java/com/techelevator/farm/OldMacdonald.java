package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow ourCow = new Cow();
		MusicBox ourMusicBox = new MusicBox();

		Singable[] singers = new Singable[] {
				ourCow, new Chicken(), new Sheep(), new Tractor(),
				ourMusicBox
		};

		FarmAnimal[] farmAnimals = new FarmAnimal[] {
				ourCow, new Chicken(), new Sheep()
		};



		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		System.out.println();
		System.out.println("Things for sale");


		List<Sellable> thingsToBeSold = new ArrayList<Sellable>();
		thingsToBeSold.add(ourCow);
		thingsToBeSold.add(new Sheep());
		thingsToBeSold.add(new Chicken());
		thingsToBeSold.add(new Egg());
		thingsToBeSold.add(ourMusicBox);

		for (Sellable item: thingsToBeSold) {
			System.out.println(
					item.getName() + " : $" + item.getPrice()
			);
		}


		/*
			The chicken can layEgg(), getName(), getSound(), and getPrice()
		 */
		Chicken chicken = new Chicken();
		chicken.layEgg();
		chicken.getName();
		chicken.getSound();
		chicken.getPrice();

		/*
			When viewed as a FarmAnimal the chicken can getName(), getSound(), and getPrice()
		 */
		FarmAnimal chickenAsFarmAnimal = chicken;
		chickenAsFarmAnimal.getPrice();
		chickenAsFarmAnimal.getSound();
		chickenAsFarmAnimal.getName();

		/*
			When viewed as a Singable the chicken can getName() and getSound()
		 */
		Singable chickenAsSingable = chicken;
		chickenAsSingable.getName();
		chickenAsSingable.getSound();

		/*
			When viewed as a Sellable the chicken can getName() and getPrice()
		 */
		Sellable chickenAsSellable = chicken;
		chickenAsSellable.getName();
		chickenAsSellable.getPrice();


	}
}
package com.techelevator;

import java.util.*;

public class Lecture_Map {


	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> animalNoises = new HashMap<String, String>();

		/*
			To add a key / value pair to the map use put(key, value)
		 */
		animalNoises.put("Cow", "Moo");
		animalNoises.put("Chicken", "Cluck");
		animalNoises.put("Dog", "Bark");
		animalNoises.put("Cat", "Meow");
		animalNoises.put("Lion", "Roar");
		animalNoises.put("Duck", "Roar");

		/*
			If use put() with a key that already exists, then the value for that key
			is updated to the new value.
		 */
		animalNoises.put("Duck", "Quack");

		/*
			To get a value from the map use get(key)
		 */
		String noiseTheCatMakes = animalNoises.get("Cat");

		/*
			If the key doesn't exist in the map, get() returns null
		 */
		String wolfNoise = animalNoises.get("Wolf");


		/*
			Can remove a key / value from the map using remove(key), it will return
			the value and then remove both the key and value from the map.

			If the key does not exist in the map, remove() returns null
		 */
		String lionNoise = animalNoises.remove("Lion");

		/*
			can use containsKey(key) to see if a specific key exists in the map
		 */
		boolean doesDogExist = animalNoises.containsKey("Dog");
		boolean doesLionExist = animalNoises.containsKey("Lion");

		/*
			can use containsValue(value) to see if a specific value exists in the map
		 */
		boolean doesValueMeowExist = animalNoises.containsValue("Meow");

		/*
			Can get the set of keys
		 */
		Set<String> mapKeys = animalNoises.keySet();

		Set<Map.Entry<String, String>> mapEntries = animalNoises.entrySet();

		for ( Map.Entry<String, String> entry : animalNoises.entrySet() ) {
			System.out.println("The " + entry.getKey() + " says " + entry.getValue());
		}

		System.out.println();
		System.out.println("####################");
		System.out.println("      MAP ORDER     ");
		System.out.println("####################");
		System.out.println();

		System.out.println("The values where inserted in the following order: 2, 10, 25, 1");


		// HashMap does not retain order
		System.out.println();
		System.out.println("  HASHMAP");
		System.out.println("Does not retain any order.  Instead it uses it's own internal ordering");

		Map<Integer, String> hashMapNumbersToWords = new HashMap<Integer, String>();

		hashMapNumbersToWords.put(2, "Two");
		hashMapNumbersToWords.put(10, "Ten");
		hashMapNumbersToWords.put(25, "Twenty-Five");
		hashMapNumbersToWords.put(1, "One");

		for (Integer number : hashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + hashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  LINKED HASHMAP");
		System.out.println("Retains the Order of Insertion");

		Map<Integer, String> linkedHashMapNumbersToWords = new LinkedHashMap<Integer, String>();

		linkedHashMapNumbersToWords.put(2, "Two");
		linkedHashMapNumbersToWords.put(10, "Ten");
		linkedHashMapNumbersToWords.put(25, "Twenty-Five");
		linkedHashMapNumbersToWords.put(1, "One");

		for (Integer number : linkedHashMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + linkedHashMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("  TREEMAP");
		System.out.println("Retains the Natural Order of the Data Type");
		System.out.println();
		System.out.println("Natural Order when numbers are Integer");

		Map<Integer, String> treeMapNumbersToWords = new TreeMap<Integer, String>();

		treeMapNumbersToWords.put(2, "Two");
		treeMapNumbersToWords.put(10, "Ten");
		treeMapNumbersToWords.put(25, "Twenty-Five");
		treeMapNumbersToWords.put(1, "One");

		for (Integer number : treeMapNumbersToWords.keySet()) {
			System.out.println(number + " is " + treeMapNumbersToWords.get(number));
		}


		System.out.println();
		System.out.println("TreeMap Natural Order when numbers are String");

		Map<String, String> treeMapNumbersAsStrings = new TreeMap<String, String>();

		treeMapNumbersAsStrings.put("2", "Two");
		treeMapNumbersAsStrings.put("10", "Ten");
		treeMapNumbersAsStrings.put("25", "Twenty-Five");
		treeMapNumbersAsStrings.put("1", "One");

		for (String number : treeMapNumbersAsStrings.keySet()) {
			System.out.println(number + " is " + treeMapNumbersAsStrings.get(number));

		}



		/*
			Create a map from the following data of product codes and names.

			A1: Candy Bar
			A2: Nut Bar
			A3: Bag of Chocolates
			B1: Potato Chips
			B2: Pretzels
			B3: Nutter Butters
			C1: Cat Treats
			C2: Dog Treats
			C3: Squirrel Treats
		 */



		/*
			Given the following Map which is users and their account balances in dollars,
			transfer $50 the funds from account Bob to account Anya
		 */
		Map<String, Double> accounts = new HashMap<String, Double>();
		accounts.put("Anya", 100d);
		accounts.put("Bob", 200d);


		/*
			Given the following List count how many times each name exists
		 */
		List<String> names = Arrays.asList(new String[]{"Rachelle", "John", "Rachelle", "Steve", "Dan", "Matt", "John", "Matt", "Rachelle", "Steve", "John", "Rachelle", "Rachelle" });


		/*
			Given the following map which tracks grades for students where the key is the student id
			and the value is their average grade.  Write code that determines which student has the highest
			score
		 */
		Map<Integer, Integer> studentGradesByIds = new HashMap<Integer, Integer>();
		studentGradesByIds.put(10, 82);
		studentGradesByIds.put(11, 61);
		studentGradesByIds.put(12, 97);
		studentGradesByIds.put(13, 48);
		studentGradesByIds.put(14, 88);


		/*
			Given the following map.  Replace all the null values with the word "default"
		 */
		Map<Integer, String> myMap = new HashMap<Integer, String>();

		myMap.put(1, "abc");
		myMap.put(2, null);
		myMap.put(3, null);
		myMap.put(4, "def");
		myMap.put(5, "null");
		myMap.put(6, null);
		myMap.put(7, "ghi");
		myMap.put(8, "jkl");


	}


}

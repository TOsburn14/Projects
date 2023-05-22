package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		int x = 10;
		int y = x;
		x = 30;

		int[] nums = new int[4];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;

		int[] nums2 = nums;

		nums2[2] = 42;


		System.out.println("************************************");
		System.out.println("******    CREATING OBJECTS    ******");
		System.out.println("************************************");

		Cake chocolateCake = new Cake("Chocolate", false);
		Cake yellowCake = new Cake("Buttercream", true);

		chocolateCake.setIcingType("Whipped");

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes).  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */

		String name = "John";
		String name2 = new String("Rachelle");

		String greeting = "Hello " + name2;

		String bootcampName = "Tech Elevator";
		bootcampName.toUpperCase();
		bootcampName = bootcampName.toUpperCase();

		char[] awesomeArray = new char[] { 'A', 'w','e','s','o','m','e'};
		String awesomeString1 = new String( awesomeArray );


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String stringName = "Tech Elevator";

		for (int i = 0; i < stringName.length(); i++) {
			System.out.println( stringName.charAt( i ) );
		}

		String substringed = stringName.substring(2, 6);

		String firstLetter = stringName.substring(0,1);

		String endOfString = stringName.substring(5);

		String lastLetter = stringName.substring( stringName.length() - 1);
		String last2Letters = stringName.substring( stringName.length() - 2 );


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		// Contains returns true if one string has the other as part of it
		boolean containsEch = stringName.contains("ech");
		int indexOfElevator = stringName.indexOf("Elevator");
		int indexOfe = stringName.indexOf("e");

		String upperCaseElevator = stringName.replace("Elevator", "ELEVATOR");

		String[] partsDividedBySpace = stringName.split(" ");
		String[] partsDividedBye = stringName.split("e");

		String trimmedString = " this string starts and ends with a space     ".trim();

		String stringOfNumber = String.valueOf(100);
		String stringOfBoolean = String.valueOf(true);

		String joinedString = String.join(" --> ", "Five", "Four", "Three", "Two", "One", "LAUNCH!");
		System.out.println(joinedString);

		char a = 'a';
		String s = "-";
		s = s + a;
		String s2 = String.valueOf(a);
	}
}

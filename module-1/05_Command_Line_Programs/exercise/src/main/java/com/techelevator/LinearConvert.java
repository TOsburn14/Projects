package com.techelevator;
import java.util.Scanner;
public class LinearConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		double lengthInFeet = 0;
		double lengthInMeters = 0;

		System.out.println("What is the length?");
		String lengthFromUser = userInput.nextLine();

		System.out.println("What is the unit of measurement? (M/F)?");
		String unitOfMeasurementFromUser  = userInput.nextLine();

		double length = Double.parseDouble(lengthFromUser);

		if (unitOfMeasurementFromUser.equals("M")){
			lengthInFeet = (length * 3.2808399);
			System.out.println(length + "m" + " is " + lengthInFeet + "f");
		}
		if (unitOfMeasurementFromUser.equals("F")){
			lengthInMeters = (length * 0.3048);
			System.out.println(length + "f" + " is " + lengthInMeters + "m");
		}
	}

}

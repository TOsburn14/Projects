package com.techelevator;
import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	int currentLargestNumber = 1;
	int previousNumber = 0;

	System.out.println("What number would you like the code to stop at?");
	String inputFromUser = userInput.nextLine();
	int highestNumber = Integer.parseInt(inputFromUser);
	for ( int i = 0 ; currentLargestNumber < highestNumber ; i++){
		System.out.println(currentLargestNumber);
		int newLargest = currentLargestNumber + previousNumber;
		previousNumber = currentLargestNumber;
		currentLargestNumber = newLargest;

	}

	}

}

package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int userNumber = 0;
		int finalCode = 0;


		System.out.println("What number would you like to convert to binary?");
		String inputFromUser = userInput.nextLine();
		int newUserNumber = Integer.parseInt(inputFromUser);
		String[] binaryCode = new String[newUserNumber];
		for (int i = 0 ; i < userNumber ; i++){
			newUserNumber /= 2;
			System.out.println();

		}
	}

}
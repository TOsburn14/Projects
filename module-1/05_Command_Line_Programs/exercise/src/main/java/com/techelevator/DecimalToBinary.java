package com.techelevator;
import java.util.Scanner;
public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int userNumber = 0;
		int finalCode = 0;
		String binaryResult = "";


		System.out.println("Please enter in a series of decimal values (separated by spaces):");
		String inputFromUser = userInput.nextLine();
		String[] partsOfString = inputFromUser.split(" ");
		for (int i = 0; i < partsOfString.length; i++) {


			int newUserNumber = Integer.parseInt(partsOfString[i]);

			String[] binaryCode = new String[newUserNumber];
			while (newUserNumber > 0) {

				//System.out.print();
				finalCode = newUserNumber % 2;
				newUserNumber = newUserNumber / 2;
				binaryResult = finalCode + binaryResult;
			}
			System.out.println(partsOfString[i] + " in binary is " + binaryResult);
			binaryResult = "";
		}
	}

	}

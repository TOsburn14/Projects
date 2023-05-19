package com.techelevator;
import java.util.Scanner;
public class TempConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		double temperatureF = 0;
		double temperatureC = 0;

		System.out.println("What is the temperature outside?");
		String temperatureFromUser = userInput.nextLine();

		System.out.println("Is the temperature Fahrenheit or Celsius? (F/C)? ");
		String fOrCFromUser = userInput.nextLine();

		double temperature = Double.parseDouble(temperatureFromUser);

		if(fOrCFromUser.equals("F")){
			temperatureC = (temperature - 32) / 1.8;
			System.out.println(temperature + "F" + " is " + temperatureC + "C");
		}
		if(fOrCFromUser.equals("C")){
			temperatureF = (temperature * 1.8) + 32;
			System.out.println(temperature + "C" +" is " + temperatureF + "F");
		}

	}


}

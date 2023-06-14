package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub



		MovieRental movieRental = new MovieRental("Ghost Ship","VHS",true);
		System.out.println(movieRental.getRentalPrice());
		System.out.println(movieRental.getTitle());
		System.out.println(movieRental.getFormat());
		System.out.println(movieRental.isPremiumMovie());

		System.out.println(movieRental);
		System.out.println(movieRental.calculateLateFee(2));

		List<MovieRental> movieRentalList = new ArrayList<MovieRental>();
		File fileObj = new File("MovieInput.csv");
		try (Scanner fileScanner = new Scanner(fileObj)){
			while (fileScanner.hasNext()){
				String lineFromFile = fileScanner.nextLine();
				String[] movieParts = lineFromFile.split(",");
				MovieRental movie = new MovieRental(movieParts[0],movieParts[1],movieParts[2].equals("true"));
				movieRentalList.add(movie);
			}
		}
		double totalRentalPrice = 0;

		for (MovieRental currentRental : movieRentalList){
			System.out.println(currentRental);
			totalRentalPrice += currentRental.getRentalPrice();
		}
		System.out.println("Total Rental Price: " + totalRentalPrice);
	}

}

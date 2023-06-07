package com.techelevator;

public class Module1CodingAssessment extends MovieRental {

	public Module1CodingAssessment(String title, String format, boolean isPremiumMovie) {
		super(title, format, isPremiumMovie);
	}

	@Override
	public String toString(){
		return this.getTitle() + "," + this.getFormat() + "," + this.getRentalPrice();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub





	}

}

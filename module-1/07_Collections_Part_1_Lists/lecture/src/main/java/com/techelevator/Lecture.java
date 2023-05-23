package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("       BigDecimal");
		System.out.println("####################");
		BigDecimal firstNumber = new BigDecimal(0);
		BigDecimal secondNumber = BigDecimal.ZERO;

		firstNumber = firstNumber.add( new BigDecimal(10));
		secondNumber = secondNumber.add(new BigDecimal(5));

		BigDecimal numbersMultiple = firstNumber.multiply(secondNumber);

		int compareValue = numbersMultiple.compareTo( new BigDecimal(1));

		if (compareValue < 0){
			System.out.println("numbersMultiple is less than 1");
		} else if (compareValue == 0) {
			System.out.println("the 2 numbersMultiple is equal to 1");
		} else if (compareValue > 0) {
			System.out.println("numbers multiple is greater than 1");
		}


		System.out.println("####################");
		System.out.println("       LocalDate");
		System.out.println("####################");

		//Today's Date
		LocalDate today = LocalDate.now();

		//Tomorrow Date
		LocalDate tomorrow = today.plusDays(1);

		//Specific Date
		LocalDate april132010 = LocalDate.of(2010,4,13);

		//Specific Date parsed from string
		LocalDate november171980 = LocalDate.parse("1980-11-17");

		//Can use a DateTimeFormatter to format the date for printing
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(dateTimeFormatter.format(april132010));

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> instructors = new ArrayList<String>();
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Dylan");
		instructors.add("Parker");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i = 0 ; i < instructors.size(); i++){
			System.out.println( instructors.get(i) );
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		instructors.add(3, "Rachelle");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");
		instructors.remove(2);

		//For a string, can remove by using the value
		instructors.remove("Parker");

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		boolean isSteveInList = instructors.contains("Steve");

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		int indexOfDylan = instructors.indexOf("Dylan");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		String[] instructorsArray = instructors.toArray( new String[instructors.size()] );

		//Convert array to a list
		String[] stringArray = new String[] {"A" , "B" , "C" , "D"};
		List<String> stringArrayAsList = Arrays.asList(stringArray);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);

		System.out.println("####################");
		System.out.println("Lists can be shuffled");
		System.out.println("####################");

		Collections.shuffle(instructors);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : instructors){
			System.out.println( name );
		}

		System.out.println("####################");
		System.out.println("       AUTOBOXING");
		System.out.println("####################");

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add( 10 );
		numbers.add( 20 );
		int x = 30;
		numbers.add( x );

		Integer referenceTypeInteger = 5;
		int primitiveInt = referenceTypeInteger;

		double primitiveDouble = 3.14;
		Double doubleReferenceType = primitiveDouble;

		Integer employees = Integer.valueOf("25");
		if (employees > 25){
			System.out.println("More than 25 employees");
		}

		Integer anotherReferenceTypeInt = 5;
		/*
		Even though anotherReferenceTypeInt is a reference type, we can use ==
		when a primitive int is also involved, because it will autobox the value of
		the Integer from the heap to the stack to do the comparison
		 */
		if (anotherReferenceTypeInt == 5){

		}

	}
}

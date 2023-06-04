package com.techelevator.exceptions;

import java.util.Locale;
import java.util.Scanner;

/*
    Demonstrates finally in a try...catch...finally and catching multiple exceptions in a single try...catch
 */

public class ExceptionsExamples {

    public void run() {
        finallyExample();
        multipleExceptionsExample();
    }

    private void finallyExample() {

        int[] nums = {1, 2, 3};
        int x = 0;
        int y = 0;

        /*
        Try block identifies code that is at risk of throwing an exception
        If the exception occurs the code after the line it was thrown on will be skipped
         */
//        try {
//            System.out.println("Start of Try block");
            x = nums[3];
            x = x + 10; // This line only runs if there is no exception on the line above it
//            System.out.println("This only runs if no exception is thrown");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            // The catch block only runs if an exception of that type occurs
//            System.out.println("This only runs when an ArrayIndexOutOfBoundsException is thrown");
//        } finally {
//            // the finally block is always run
//            y = 100;
//            System.out.println("Code in the finally always runs");
//        }

        System.out.println(x);
        System.out.println(y);
    }

    /*
        This method uses a printStackTrace() for demonstration.  printStackTrace() can be a useful
        debugging tool, but should never be left in final code.
     */
    private void multipleExceptionsExample() {
        String str = "123";

        try {
            str.toUpperCase();
            Integer.parseInt(str);
            System.out.println( str.charAt(1) );
        } catch (NullPointerException e) {
            System.out.println("String was null");
            //e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("String was not a number");
            //e.printStackTrace();
        } catch (Exception e) {  // Can use Polymorphism to catch exceptions by their superclass
            System.out.println("Some other error happened");
            //e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        ExceptionsExamples examples = new ExceptionsExamples();
        examples.run();
    }

}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        FizzWriter fizzWriter = new FizzWriter();
        fizzWriter.run();
    }

    public void run() throws FileNotFoundException {
        /* Your code goes here */
        System.out.print("Output file: ");

        String name = userInput.nextLine();
        try (PrintWriter fizzBuzzWriter = new PrintWriter(name)) {


            for (int i = 1; i <= 300; i++) {


                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzzWriter.println("FizzBuzz");
                } else if (i % 5 == 0) {
                    fizzBuzzWriter.println("Buzz");
                } else if (i % 3 == 0) {
                    fizzBuzzWriter.println("Fizz");
                } else {
                    fizzBuzzWriter.println(i);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

}

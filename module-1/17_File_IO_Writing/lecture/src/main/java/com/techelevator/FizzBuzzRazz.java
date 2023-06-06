package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/*
    1. Get the User input and output filenames
    2. Read the input file
    3. For each word in the input file lines
        - If the word length is 3 change it to FIZZ
        - If the word length is 5 change it to BUZZ
        - If the word length is 7 change it to RAZZ
        - otherwise don't change the word
    4. Write the new lines to the output file
    5. Tell the User the Process is finished
 */
public class FizzBuzzRazz {

    private final static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input file: ");
        String inputFileName = userInput.nextLine();

        System.out.print("Output file: ");
        String outputFileName = userInput.nextLine();

        //File a file object for the input file
        File inputFile = new File(inputFileName);

        // Create a file object for the output file
        File outputFile = new File(outputFileName);

        // Open the input file with a try-with-resource
        try (Scanner inputFileScanner = new Scanner(inputFile);
             PrintWriter outputFileWriter = new PrintWriter(outputFile)) {
            //While file has next line
            while (inputFileScanner.hasNextLine()) {
                String lineFromFile = inputFileScanner.nextLine();

                // Process the line from the file to determine the new line we want to write
                // to the output file
                String newLineToWrite = "";
                String[] words = lineFromFile.split(" ");
                for (String word : words) {
                    if (word.length() == 3) {
                        newLineToWrite += "Fizz";
                    } else if (word.length() == 5) {
                        newLineToWrite += "Buzz";
                    } else if (word.length() == 7) {
                        newLineToWrite += "Razz";
                    }else {
                        newLineToWrite += word;
                    }
                    newLineToWrite += " ";
                }

                // Write the line to the output file
                outputFileWriter.println(newLineToWrite);
            }
        } catch (FileNotFoundException e) {
            System.out.println(inputFile.getName() + " was not found.");

        }
    }


}

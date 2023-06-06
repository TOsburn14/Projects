package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.println("What word would you like to replace?");

        String wordToReplace = userInput.nextLine();

        System.out.println("What word would you like in its place?");

        String newWord = userInput.nextLine();

        System.out.println("What file would you like to use?");

        String txtFile = userInput.nextLine();

        System.out.println("What file would you like to import to?");

        String outputFile = userInput.nextLine();
        if (Objects.equals(wordToReplace, "")){
            System.out.println(txtFile);
        }
        try (Scanner txtInput = new Scanner(new File(txtFile));
             PrintWriter txtOutput = new PrintWriter(outputFile)){
            while (txtInput.hasNextLine()) {
                String lineOfInput = txtInput.nextLine();
                txtOutput.println(lineOfInput.replace(wordToReplace,newWord));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}

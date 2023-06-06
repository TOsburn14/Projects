package com.techelevator.reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

       /*
           STEP 1: get the filename and path as a string
        */
        String filename = "textSample.txt";

       /*
           STEP 2: create a file object and pass it the filename
        */
        File fileObject = new File(filename);
       /*
           STEP 3: Open the file with a Scanner in a try-with-resource
        */
        try (Scanner fileScanner = new Scanner(fileObject)) {
           /*
               STEP 4: Loop while hasNextLine() is true
            */
            while (fileScanner.hasNextLine()) {
                // STEP 5: use nextLine() to read the next line from the file
                String nextLineFromFile = fileScanner.nextLine();
                // The println() is just here so we can see it and not part of the process
                System.out.println(nextLineFromFile);
            }
        } catch (FileNotFoundException e) {
           /*
               STEP 6: handle the FileNotFoundException
            */
            System.out.println(fileObject.getName() + " does not exist");
        }
    }
}


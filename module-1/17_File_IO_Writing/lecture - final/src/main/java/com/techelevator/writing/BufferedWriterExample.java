package com.techelevator.writing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedWriterExample {

    public static void main(String[] args) {

        /*
         * Create a file and PrintWriter
         */
        File fileToWriteTo = new File("bufferedFile.txt");

        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */
        try ( PrintWriter printWriter = new PrintWriter( fileToWriteTo );
              BufferedWriter bufferedWriter = new BufferedWriter( printWriter ) ) {

            for (int i = 0 ; i < 10; i++) {
                bufferedWriter.write( String.valueOf( i ) );
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
}

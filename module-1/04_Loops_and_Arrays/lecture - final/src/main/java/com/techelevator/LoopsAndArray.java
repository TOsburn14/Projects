package com.techelevator;

public class LoopsAndArray {

    public static void main(String[] args) {

        /*
            Arrays
         */
        String[] instructors = new String[5];
        int[] numbers = new int[10];

        instructors[0] = "John";
        instructors[1] = "Rachelle";
        instructors[2] = "Steve";
        instructors[3] = "Matt";
        instructors[4] = "Dylan";

        instructors[4] = "Parker";

        String nameAtFirstIndex = instructors[1];
        System.out.println( nameAtFirstIndex );

        System.out.println( instructors[2] );

        int lengthOfTheArray = instructors.length;
        System.out.println("Length of the instructors array: " + lengthOfTheArray);

        // The last element of any array is always the length - 1

        /*
            If you use an index that is not in the array it will result in the program
            crashing with an ArrayIndexOutOfBoundsException
         */
        //String name = instructors[5];


        /*
            Loops
         */

        for ( int i = 0 ; i < 10 ; i++ ) {
            System.out.println(i);
        }

        /*
            for ( a variable ; a test ; change )  {
                change the variable if needed
            }
         */

        int sumOfNums = 0;
        for ( int j = 242 ; j > 50 ; j -= 4 ) {
            if ( j % 10 == 0) {
                System.out.print(j + " ");
                sumOfNums += j;
                j -= 6;
            }
        }
        System.out.println(sumOfNums);

        for (int i = 0; i < 100; i++) {
            if (i == 11) {
                // Break immediate exists the loop
                break;
            }
            System.out.println(i);
        }


        for (int i = 10; i > 0; i--) {
            if (i % 3 == 0) {
                // stops the execution of the block and continues the next iteration
                continue;
            }
            System.out.println( i );
        }

        /*
            Loops with Arrays
         */
        for (int i = 0; i < instructors.length; i++) {
            System.out.println( instructors[i] );
        }

        // Loop from index 1 to index 3
        for (int i = 1; i <= 3; i++) {
            System.out.println( instructors[i] );
        }

        int[] someNumbers = new int[]{ 10, 20, 30, 40, 50, 60 };

        // Find the sum of every other number in the array
        int sum = 0;
        for (int i = 0 ; i < someNumbers.length; i++) {
            if (i % 2 == 0) {
                sum += someNumbers[i];
            }
        }

        System.out.println(sum);

        /*
            print out every number, except 30 and one number after it
         */
        for (int i = 0 ; i < someNumbers.length; i++) {
            if (someNumbers[ i ] == 30) {
                i++;
            } else {
                System.out.println("The number is " + someNumbers[i] );
            }
        }

        // ABCABCABC
        String[] values = new String[]{"A","B", "C"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print( values[j] );
            }
        }

    }

}

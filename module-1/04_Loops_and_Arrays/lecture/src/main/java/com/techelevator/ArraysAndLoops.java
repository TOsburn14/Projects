package com.techelevator;

public class ArraysAndLoops {

    public static void main(String[] args) {

        String[] instructors = new String[5];
        int[] numbers = new int[10];

        instructors[0] = "John";
        instructors[1] = "Rachelle";
        instructors[2] = "Steve";
        instructors[3] = "Matt";
        instructors[4] = "Dylan";

        instructors[4] = "Parker";
        String nameAtFirstIndex = instructors[1];
        System.out.println(nameAtFirstIndex);


        for (int i = 0; i < 10; i++) ;
        {
            boolean i = false;
            System.out.println(i);
        }
        for (int j = 242; j > 50; j -= 4) {
            if (j % 10 == 0) {
                System.out.print(j + " ");
                j -= 6;
            }
        }
        for ( int i = 0 ; i < 100 ; i++){
            if (i == 11){
                break;
            }
            System.out.println(i);
        }


        for (int i = 10 ; i > 0 ; i--){
            if (i % 3 == 0){
                continue;
            }
            System.out.print(i);
        }
        /*
        Loops With Arrays
         */
        for (int i = 0 ; i < instructors.length; i++){
            System.out.println(instructors[i]);
        }

        // Loop from index 1 to index 3
        for (int i = 1; i <= 3; i++){
            System.out.println( instructors[i] );
        }

        int[] someNumbers = new int [] { 10, 20, 30, 40, 50, 60 };
        // find the sum of every other number in the array
        int sum = 0;
        for (int i = 0 ; i < someNumbers.length; i++){
            if (i % 2 == 0){
                sum += someNumbers[i];
            }
        }
        System.out.println(sum);


        /*
        Print out every number, except 30 and the one number after
         */
        for (int i = 0 ; i < someNumbers.length; i++){
            if (someNumbers[i] == 30){
                i++;
            } else {
                System.out.println("The number is " + someNumbers[i]);
            }
        }
    }

}


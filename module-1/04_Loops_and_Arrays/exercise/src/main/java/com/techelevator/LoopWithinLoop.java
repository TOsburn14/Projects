package com.techelevator;

public class LoopWithinLoop {
    public static void main(String[] args) {
        // ABCABCABC
        String[] values = new String[]{"A","B","C"};
        for (int i = 0; i < 3; i++){
            for (int j = 0; j< values.length; j++){
                System.out.println(values[j]);
            }
        }
    }
}

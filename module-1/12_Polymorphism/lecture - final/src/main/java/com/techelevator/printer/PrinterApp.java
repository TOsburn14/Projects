package com.techelevator.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {

        Product product = new Product("A01", "Surviving TE Book", 12.99, "", 2);
        Animal cat = new Animal("Cat", "Meow");
        StringReverse stringReverse = new StringReverse("Reverse This String");
        Fibonnaci fibonnaci = new Fibonnaci(100);

        List<Printable> printables = new ArrayList<Printable>();
        printables.add(product);
        printables.add(cat);
        printables.add(stringReverse);
        printables.add(fibonnaci);

        for (Printable printer : printables) {
            System.out.println();
            printer.print();
        }


    }
}

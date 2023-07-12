/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06sequencefibonacci;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S06SequenceFibonacci {

    /**
     * Main driver using class MyFibonacciSquence().
     *
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try {                          // try...catch to catch exception when setN is negative integer or 0.
            MyFibonacciSequence app = new MyFibonacciSequence(0); //Create object.
            app.setN(45);                                         // setN(45) to find Fibonacci sequences.
            System.out.println("The " + app.getN() + " sequence Fibonacci: "); // Display number of sequence Fibonacci on console.
            for (int i = 0; i < app.getN(); i++) {                       // Loop to display all sequence Fibonacci.
                if (i != app.getN() - 1) {                               // Check index if not last value display number and comma.
                    System.out.print(app.recursionFibonacci(i) + ", ");
                } else {                                        // Check index if last value don't display comma.
                    System.out.println(app.recursionFibonacci(i));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());     // Display exception.
        }
    }
}

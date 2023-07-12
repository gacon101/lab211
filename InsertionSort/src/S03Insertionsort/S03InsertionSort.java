/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S03Insertionsort;

import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author trong
 */
public class S03InsertionSort {

    /**
     * Main driver for using class MyInsertionSort().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String n = "";
        boolean flag = true;                // Flag to check when user input from keyboard wrong input format.
        System.out.println("Enter number of array: ");
        do {                                // do...while for accept input until right format input.
            try {                           // try...catch to catch exception.
                flag = false;               // Flag false for break do...while for user input.
                n = sc.nextLine();          // Read input from keyboard of user.
                if (Integer.parseInt(n) < 0 || n.isEmpty()) { // If input from keyboard of user less than 0 or user input empty value.
                    flag = true;             // Flag will turn true and display notification for user.
                    System.err.println("Only accept integer!!!");
                }
            } catch (Exception e) {         // Cacth exception if user try to break program.
                flag = true;                // Flag will turn true and display notification.
                System.err.println("Don't allow alphabet, character and input empty!!!");
            }
        } while (flag == true);             // Loop will be start when flag is true. User can input again.
        MyInsertionSort app = new MyInsertionSort(Integer.parseInt(n)); // Create object.
        System.out.println("Unsorted array: " + app);     // Display unsorted array on console.
        app.sort();                                       // Call method sort().
        System.out.println("Sorted array: " + app);       // Display sorted array on console after sorted.
    }
}

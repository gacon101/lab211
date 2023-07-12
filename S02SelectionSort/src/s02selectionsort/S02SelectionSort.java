/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02selectionsort;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S02SelectionSort {

    /**
     * Main driver for class MySelectionSort().
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean flag = true;     // Flag to check when user input from keyboard wrong input format.
        String n = "";                  
        System.out.println("Enter number array: ");
        do {                     // do...while for accept input until right format input.
            try {                // try...catch to catch exception.
                flag = false;    // Flag false for break do...while for user input.
                n = sc.nextLine();  // Read input from keyboard of user.
                if (Integer.parseInt(n) < 0 || n.isEmpty()) {       // If input from keyboard of user less than 0.
                    flag = true;    // Flag will turn true and print notification for user.
                    System.err.println("Accept positive integer only!!!");
                }
            } catch (Exception e) { // Cacth exception if user try to break program.
                flag = true;        // Flag will turn true and print notification.
                System.err.println("Don't allow alphabet, charater and empty input!!!");
            }
        } while (flag == true);    // Loop will be start when flag is true. User can input again.
        MySelectionSort app = new MySelectionSort(Integer.parseInt(n)); // Create object.
        System.out.println("Unsorted array: " + app);   // Print unsorted array on console.
        app.sort();                                     // Call method sort().
        System.out.println("Sorted array: " + app);     // Print sorted array on console after sorted.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04binarysearch;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S04BinarySearch {

    /**
     * Main driver for using class MyBinarySearch().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String size = "";           // String size contain size of array.
        String numberToFind = "";   // String numberToFind contain number to find in the array.
        boolean flag = true;        // Boolean flag to check when user input from keyboard wrong input format.
        System.out.println("Enter number of array: ");
        do {                        // do...while for accept input until right format input.
            try {                   // try...catch to catch exception.
                flag = false;       // Flag false for break do...while for user input.
                size = sc.nextLine();   // Read input from keyboard of user.
                if (size.isEmpty() || Integer.parseInt(size) < 0) { // If input from keyboard of user less than 0.
                    flag = true;    // Flag will turn true and display notification for user.
                    System.err.println("Only accept positive integer!!!");
                }
            } catch (Exception e) { // Cacth exception if user try to break program.
                flag = true;        //Flag will turn true and display notification for user.
                System.err.println("Don't allow alphabet, chacracter and iput is empty!!!");
            }
        } while (flag == true);     // Loop will be start when flag is true. User can input again.
        System.out.println("Enter search value: ");
        do {                        // do...while for accept input until right format input.
            try {                   // try...catch to catch exception.
                flag = false;       // Flag false for break do...while for user input.
                numberToFind = sc.nextLine();   // Read input from keyboard of user.
                if (numberToFind.isEmpty() || Integer.parseInt(numberToFind) < 0) { // If input from keyboard of user less than 0 or user input empty value.
                    flag = true;     // Flag will turn true and display notification for user.
                    System.err.println("Only accept positive integer!!!");
                }
            } catch (Exception e) { // Cacth exception if user try to break program.
                flag = true;        //Flag will turn true and display notification for user.
                System.err.println("Don't allow alphabet, chacracter and iput is empty!!!");
            }
        } while (flag == true);     // Loop will be start when flag is true. User can input again.
        MyBinarySearch app = new MyBinarySearch(Integer.parseInt(size)); // Create object.
        app.sort();                 // Call method sort().
        System.out.println("Sorted array: " + app);     // Display sorted array on console after sorted.
        app.binarySearch(Integer.parseInt(numberToFind)); // Call method binarySearch() and display on console.
    }
}

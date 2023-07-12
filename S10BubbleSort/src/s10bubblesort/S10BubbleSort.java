/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10bubblesort;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S10BubbleSort {

    /**
     * Main driver for using class MyBubbleSort().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyBubbleSort app = new MyBubbleSort();  // Create object.
        try {
            Scanner sc = new Scanner(System.in);
            String choice = "";
            do {
                System.out.println("========= Bubble Sort Program =========");
                System.out.println("1. Input element");
                System.out.println("2. Sort Ascending");
                System.out.println("3. Sort Descending");
                System.out.println("4. Exit");
                boolean flag = true;        // Flag to check when user input from keyboard wrong input format.
                do {                         // do...while for accept input until right format input.
                    try {                   // try...catch to catch exception.
                        flag = false;        // Flag false for break do...while for user input.
                        System.out.print("Please choice one option: ");
                        choice = sc.nextLine();     // Read input from keyboard of user.
                        if (choice.isEmpty() || Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 5) {  // If input from keyboard of user less than 0 or user input empty value.
                            flag = true;        // Flag will turn true and display notification for user.
                            System.out.println("You must choose option follow the menu and choice can't be empty!!!");
                        }
                    } catch (Exception e) {   // Cacth exception if user try to break program.
                        flag = true;          // Flag will turn true and display notification.
                        System.out.println("Don't allow aphabet and character!!!");
                    }
                } while (flag == true);      // Loop will be start when flag is true. User can input again.

                switch (Integer.parseInt(choice)) { // Switch...case for create option for menu.
                    case 1:                       // Option 1 input element to array.                 
                        System.out.println("----- Input Element -----");
                        app.createArray();        // Call method from class MyBubbleSort().
                        app.inputElements();       // Call method from class MyBubbleSort().
                        break;
                    case 2:                       // Option 2 sort increasing element in array.
                        System.out.println("----- Ascending -----");
                        try {             // try...catch exception.
                            app.sortAscending();   // Call method from class MyBubbleSort().
                            app.displayAscending();   // Call method from class MyBubbleSort().
                            System.out.println();
                        } catch (Exception e) {     // Catch exception when array is empty.
                            System.out.println("No data");
                        }
                        break;
                    case 3:                        // Option 3 sort decreasing element in array.
                        System.out.println("----- Descending -----");
                        try {              // try...catch exception.
                            app.sortDescending();      // Call method from class MyBubbleSort().
                            app.displayDescending();   // Call method from class MyBubbleSort().
                            System.out.println();
                        } catch (Exception e) {      // Catch exception when array is empty.
                            System.out.println("No data");
                        }
                        break;
                    case 4:             // Option 4 exist program.
                        System.out.println("Thank's for using my software.");
                        System.exit(0);
                        break;
                }
            } while (Integer.parseInt(choice) != 5); // If choice over 5 loop for input again.
        } catch (Exception e) {                 // Catch exception in program.
            System.out.println(e.getMessage());
        }
    }

}

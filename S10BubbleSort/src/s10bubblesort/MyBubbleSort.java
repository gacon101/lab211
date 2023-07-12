/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10bubblesort;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class MyBubbleSort {

    private int[] a;

    /**
     * Constructor using in class main. In this constructor don't have
     * parameter.
     */
    public MyBubbleSort() {

    }

    /**
     * Method createArray() for create array. When user run the program. This
     * method will be call and create array to use. In this method have variable
     * n to catch size of array. method inputSize() for allow user input from
     * keyboard.
     */
    public void createArray() {
        int n = inputSize();     // Get size of array by inputSize().
        this.a = new int[n];    // Create array with size n.
    }

    /**
     * Method inputSize() for allow user input from keyboard. Method inputSize()
     * will check input from keyboard first and return value after. size.isEmpty
     * will check empty value input situation. Integer.parseInt() will convert
     * String to Integer. The loop will loop until user input correct format.
     * try...catch for catch exception.
     *
     * @return size to get size of array.
     */
    public int inputSize() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for get input from user keyboard.
        boolean flag = true;             // boolean flag = true to check the loop.
        String size = "";               // String size = "" the variable to contain value of size array.
        do {                        // Loop to check input from keyboard.
            try {                   // try...catch for catch exception. 
                flag = false;       //flag = false for pause the loop.
                System.out.print("Enter number: ");  // Show input notification for user start input from keyboard. 
                size = sc.nextLine();   // Scan input from user keyboard.
                if (size.isEmpty() || Integer.parseInt(size) < 0) {  // If input size is empty or less than zero notification will be show on console.
                    flag = true;   // Flag will be true and the loop will be loop for user input again.
                    System.out.println("Number must be greater than zero and can't be empty!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch excepttion and show notification.
                flag = true;        // Flag will be true and the loop will be loop for user input again.
                System.out.println("Don't allow alphabet and character!!!");  // Notification in this situation.
            }
        } while (flag == true);    // The loop will stop when flag is false.
        return Integer.parseInt(size); // Return value of size.
    }

    /**
     * Method inputElements() to get input element in array from user keyboard.
     * Method allow user input from keyboard and check exception. The for loop
     * to scan array. try...catch to catch exception when input fall in
     * exception situation.
     */
    public void inputElements() {
        Scanner sc = new Scanner(System.in); // Create Scanner for user input from keyboard.
        boolean flag = true;                 // boolean flag = true to check the loop.
        for (int i = 0; i < a.length; i++) {    // Scan the array.
            do {            // Loop to check input from keyboard.
                try {       // try..catch for catch exception.
                    flag = false;  // Flag is false to pause the loop for user input from keyboard.
                    System.out.print("Enter number " + (i + 1) + ": ");  // Show the input notification for user input value from keyboard.
                    a[i] = sc.nextInt();   // Get input from keyboard.
                } catch (InputMismatchException e) {  // Catch exception.
                    flag = true;            // Flag will be true, user input again and show exception notification
                    System.out.println("Only accept integer!!!"); // Notification in this situation.
                }
                sc.nextLine();
            } while (flag == true);    // Flag will be stop when flag is false.
        }
    }

    /**
     * Method sortAscending will sort increasing elements in array by using
     * Bubble sort algorithm. In this algorithm: + Traverse from left and
     * compare adjacent elements and the higher one is placed at right side. +
     * In this way, the largest element is moved to the rightmost end at first.
     * + This process is then continued to find the second largest and place it
     * and so on until the data is sorted.
     */
    public void sortAscending() {
        int tmp;           // Create variable tmp for swap value element in array.
        for (int i = 0; i < a.length - 1; i++) {     // Fisrt for loop to scan array form elemnt index 0 to element index n - 1(last index).
            for (int j = 0; j < a.length - i - 1; j++) {  //Second for loop to scan array elemnet for swaping.
                if (a[j + 1] < a[j]) {        // If index j+1 < index j start swaping.
                    tmp = a[j];             // Variable tmp equal value element at index j.
                    a[j] = a[j + 1];        // Value element at index j equal value element at index j+1.
                    a[j + 1] = tmp;         // Value element at index j+1 equal value of variable tmp.
                }
            }
        }
    }

    /**
     * Method sortAscending will sort decreasing elements in array by using Bubble sort algorithm. 
     * In this algorithm: 
     * + Traverse from left and compare adjacent elements and the higher one is placed at left side. 
     * + In this way, the largest element is moved to the leftmost end at first. 
     * + This process is then continued to find the second largest and place it and so on until the data is sorted.
     */
    public void sortDescending() {
        int tmp;                // Create variable tmp for swap value element in array.
        for (int i = 0; i < a.length - 1; i++) {    // Fisrt for loop to scan array form elemnt index 0 to element index n - 1(last index).
            for (int j = 0; j < a.length - i - 1; j++) {  //Second for loop to scan array elemnet for swaping.
                if (a[j] < a[j + 1]) {              // If index j+1 > index j start swaping.
                    tmp = a[j];                 // Variable tmp equal value element at index j.
                    a[j] = a[j + 1];            // Value element at index j equal value element at index j+1.
                    a[j + 1] = tmp;             // Value element at index j+1 equal value of variable tmp.
                }
            }
        }
    }

    /**
     * Method displayAscending to display ascending element array on console.
     * The for loop to scan all elements in the array. 
     * If index i is not a last index print arrow. 
     * If index i is a last index clear arrow.
     */
    public void displayAscending() {
        for (int i = 0; i < a.length; i++) {  // The for loop to scan all element in the array, from index 0 to last index.
            if (i != a.length - 1) {          // If i is last index in the array display result on console with arrow.
                System.out.print("[" + a[i] + "]" + "->"); // This is result in this situation.
            } else {                          // If i is last index in the array display result on console without arrow.
                System.out.print("[" + a[i] + "]"); // This is result in ths situation.
            }
        }
    }

    /**
     * Method displayAscending to display ascending element array on console.
     * The for loop to scan all elements in the array. 
     * If index i is not a last index print arrow. 
     * If index i is a last index clear arrow.
     */
    public void displayDescending() {
        for (int i = 0; i < a.length; i++) {       // The for loop to scan all element in the array, from index 0 to last index.
            if (i != a.length - 1) {               // If i is last index in the array display result on console with arrow.
                System.out.print("[" + a[i] + "]" + "<-");  // This is result in this situation.
            } else {                                // If i is last index in the array display result on console without arrow.
                System.out.print("[" + a[i] + "]");  // This is result in ths situation.
            }
        }
    }
}

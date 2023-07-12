/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04binarysearch;

import java.util.Random;

/**
 *
 * @author trong
 */
public class MyBinarySearch {

    private int[] a;

    /**
     * Constructor using in main class. 
     *    Constructor have min = 0 max = 9 for generate random number from 0 to 9. 
     *    Random r = new Random for generate random number. 
     *    For loop to scan array elements. 
     *    a[i] = r.nextInt((max - min) + 1) + min for generate random elements value from 0 to 9
     * @param n size of array.
     */
    public MyBinarySearch(int n) {
        int min = 0;
        int max = 9;
        a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt((max - min) + 1) - min;
        }
    }

    /**
     * Method sort() to sort elements in array using Insertion sort algorithm.
     * To sort an array of size N in ascending order: 
     *    Iterate from a[1] to a[n] over the array. 
     *    Compare the current element (curentValue) to its predecessor. 
     *    If the curentValue element is smaller than its predecessor, compare it to the elements before. 
     *    Move the greater elements one position up to make space for the swapped element.
     */
    public void sort() {
        int curentValue, j;
        for (int i = 1; i < a.length; i++) {
            curentValue = a[i];
            j = i - 1;

            /* Move elements of a[0..i-1], that are
               greater than curentValue, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > curentValue) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curentValue;
        }
    }

    /**
     * Method binarySerach() to find number using Binary search algorithm.
     * 
     * The basic steps to perform Binary Search are:
     *      1.Set the low index to the first element of the array and the high index to the last element. 
     *      2.Set the middle index to the average of the low and high indices. 
     *          +If the element at the middle index is the target element, return the middle index. 
     *          +Otherwise, based on the value of the key to be found and the value of the middle element, decide the next search space. 
     *              ++If the target is less than the element at the middle index, set the high index to middlePosition – 1. 
     *              ++If the target is greater than the element at the middle index, set the low index to middlePosition + 1. 
     *      3.Perform step 2 repeatedly until the target element is found or the search space is exhausted.
     * @param numberToFind
     * @return -1;
     */
    public int binarySearch(int numberToFind) {
        int low = 0;                            // First element in the array.
        int high = a.length - 1;                // Last element in the array.
        int middlePosition, middleNumber;       // middlePosition is middle index in the array, middleNumber is value of middle index in the array.
        while (low <= high) {                   // Loop to find average in the array.
            middlePosition = (low + high) / 2;  // middlePosition = (low + high)/2 to find the average of the array.
            middleNumber = a[middlePosition];   // middleNumber will be equal middlePosition value.
            if (numberToFind == middleNumber) {    // Check if nimberToFind is present at mid.
                System.out.println("Foud " + middleNumber + " at index: " + middlePosition); // Display on console result.
                return middlePosition;              // Return index of array.
            }
            if (numberToFind < middleNumber) {    // Check if numberToFind is smaller than middleNumber.
                high = middlePosition - 1;        // High(last index in the array) will be equal middlePosition - 1.
            } else {                              // Check if numberToFind greater than middleNumber.
                low = middlePosition + 1;         // Low(first idex in array) will be equal middlePosition.
            }
        }
        // if we reach here, then element was not present.
        System.out.println("Value " + numberToFind + " don't exist in the array."); // Display on console result.
        return -1;                                  
    }
    
    /**
     * Override toString for format display the array on console. 
     *  String str will display "[" at first elements (a[0]). 
     *  Loop for display next element in array with ", ". 
     *  In last element display "]". 
     * @return str.
     **/
    @Override
    public String toString() {
        String str = "[" + a[0];
        for (int i = 1; i < a.length; i++) {
            str += ", " + a[i];
        }
        str += "]";
        return str;
    }
}

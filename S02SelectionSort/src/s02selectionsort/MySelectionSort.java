/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02selectionsort;

import java.util.Random;

/**
 *
 * @author trong
 */
public class MySelectionSort {

    private int[] a;

    /**
     *  Constructor using in main class.
     *  Constructor have min = 0 max = 9 for generate random number from 0 to 9.
     *  Random rnd = new Random for generate random number.
     *  For loop to scan array elements.
     *  a[i] = rnd.nextInt((max - min) + 1) + min for generate random elements value from 0 to 9
     * @param n
     */
    public MySelectionSort(int n) {
        int min = 0;
        int max = 9;
        a = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rnd.nextInt((max - min) + 1) + min;
        }

    }


    /**
     *  Method sort() to sort elements in array using Selection sort algorithm.
     *  Follow the below steps to solve the problem:
     *      Initialize minimum value(min_idx) to location 0.
     *     Traverse the array to find the minimum element in the array.
     *      While traversing if any element smaller than min_idx is found then swap both values.
     *      Then, increment min_idx to point to the next element.
     *      Repeat until the array is sorted.
     *
     */
    public void sort() {
        for (int i = 0; i < a.length - 1; i++) {   // One by one move boundary of unsorted subarray
            int min_idx = i;                       // Find the minimum element in unsorted array
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;//searching for lowest index  
                }
            }
             // Swap the found minimum element with the first
            // element
            int smallerNumber = a[min_idx];
            a[min_idx] = a[i];
            a[i] = smallerNumber;
        }
    }
    /**
     * Override toString for format display the array on console.
     * 
     * 
     * @return 
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

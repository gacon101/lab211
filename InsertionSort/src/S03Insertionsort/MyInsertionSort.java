/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S03Insertionsort;

import java.util.Random;

/**
 *
 * @author trong
 */
public class MyInsertionSort {

    private int[] a;

    /**
     * Constructor using in main class. 
     * Constructor have min = 0 max = 9 for generate random number from 0 to 9. 
     * Random r = new Random for generate random number. 
     * For loop to scan array elements. 
     * a[i] = r.nextInt((max - min) + 1) + min for generate random elements value from 0 to 9
     * @param n size of array.
     */
    public MyInsertionSort(int n) {
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
     *      Iterate from a[1] to a[N] over the array. 
     *      Compare the current element (curentValue) to its predecessor. 
     *      If the curentValue element is smaller than its predecessor, compare it to the elements before. 
     *      Move the greater elements one position up to make space for the swapped element.
     */
    public void sort() {
        int curentValue, j;
        for (int i = 1; i < a.length; i++) {
            curentValue = a[i];
            j = i - 1;

            // Move elements of a[0..i-1], that are greater than curentValue, to one position ahead of their current position 
            while (j >= 0 && a[j] > curentValue) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = curentValue;
        }
    }

    /**
     * Override toString for format display the array on console. 
     * String str will display "[" at first elements (a[0]). 
     * Loop for display next element in array with ", ". 
     * In last element display "]". 
     * @return str.
     */
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

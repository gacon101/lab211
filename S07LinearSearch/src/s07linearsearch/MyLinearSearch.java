/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07linearsearch;

import java.util.Random;

/**
 *
 * @author trong
 */
public class MyLinearSearch {
    private int[] a;

    /**
     *  Constructor using in main class. 
     *    Constructor have min = 0 max = 9 for generate random number from 0 to 9. 
     *    Random r = new Random for generate random number. 
     *    For loop to scan array elements. 
     *    a[i] = r.nextInt((max - min) + 1) + min for generate random elements value from 0 to 9
     * @param n size of array.
     */
    public MyLinearSearch(int n) {
        int min = 0;
        int max = 9;
        a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt((max - min) + 1) - min;
        }
    }
    
    /**
     *  Method sort() to sort elements in array using Insertion sort algorithm.
     *  To sort an array of size N in ascending order: 
     *    Iterate from a[1] to a[n] over the array. 
     *    Compare the current element (curentValue) to its predecessor. 
     *    If the curentValue element is smaller than its predecessor, compare it to the elements before. 
     *    Move the greater elements one position up to make space for the swapped element.
     */
    public void sort(){
        int curentValue, j;
        for (int i = 0; i < a.length; i++) {
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
     * Method linearSerach() to find number using Linear search algorithm. 
     * In Linear Search Algorithm: 
     *  Every element is considered as a potential match for the key and checked for the same.
     *  If any element is found equal to the key, the search is successful and the index of that element is returned.
     *  If no element is found equal to the key, the search yields “No match found”.
     * @param numberToFind to find number in array.
     * @return -1 when value don't exist in the array, i when value is exist in the array.
     */
    public int linearSearch(int numberToFind){
        for (int i = 0; i < a.length; i++) {      //For loop to scan array to find number and index.
            if (a[i] == numberToFind) {           //If numberToFind equal value at index a[i]  
                System.out.println("Foud " + a[i] + " at index: " + i); //Display that to console.
                return i;                          //Return index i.
            }
        }
        System.out.println("Value " + numberToFind + " don't exist in the array.");  //If the numberToFind don't exist in the array display on console.
        return -1;                                 //Return -1 when value don't exist in the array.                 
    }
    
    /**
     * Override toString for format display the array on console. 
     *  String str will display "[" at first elements (a[0]). 
     *  Loop for display next element in array with ", ". 
     *  In last element display "]". 
     * @return str display the array on console.
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

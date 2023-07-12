/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01bubblesort;

import java.util.Random;

/**
 *
 * @author trong
 */
public class MyBubbleSort {

    private int[] a;

    /**
     *  Constructor using in main class.
     *  Constructor have min = 0 max = 9 for generate random number from 0 to 9.
     *  Random rnd = new Random for generate random number.
     *  For loop to scan array elements.
     *  a[i] = rnd.nextInt((max - min) + 1) + min for generate random elements value from 0 to 9
     * @param n
     */
    public MyBubbleSort(int n){
        int min = 0;
        int max = 9;
        a = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rnd.nextInt((max - min) + 1) + min;
        }
    }

    /**
     *
     */
    public void sort() {
        int tmp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
    
    public void findMinMax(int size){
        int min = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            min = a[0];
            max = a[size -1];
        }
        System.out.println("Min: " + min +" Max: " + max);
    }
    
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

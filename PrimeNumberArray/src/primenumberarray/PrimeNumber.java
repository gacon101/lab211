/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumberarray;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class PrimeNumber {

    private int[] array;

    public PrimeNumber(int size) {
        int min = 0;
        int max = 99;
        Random r = new Random();
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt((max - min) + 1) + min;
        }
    }

    public void findPrimeNumber() {
        int count = 0;
        System.out.print("Prime number is/are: ");
        for (int i = 0; i < array.length; i++) {
            count = 0;
            for (int j = 1; j <= array[i]; j++) {
                if (array[i] % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String str = "[" + array[0];
        for (int i = 0; i < array.length; i++) {
            str += ", " + array[i];
        }
        str += "]";
        return str;
    }

}

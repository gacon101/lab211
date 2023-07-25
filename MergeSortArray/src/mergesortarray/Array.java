/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortarray;

import java.util.Random;

/**
 *
 * @author trong
 */
public class Array {

    private int array1[];
    private int array2[];
    private int mergeArray[];

    public Array(int size) {
        int min = 0;
        int max = 99;
        Random rand = new Random();
        array1 = new int[size];
        array2 = new int[size];
        for (int i = 0; i < size; i++) {
            array1[i] = rand.nextInt((max - min) + 1) + min;
        }
        for (int i = 0; i < size; i++) {
            array2[i] = rand.nextInt((max - min) + 1) + min;
        }
    }

    public void displayArray1() {
        System.out.print("First Array: [");
        for (int i = 0; i < this.array1.length; i++) {
            if (i != this.array1.length - 1) {
                System.out.print(this.array1[i] + ", ");
            } else {
                System.out.println(this.array1[i] + "]");
            }
        }
    }

    public void displayArray2() {
        System.out.print("Second Array: [");
        for (int i = 0; i < this.array2.length; i++) {
            if (i != this.array2.length - 1) {
                System.out.print(this.array2[i] + ", ");
            } else {
                System.out.println(this.array2[i] + "]");
            }
        }
    }

    public void mergeArray() {
        int fisrArray = array1.length;
        int secondArray = array2.length;
        this.mergeArray = new int[fisrArray + secondArray];
        System.arraycopy(this.array1, 0, this.mergeArray, 0, fisrArray);
        System.arraycopy(this.array2, 0, this.mergeArray, fisrArray, secondArray);
    }

    public void displayMergeArray() {
        System.out.print("Merge Array: [");
        for (int i = 0; i < this.mergeArray.length; i++) {
            if (i != this.mergeArray.length - 1) {
                System.out.print(this.mergeArray[i] + ", ");
            } else {
                System.out.println(this.mergeArray[i] + "]");
            }
        }
    }

    public void bubbleSrotArray() {
        int tmp;
        for (int i = 0; i < this.mergeArray.length - 1; i++) {
            for (int j = 0; j < this.mergeArray.length - i - 1; j++) {
                if (this.mergeArray[j + 1] < this.mergeArray[j]) {
                    tmp = this.mergeArray[j];
                    this.mergeArray[j] = this.mergeArray[j + 1];
                    this.mergeArray[j + 1] = tmp;
                }
            }
        }
    }

    public void findMinMaxInMergeArray() {
        int min = 0;
        int max = 0;
        int size = this.mergeArray.length;
        for (int i = 0; i < size; i++) {
            min = this.mergeArray[0];
            max = this.mergeArray[size - 1];
        }
        System.out.println("Min Value In Merge Array: " + min);
        System.out.println("Max Value In Merge Array: " + max);
    }
}

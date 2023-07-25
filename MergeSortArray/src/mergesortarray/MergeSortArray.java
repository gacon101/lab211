/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortarray;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class MergeSortArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = 0;
        InputSize input = new InputSize();
        size = input.inputSize();
        Array array = new Array(size);
        array.displayArray1();
        array.displayArray2();
        array.mergeArray();
        System.out.print("Unsorted ");
        array.displayMergeArray();
        array.bubbleSrotArray();
        System.out.print("Sorted ");
        array.displayMergeArray();
        array.findMinMaxInMergeArray();
    }
    
}

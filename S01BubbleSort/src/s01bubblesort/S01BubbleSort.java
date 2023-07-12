/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s01bubblesort;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S01BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int n = 0;
        System.out.println("Enter number array: ");
        do {
            try {
                flag = false;
                n = sc.nextInt();
                if (n < 0) {
                    flag = true;
                    System.err.println("Accept positive integer only!!!");
                }
            } catch (Exception e) {
                flag = true;
                System.err.println("Don't allow alphabet!!!");
            }
            sc.nextLine();
        } while (flag == true);
        MyBubbleSort app = new MyBubbleSort(n);
        System.out.println("Unsorted array: " + app);
        app.sort();
        System.out.println("Sorted array: " + app);
        app.findMinMax(n);
    }
}

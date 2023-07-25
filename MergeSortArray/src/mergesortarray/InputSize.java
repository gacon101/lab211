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
public class InputSize {

    private Scanner sc = new Scanner(System.in);
    private int size;

    public InputSize() {
        this.size = 0;
    }

    public int inputSize() {
        String size = null;
        boolean flag = true;
        do {
            try {
                flag = false;
                System.out.print("Enter Size Of Array: ");
                size = this.sc.nextLine();
                if (size.isEmpty()) {
                    flag = true;
                    System.out.println("Size can't be empty!!!");
                }
                if (Integer.parseInt(size) <= 0 || Integer.parseInt(size) > 10) {
                    flag = true;
                    System.out.println("Size must be greater than 0 and must not exceed 10!!!");
                }
            } catch (Exception e) {
                if (!size.isEmpty()) {
                    flag = true;
                    System.out.println("Don't allow alphabet, special character and double number!!!");
                }
            }
        } while (flag == true);
        return Integer.parseInt(size);
    }
}

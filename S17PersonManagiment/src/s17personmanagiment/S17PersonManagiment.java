/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s17personmanagiment;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S17PersonManagiment {

    /**
     * Main driver for using program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);    // Create scanner for allow user can input from keyboard.
        String size = "";   // This variable will contain input of user and use for defind the size of ArrayList.
        boolean flag = true;    // Flag will check the loop when user input incorrect.
        do {    // do...while loop when user input from keyboard incorrcect.
            try {   // try...catch to catch exception if user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter size of list user: ");  // Notification for user know to input data.
                size = sc.nextLine();   // Scanner input from keyboard of user.
                if (size.isEmpty()) {   // If user don't input anything display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Size can't be empty!!!");   // Notification in this situation.
                }
                if (Integer.parseInt(size) <= 0) {  // If input of user less than zero display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Size must be positive integer!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                if (!size.isEmpty()) {  // Catch alphabet and character.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Input size incorrect!!!");  // Notification in this situation.
                }
            }
        } while (flag == true); // The loop will be loop when flag is true.

        PersonManagement pm = new PersonManagement(Integer.parseInt(size)); // Create object.
        for (int i = 0; i < Integer.parseInt(size); i++) {  // The loop will scan all object.
            System.out.println("Person [" + (i + 1) + "]"); // Display notifiation.
            String name = pm.inputName();   // Call method for user input.
            String address = pm.inputAddress(); // Call method for user input.
            double salary = pm.inputSalary();   // Call method for user input.
            pm.addPerson(name, address, salary);    // Call method addPerson() to add object.
        }
        pm.sortBySalary();  // Call method sortBySalary() to sort before display.
        pm.displayPerson(); // Call method displayPerson to display object.
    }

}

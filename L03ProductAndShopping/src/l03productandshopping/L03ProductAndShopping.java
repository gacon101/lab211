/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03productandshopping;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class L03ProductAndShopping {

    /**
     * Main driver for class ShopManagement().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ShopManagement sm = new ShopManagement();   // Create object.
        try {  // try...catch exception of user input.
            Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
            String choice = "";                   // This variable catch input from keyboard of user.
            boolean flag = true;                // Flag can to check input of user correct or not
            do {        // do...while the loop will check start when input incorrect.
                System.out.println("========= Fruits Shop =========");
                System.out.println("1. Create fruit");
                System.out.println("2. View orders");
                System.out.println("3. Shopping (for buyer)");
                System.out.println("4. Exit");
                do { // The loop check input choice of user.
                    try { // try...catch to catch exception.
                        flag = false;  // Flag is false to pause the loop for user input from keyboard.
                        System.out.print("   Please enter: ");  // Notificaton for user know to input.
                        choice = sc.nextLine();  // Scanner input of user from keyboard.
                        if (choice.isEmpty()) { // If input of use is empty show notification.
                            flag = true;        // Flag will be true to show notification and allow user input again.
                            System.out.println("Don't allow empty input!!!"); // Notification in this situation.
                        }
                        if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 5) { // If user input over the range show notification.
                            flag = true;  // Flag will be true to show notification and allow user input again.
                            System.out.println("Please choose follow the menu option!!!"); // Notification in this situation.
                        }
                    } catch (Exception e) { // Catch exception if have throw exception.
                        if (!choice.isEmpty()) {  // If input of user is not empty show notification.
                            flag = true;  // Flag will be true to show notification and allow user input again.
                            System.out.println("Don't allow alphabet and charater!!!");  // notification in this situation. 
                        }
                    }
                } while (flag == true);  // The loop will be start when flag is true.
                switch (Integer.parseInt(choice)) { // Switch...case to create feature for the program.
                    case 1:   // Case 1 is feature Create fruit.
                        sm.createFruit();   // Call method.
                        break;
                    case 2: // Case 2 is feature View order.
                        sm.viewOrders();    // Call method.
                        break;
                    case 3: // Case 3 feature Shopping (for buyer).
                        sm.orderAndPay();   // Call method.
                        break;
                    case 4: // Case 4 feature exit program.
                        System.out.println("Thank's for using software. See you again."); // Notification in this feature.
                        System.exit(0); // This code allow user exit the program.
                }
            } while (Integer.parseInt(choice) != 5); // The loop will be loop when choice difference 5.
        } catch (Exception e) {  // Catch exception if have throw exception.
            System.out.println(e.getMessage()); // Print message if exception is throw.
        }
    }

}

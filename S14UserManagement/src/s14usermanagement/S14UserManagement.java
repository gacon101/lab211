/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagement;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S14UserManagement {

    /**
     * Main driver using class UserManagement().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {   // try...catch to catch exception when program have exception.
            String FILE = "User.txt";   // File for save and load data in this system.
            Scanner sc = new Scanner(System.in);    // Create Scanner for user input from keyboard.
            UserManagement um = new UserManagement(FILE);  // Create object.
            um.loadUserFile();  // Load data file of this system.
            String choice = ""; // This variable will catch input from keyboard of user.
            boolean flag = true;    // Flag will check the loop when user input incorrect.
            do {    // do...while will loop when input of user is incorrect.
                System.out.println();
                System.out.println("   WORKER MANAGEMENT");
                System.out.println("1. Create a new account.");
                System.out.println("2. Login system.");
                System.out.println("3. Exit.");
                do {    // do...while will loop when input of user is incorrect.
                    try {   // try...catch exception when input of user is incorrect.
                        flag = false;   // Flag will be false to pause the loop and allow user input from keyboard.
                        System.out.print("   Please choose: "); // Notification for user know to input from keyboard.
                        choice = sc.nextLine(); // Scanner input user from keyboard.
                        if (choice.isEmpty()) { // If input of user is empty display notification.
                            flag = true;    // Flag will be true to display notification and allow user input again.
                            System.out.println("Don't allow empty input!!!");   // Notification in this situation.
                        }
                        if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 4) {   // If input of user over the range display notification.
                            flag = true;    //Flag will be true to display notification and allow user input again.
                            System.out.println("Please choose follow the menu option!!!");  // Notification in this situation.
                        }
                    } catch (Exception e) { // Catch exception if have throw exception.
                        if (!choice.isEmpty()) {    // If input of user not empty display notification.
                            flag = true;    // Flag will be true to display notification and allow user input again.
                            System.out.println("Don't allow alphabet and charater!!!"); //Notification in this situation.
                        }
                    }
                } while (flag == true); // The loop will be loop when flag is true.
                switch (Integer.parseInt(choice)) { // stwitch...case to create feature for menu.
                    case 1: // Case 1 feature Create a new  Account.
                        String userName = um.inputUserName();   // Call method inputUserName() for user input from keyboard.
                        String password = um.inputPassword();   // Call method inputPassword() for user input from keyboard.
                        um.createAccount(userName, password);   // Call method createAccount to create account.
                        break;
                    case 2: // Case 2 feature Login System.
                        if (um.checkSystem() == true) { // Call method checkSystem() if return of method is true display notification.
                            System.out.println("\nSystem don't have data. Create account to use system!!!");
                        } else {    // If return of method is false allow user login.
                            String userNameLogin = um.inputUserNameLogin(); // Call method ipnutUserNameLogin() for user input login to system.
                            String passwordLogin = um.inputPasswordLogin(); // Call method inputPasswordLogin() for user input login to system.
                            um.loginUserAccount(userNameLogin, passwordLogin);  //Call method loginUserAccount() for user login into system.
                        }
                        break;

                    case 3: // Case 3 feature exit.
                        um.saveUserFile();  // Call method to save data into file data.
                        System.out.println("Thank's for using software. See you again."); // Notification when exit application.
                        System.out.println();
                        System.exit(0); // Call Method system to exit program.
                        break;
                }
            } while (Integer.parseInt(choice) != 4);    // The loop will be loop if choice difference 6.
        } catch (Exception e) { // Catch exception if have throw exception.
            System.out.println(e.getMessage()); // Display exception.
        }
    }
}

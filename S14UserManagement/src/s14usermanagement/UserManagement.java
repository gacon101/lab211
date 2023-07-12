/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class UserManagement {

    private ArrayList<User> listOfUser;
    private final String USER_VALIDATION = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$";
    private final String PASSWORD_VALIDATION = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,18}$";
    private String USER_FILE;
    private int numberOfUser;

    /**
     * Constructor for main driver using. In this constructor have parameter.
     *
     * @param USER_FILE This parameter to get file data from main driver.
     */
    public UserManagement(String USER_FILE) {
        this.numberOfUser = 0;
        this.listOfUser = new ArrayList<>();
        this.USER_FILE = USER_FILE;
    }

    /**
     * Method loadUserFile(). 
     * This method will load data file for system. 
     * This method will read file data and add data from file to listOfUser. 
     * In this method use: 
     * + Method exist(): to check file is exist or not. 
     * + Method createNewFile(): to create file if file not exist in the system. 
     * + Object BufferedReader: will read data in file data. + Method sleep: will delay program.
     * @throws IOException This exception will throw when IO system crash.
     * @throws InterruptedException This exception will throw when system interrupt crash.
     */
    public void loadUserFile() throws IOException, InterruptedException {
        File f = new File(this.USER_FILE);  // Object file will create to scan file data.
        if (!f.exists()) {  // If file is not exist in the system show notifcation and create new file data.
            f.createNewFile();  // Call method from object File to create new file.
            System.out.printf("The data file " + this.USER_FILE + " is not exits. "
                    + "Creating new data file " + this.USER_FILE + "...");  // Notification in this situation.
            Thread.sleep(3000); // Call method to create interrupt.
            System.out.print(" Done!"); // Show this notification in after in terrupt.
        } else {    // If file is exist in the system show notification and read file.
            System.out.printf("The data file " + this.USER_FILE + " is found. "
                    + "Data of user is loading...");    // Notification in this situation.
            int ID; // This variable will catch data after read file.
            String userName;    // This variable will catch data after read file.
            String password;    // This variable will catch data after read file.
            try (BufferedReader br = new BufferedReader(new FileReader(this.USER_FILE))) {  // try...catch BufferedReader to catch exception
                this.numberOfUser = Integer.parseInt(br.readLine()); // Read number of users to create the loop for scan all data in file data.
                for (int i = 0; i < this.numberOfUser; i++) {   // This loop will scan data in file data.
                    ID = Integer.parseInt(br.readLine());   // Read data and give data for variable.
                    userName = br.readLine();   // Read data and give data for variable.
                    password = br.readLine();   // Read data and give data for variable.
                    this.listOfUser.add(new User(ID, userName, password));  // Add data to the listOfUser.
                }
                Thread.sleep(3000); // Create interrupt.
                System.out.print(" Done!"); // Display notification
            } catch (Exception e) { // Catch exception if system throw exception.
                Thread.sleep(3000); // Create interrupt.
                System.out.print(" Done!"); // Display notification.
                System.out.print("\nFile " + this.USER_FILE + " is empty data choose option 1 to create account."); // Display notification.
            }
        }
    }

    /**
     * Method saveUserFile(). 
     * This method will save data in to file data of system. 
     * This method will scan the listOfUser and write data in to file data of system. 
     * In this method use: 
     * + Object FileWriter: to scan file data and write data. 
     * + Method append(): will write data into file data. 
     * + Method sleep: will delay program. 
     * + Method close(): will stop write file data.
     * @throws IOException This exception will throw when IO system crash.
     * @throws InterruptedException This exception will throw when system interrupt crash.
     */
    public void saveUserFile() throws IOException, InterruptedException {
        FileWriter fw = new FileWriter(USER_FILE);  // Create FileWriter to write data into file data.
        try {   // try...catch to catch exception system.
            System.out.print("Account is saving into data file " + this.USER_FILE + "... ");    // Display notification.
            fw.append(String.valueOf(this.numberOfUser) + "\n");    // Write number of user into file data.
            for (int i = 0; i < this.numberOfUser; i++) {   // The loop will scan number of user before write data.
                User u = this.listOfUser.get(i);    //  Create object to get each data in listOfUser.
                int ID = u.getID(); // Get data.
                String userName = u.getUserName();  // Get data.
                String password = u.getPassword();  // Get data .

                fw.append(String.valueOf(ID) + "\n");   // Write data into the file data after get data.
                fw.append(userName + "\n"); // Write data into the file data after get data.
                fw.append(password + "\n"); // Write data into the file data after get data.
            }
        } finally {
            fw.close(); // Stop write data.
            if (this.numberOfUser != 1) {    // If number of user greater than 1 display notification.
                Thread.sleep(3000); // Create interrupt.
                System.out.println("Done! [" + this.numberOfUser + " accounts]");   // Notification in this situation.
            } else {    // If number of user less than 1 display notification.
                Thread.sleep(3000); //Create interrupt.
                System.out.println("Done! [" + this.numberOfUser + " account]");    // Notification in this situation.
            }
        }
    }

    /**
     * Method createAcconut(). 
     * This method will create new account. 
     * This method use integer type to return result. 
     * In this method use: 
     * + Method add: will add new object in the listOfUser.
     * @param userName This parameter will catch input value from user.
     * @param password This parameter will catch input value from user.
     * @return numberOfuser to count how many user.
     */
    public int createAccount(String userName, String password) {
        this.listOfUser.add(new User(++this.numberOfUser, userName, password)); // Add new object in to listOfuser.
        System.out.println("Create accont successfully");   // Display notification.
        return this.numberOfUser;   // Return numberOfUser to count.
    }

    /**
     * Method loginUserAccount(). 
     * This method will allow user login into system.
     * In this method use:
     * + Method findUSerAccont(): to find account in system.
     * @param userName This parameter will be catch input from user.
     * @param password  This parameter will be catch input from user.
     */
    public void loginUserAccount(String userName, String password) {
        int i = findUserAccount(userName, password);    // Call method to find account.
        if (i != -1) {  // If account is exist display information of account.
            User u = this.listOfUser.get(i);    // Create object to get each value.
            System.out.println("\nLogin successfully"); // Display notification when login success.
            System.out.println("Hello User: " + u.getUserName());   // Display notification.
            System.out.println("---- User information ----");   // Display notifiaction.
            System.out.println("+---+----------------------+----------------------+");  // Display header table.
            System.out.println("|ID |Username              |Password              |");  // Display name of collum.
            System.out.println("+---+----------------------+----------------------|");  // Display header table.
            System.out.printf("|%-3d|%-22s|%-22s|\n", u.getID(), u.getUserName(), u.getPassword());   // Display user information.
            System.out.println("+---+----------------------+----------------------|");  // Display footer table.
        } else {    // If account is not exist display notification.
            System.out.println("\nlogin fail"); // Notification in this situation.
        }
    }

    /**
     * Method findUserAccount().
     * This method will be find user account.
     * This method use:
     * + method equal: to compare input user.
     * @param userName This method will be catch input of user.
     * @param password  This method will be catch input of user.
     * @return  i index of user account when account is exist, -1 when account is not exist.
     */
    public int findUserAccount(String userName, String password) {
        for (int i = 0; i < this.listOfUser.size(); i++) {  // The for loop will scan the listOfUser to find account of user.
            User u = this.listOfUser.get(i);    // Create object to get each value.
            if (userName.equals(u.getUserName()) && password.equals(u.getPassword())) { // If input of user is matches return index.
                return i;   // Return index.
            }
        }
        return -1;  // Return -1 when account is not exist.
    }

    /**
     * Method checSystem().
     * This method will check system when system have no data.
     * @return true when system have no data, false when system have data.
     */
    public boolean checkSystem() {
        if (this.listOfUser.isEmpty() || this.numberOfUser == 0) {  // If listOfUser is empty or numberOFuser equal 0 return true.
            return true;    // Retrun true in this situation.
        }
        return false;   // Return false when system have data.
    }

    /**
     * Method checkUserName().
     * This method will check userName from input user and userName in listOfUser.
     * This method using boolean type to return the result.
     * In this method use:
     * + Method equal(): to compare input user.
     * @param userName This parameter will catch input of user.
     * @return true when input of user is exist, false when input of user is not exist.
     */
    public boolean checkUserName(String userName) {
        for (int i = 0; i < this.listOfUser.size(); i++) {  // The for loop will be scan listOfuser.
            User u = this.listOfUser.get(i);    // Create object to get each value.
            if (userName.equals(u.getUserName())) { // If input of user equal value in listOfUser return true.
                return true;    // Return in true this situation.
            }
        }
        return false;   // Return false when input of user is not equal.
    }

    /**
     * Method checkPassword().
     * This method will check password from input user and password in listOfUser.
     * This method using boolean type to return the result.
     * In this method use:
     * + Method equal(): to compare input user.
     * @param password This parameter will catch input of user.
     * @return true when password of user is correct, false when password incorrect.
     */
    public boolean checkPassword(String password) {
        for (int i = 0; i < this.listOfUser.size(); i++) {  // The loop will be scan listOfUser.
            User u = this.listOfUser.get(i);    // Create object to get each value.
            if (password.equals(u.getPassword())) { // If password of user equal value in listOfUser return true.
                return true;    // Return true in this situation
            }
        }
        return false;   // Retuen false when input of user is not equal.
    }

    /**
     * Method inputUSerNameLogin().
     * This method will allow user input from keyboard.
     * This method use String type to return result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + Method checkUserName(): to check userName is exist or not.
     * @return userName The input value of user from keyboard.
     */
    public String inputUserNameLogin() {
        Scanner sc = new Scanner(System.in);    // Scanner for allow user input value from keyboard.
        String userName = "";   // This variable will catch the input of user from keyboard.
        boolean flag = true;    // Flag will be check the loop when input of user from key is incorrect.
        do {    // do...while the loop will be loop when user input incorrect.
            try {   // try...catch to catch exception when user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Username: ");   //Notification for user know to input from keyboard.
                userName = sc.nextLine().trim();   // Scannner input user from keyboard.
                if (userName.isEmpty()) {   // If input of user is empty display notification.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    System.out.println("Username can't be empty!!!");   // Notification in this situation.
                }
                if (checkUserName(userName) == false) { // If method checkUserName() equal false display ntification.
                    flag = true;    // Flag will be true to display notification in this situation.
                    System.out.println("Username is not exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Your input is incorrect!!!");   //Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return userName;    // Return input of user from keyboard.
    }

    /**
     * Method inputPasswordLogin().
     * This method will get input of user from keyboard.
     * This method use String type to return result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + Method checkUserName(): to check userName is exist or not.
     * @return password The input value of user from keyboard.
     */
    public String inputPasswordLogin() {
        Scanner sc = new Scanner(System.in);    // Scanner for allow user input value from keyboard.
        String password = "";    // This variable will catch the input of user from keyboard.   
        boolean flag = true;    // Flag will be check the loop when input of user from key is incorrect.
        do {    // do...while the loop will be loop when user input incorrect.
            try {   // try...catch to catch exception when user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Password: ");   //Notification for user know to input from keyboard.
                password = sc.nextLine().trim();   // Scannner input user from keyboard.
                if (password.isEmpty()) {   // If input of user is empty display notification.
                    flag = true;     // Flag willbe true to display notification and allow user input again.
                    System.out.println("Password can't be empty!!!");    // Notification in this situation.
                }
                if (checkPassword(password) == false) { // If method checkPassword() equal false display ntification.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    System.out.println("Password is incorrect!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag willbe true to display notification and allow user input again.
                System.out.println("Your input is incorrect!!!");   // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return password;    // Return input of user from keyboard.
    }

    /**
     * Method inputUserName().
     * This method will get input of user from keyboard.
     * This method use String type to return result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + Method checkUserName(): to check userName is exist or not.
     * + ReGex USER_VALIDATION: to check userName format.
     * @return input The input value of user from keyboard.
     */
    public String inputUserName() {
        Scanner sc = new Scanner(System.in);    // Scanner for allow user input value from keyboard.
        String input = "";  // This variable will catch the input of user from keyboard.   
        boolean flag = true;    // Flag will be check the loop when input of user from key is incorrect.
        do {    // do...while the loop will be loop when user input incorrect.
            try {   // try...catch to catch exception when user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Username: ");   //Notification for user know to input from keyboard.
                input = sc.nextLine().trim();   // Scannner input user from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    input = "Empty input";  // Notification in this situation.
                }
                if (!input.matches(USER_VALIDATION)) {  // If the input not matches to ReGex displaynotificaton.
                    flag = true;    // Flag willbe true to display notification and allow user input again.  
                    System.out.println("Your Username: " + input + " is incorrect format. For example Username:\n"
                            + "\t0123456789\n"
                            + "\ttrongnguyen\n"
                            + "\tTRONGNGUYEN\n"
                            + "\tTrongNDP123\n");   // Notification in this situation.
                }
                if (checkUserName(input) == true) { // If method checkPassword() equal true display ntification.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    System.out.println("Username is exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag willbe true to display notification and allow user input again.
                System.out.println("Don't accept input incorrect!!!");  // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return input;   // Return input of user from keyboard.
    }

    /**
     * Method inputPassword().
     * This method will get input of user from keyboard.
     * This method use String type to return result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + Method checkUserName(): to check userName is exist or not.
     * + ReGex PASSWORD_VALIDATION: to check password format.
     * @return input The input value of user from keyboard.
     */
    public String inputPassword() {
        Scanner sc = new Scanner(System.in);    // Scanner for allow user input value from keyboard.
        String input = "";  // This variable will catch the input of user from keyboard.
        boolean flag = true;    // Flag will be check the loop when input of user from key is incorrect.
        do {    // do...while the loop will be loop when user input incorrect.
            try {   // try...catch to catch exception when user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Password: ");   //Notification for user know to input from keyboard.
                input = sc.nextLine();  // Scannner input user from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    input = "Emty input";   // Notification in this situation.
                }
                if (!input.matches(PASSWORD_VALIDATION)) {  // If the input not matches to ReGex displaynotificaton.
                    flag = true;    // Flag willbe true to display notification and allow user input again.
                    System.out.println("Your Password: " + input + " is incorrect format. Password must be:\n"
                            + "\tMinimum eight characters\n"
                            + "\tAt least one letter, one number\n"
                            + "\tAnd one special character\n"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag willbe true to display notification and allow user input again.
                System.out.println("Don't accept input incorrect!!!");  // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return input;   // Return input of user from keyboard.
    }
}

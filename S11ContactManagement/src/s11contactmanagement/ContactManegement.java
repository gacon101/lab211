/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11contactmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class management class attribute.
 * @author trong
 */
public class ContactManegement {

    private ArrayList<Contact> list;
    private final String PHONE_VALIDATION = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    private final String VALIDATION = "^[A-Za-z\\s]{0,15}$";

    /**
     * Constructor to make new array list for main diver.
     */
    public ContactManegement() {
        this.list = new ArrayList<>();
    }

    /**
     *  Method addContact to add new contact in arrayList.
     *  This method will be add new contact when this method be call.
     * @param id parameter to get value to add new contact.
     * @param fullName parameter to get value to add new contact.
     * @param group parameter to get value to add new contact.
     * @param address parameter to get value to add new contact.
     * @param phone parameter to get value to add new contact.
     * @param lastName parameter to get value to add new contact.
     * @param firstName parameter to get value to add new contact.
     */
    public void addContact(int id, String fullName, String group, String address, String phone, String lastName, String firstName) {
        this.list.add(new Contact(id, fullName, group, address, phone, lastName, firstName)); // Use Collection add to add new contact to arrayList.
        System.out.println("Add successfully"); // Display notification when add success. 
    }

    /**
     * Method displayAllContacts to display all contact in the arrayList.
     * This method will be loop to scan all arrayList and then display each element in the arrayList.
     */
    public void displayAllContacts() {
        System.out.println("+---+----------------------+---------------+---------------+-----------+-------------+------------+");  // Show table.
        System.out.println("| ID|Name                  |First Name     |Last Name      |Group      |Address      |Phone       |");  // Show name of collums.
        System.out.println("+---+----------------------+---------------+---------------+-----------+-------------+------------+");  // Show table
        for (int i = 0; i < this.list.size(); i++) {  // The for loop to scan all elements in arrayList 
            Contact a = this.list.get(i);             // Create object a to get each elements in the arrayList.
            // Display all element in the arrayList and get value from each attribute.
            System.out.printf("|%3d|%-22s|%-15s|%-15s|%-11s|%-13s|%-12s|\n", a.getId(), a.getFullName(), a.getFirtName(), a.getLastName(), a.getGroup(), a.getAddress(), a.getPhone()); 
        }
        // The end of the table.
        System.out.println("+---+----------------------+---------------+---------------+-----------+-------------+------------+");
    }

    /**
     * Method findContactID().
     * This method will find ID of object in the arrayList.
     * @param ID this parameter is a ID to find.
     * @return index i if ID is exist, -1 if ID is not exist.
     */
    public int findContactID(int ID) {
        for (int i = 0; i < this.list.size(); i++) {  // The for loop will scan all object in arrayList.
            Contact a = this.list.get(i);           // Create object Contact a to get index in arrayList.
            if (a.getId() == ID) {          // If ID is exist return index i.
                return i;                   // return index i    
            }
        }
        return - 1;                 // Return -1 when ID is not exist.
    }
    
    /**
     * Method checkListIsEmpty().
     * This method will be check list empty or not 
     * if list is empty return true, return false if list is not empty.
     * @return true when list empty, false when list not empty.
     */
    public boolean checkListIsEmpty() {
        if (this.list.isEmpty()) {  // If list is empty return true.
            return true;    // return true when list empty.
        }
        return false; // return false when list not  empty.
    }
    
    /**
     *  Method checkNameIsExist().
     *  This method will check Name in the arrayList is exist or not.
     *  This method will be return follow data type boolean.
     * @param fullName get fullName from input of user to check fullName is exist or not.
     * @return true if fullName is exist in arrayList, false if fullName is not exist in arrayList
     */
    public boolean checkNameIsExist(String fullName){
        for (int i = 0; i < this.list.size(); i++) {  // The for loop will scan all object in the arrayList.
            Contact c = this.list.get(i);           // Create object c to get index of object in the arrayList.
            if (c.getFullName().equals(fullName)) { // If fullName is exist in the arrayList.
                return true;                        // Return true when fullName is exist.
            }
        }
        return false;           // Retrurn false when fullName is not exist.
    }

    /**
     * Method checkPhoneIsExist().
     * This method will check phone number in the arrayList.
     * This method will be return true if phone number is exist in the arrayList.
     * return false if phone number is not exist in the arrayList.
     * @param phone to get input of user to check phone is exist or not.
     * @return true when phone number is exist, false when phone number is not exist.
     */
    public boolean checkPhoneIsExist(String phone){
        for (int i = 0; i < this.list.size(); i++) {  // The for loop to scan all object in the arrayList.
            Contact c = this.list.get(i);           // Create object c to get index object in the arrayList.
            if (c.getPhone().equals(phone)) {       // If phone number is exist return boolean data type.
                return true;                     // Return true when phone number is exist.   
            }
        }
        return false;                       // Return false when phone number is not exist.
    }
    
    /**
     * Method deleteContact().
     * This method will delete contact in the arrayList by Id.
     * If ID is exist the contact will be delete from arrayList.
     * If ID is not exist the notification will display on console. 
     * @param removeID this parameter need to find the ID in the arrayList.
     */
    public void deleteContact(int removeID) {
        int i = findContactID(removeID);  // Method findContactID will be find ID of user input and check that ID exist or not. 
        if (i != -1) {  // If ID is exist contact with that ID will be delete from arrayList.
            {
                this.list.remove(findContactID(removeID));  // Method remove() will be delete the contact by ID.
                System.out.println("Delete successfully"); // Display notification when delete success.
            }
        } else {        // If ID is not exist in the arrayList the notification will be display console.
            System.out.println("The id can't not found!"); // Notification in this situation.
        }
    }

    /**
     * Method autoID().
     * This method will be automatic generate ID.
     * The for loop to find last index in the arrayList.
     * @return newID is the ID after automatic generate 
     */
    public int autoID() {
        int newID = 1;   // Variable newID is set for first time. 
        for (int i = 0; i < this.list.size(); i++) { // The for loop will scan all object in the arrayList.
            int lastIndex = this.list.size() - 1;    // Variable lastIndex will get last index of the arrayList.
            int lastID = this.list.get(lastIndex).getId();  // Variable lastID will be get last index in the arrayList and set that +1.
            newID = lastID + 1;     // Variable newID will be update lastID + 1.
        }
        return newID; // Return newID to automatic generate ID. 
    }

    /**
     * Method getFirstName().
     * This method will split full name and get first name.
     * @param fullName this parameter to get full name. 
     * @return firstName if split success, fullName if split not success.
     */
    public String getFirtName(String fullName) {
        int index = fullName.lastIndexOf(" "); // Variable index to get fullName index 
        if (index > -1) {  // If index > -1 fullName will be substring 
            return fullName.substring(0, index); // return firstName.
        }
        return fullName;  // return fullName if full name is not contain lastName.
    }

    /**
     * Method getLastName().
     * This method will split full name and get first name.
     * @param fullName this parameter tho get full name.
     * @return lastName if split success, fullName if split not success.
     */
    public String getLastName(String fullName) {
        int index = fullName.lastIndexOf(" ");
        if (index > -1) {
            return fullName.substring(index + 1, fullName.length());
        }
        return "";
    }

    /**
     * Method inputID().
     * This method allow user input the ID of object in arrayList.
     * In this method have check some exception like: input is empty, whitespace, ID must be greater than zero,...
     * If user input ID incorrect this method allow enter again.
     * @return ID Integer.parseInt() to convert String to integer.
     */
    public int inputID() {
        Scanner sc = new Scanner(System.in);  // Create Scanner to allow user input from keyboard.
        String ID = "";                     // This variable to catch the input of user.
        boolean flag = true;                // Flag to check input is correct or not.
        do {                // do... while to loop if user input incorrect
            try {      // try.. catch to catch exception if user input incorrect.
                flag = false;           // Flag equal false to pause the loop for user input the ID.
                System.out.print("Enter ID: ");  // Notification for user know to input ID.
                ID = sc.nextLine().trim();      // Scanner input from keyboard of user.
                if (ID.isEmpty()) {         // If input is empty show notification.
                    flag = true;            // in this situation flag will be true show notification and allow user input again.
                    System.out.println("Don't allow input empty!!!"); // Notification in this situation.
                }
                if (Integer.parseInt(ID) <= 0) {  // If input ID less than zero show notification.
                    flag = true;                // Flag will be equal true for show the notification and allow user input again.
                    System.out.println("ID must be positive integer!!!");   // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true; // Flag will be true to allow user input again and show notification.
                System.out.println("ID is digit!!!"); // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when the flag is true.
        return Integer.parseInt(ID);  // Return ID and convert ID from String to integer to add information to the object.
    }

    /**
     * Method inputFullName().
     * This method allow user input the full name of object in arrayList.
     * In this method have check some exception like: full name is empty, format of full name, full name is exist in arrayList...
     * If user input full name incorrect this method allow enter again.
     * @return fullName to add object.
     */
    public String inputFullName() {
        Scanner sc = new Scanner(System.in);   // Create Scanner to allow user input from keyboard.
        String input = "";        // This variable to catch input from user.
        boolean flag = false;     // Flag to check input is correct or not.
        do {               // do...while to loop if user input incorrect.
            try {           // try..catch to catch exception if user input incorrect.
                flag = false; // Flag will be equal false to pause the loop and allow user input from keyboard.
                System.out.print("Enter Name: ");  // Notification for user know to input full name.
                input = sc.nextLine().trim();   // Scanner input from keyboard of user.
                if (input.isEmpty()) {       // If input of user is empty show the notification.
                    flag = true;          // Flag will be equal true to show the notification and allow user input again.
                    System.out.println("This input can't be empty!!!"); // This notification in this situation.
                }
                if (!input.matches(VALIDATION)) {  // If input of user not matches the regex format show notification.
                    flag = true;        // Flag will be true to show the notification and allow user input again.
                    System.out.println("Your input too long or wrong format!!!"); // Notification this situation.
                }
                if (checkNameIsExist(input) == true) {  // If input of user is exist show the notification.
                    flag = true;        // Flag will be true to show the notification and allow user input again.
                    System.out.println("Full name is exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if throw exception.
                flag = true; // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!"); // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag equal true;
        return input;  // Return input to add information to object.
    }

    /**
     * Method inputGroup().
     * This method allow user input the group of object in arrayList.
     * In this method have check some exception like: group is empty, format of group,...
     * If user input group incorrect this method allow enter again.
     * @return group to add object.
     */ 
    public String inputGroup() {
        Scanner sc = new Scanner(System.in); // Create Scanner to allow user input from keyboard.
        String input = "";    // This variable to catch the input from user.
        boolean flag = false;  // Flag will be check input from user correct or not.
        do {      // do...while to loop if user input incorrect.
            try { // try...catch to catch exception if user input incorrect.
                flag = false;  // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Group: "); // Notification for user know to input from keyboard.
                input = sc.nextLine().trim();  // Scanner input from keyboard of user.
                if (input.isEmpty()) {  // If input is empty show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("This input can't be empty!!!"); // Notification in this situation.
                }
                if (!input.matches(VALIDATION)) {  // If input of user not matches the regex format show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Your input too long or wrong format!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!");  // Notification in this situation.
            }
        } while (flag == true);   // The loop will be loop when flag equal true.
        return input;  // Return input to add information to object.
    }

    /**
     * Method inputAddress().
     * This method allow user input the address of object in arrayList.
     * In this method have check some exception like: address is empty, address is not matches format,...
     * If user input address incorrect this method allow enter again.
     * @return address to add information to object.
     */
    public String inputAddress() {
        Scanner sc = new Scanner(System.in);  // Create Scanner to allow user input from keyboard.
        String input = "";       // This variable to catch input from user.
        boolean flag = false;  // Flag will be check input from user correct or not.
        do {    // do...while to loop if user input incorrect.
            try {  //try...catch to catch exception if user input incorrect.
                flag = false;  // Flag will be false to pause the loop for the user input from keyboard.
                System.out.print("Enter Address: ");  // Notificaton for user know to input from keyboard.
                input = sc.nextLine().trim();   // Scanner input from keyboard of user.
                if (input.isEmpty()) {   // If ipnut is empty show the notification.
                    flag = true;   // Flag will be true to show notification and allow user input again.
                    System.out.println("This input can't be empty!!!"); // Notification in this situation.
                }
                if (!input.matches(VALIDATION)) {  // If input not matches regex format show notification
                    flag = true;    // Flag will be true to show the notification and allow user input again.
                    System.out.println("Your input too long or wrong format!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!"); // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is equal true.
        return input;  // Return input to add information to the object.
    }

    /**
     * Method inputPhone().
     * This method allow user input the phone of object in arrayList.
     * In this method have check some exception like: phone is empty, phone is not matches format,...
     * If user input phone incorrect this method allow enter again.
     * @return phone to add to the object.
     */
    public String inputPhone() {
        Scanner sc = new Scanner(System.in);  // Create the Scanner to allow use input from keyboard.
        String input = "";      // This variable to catch input from user keyboard.
        boolean flag = true;  // Flag will be check input of user is correct or not.
        do {      // do...while to loop if input is incorrect.
            try {  //try...catch exception if user is incorrect.
                flag = false;  // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Phone: "); // Notification for user know to input from keyboard.
                input = sc.nextLine().trim();   // Scanner input from keyboard of user.
                if (input.isEmpty() || !input.matches(PHONE_VALIDATION)) { // If input is empty or input not matches the regex format show notification.
                    flag = true;   // Flag will be true to show notification and allow user input again.
                    System.out.println("Please input Phone flow\n"   // Notification in this situation.
                            + "• 1234567890\n"
                            + "• 123-456-7890 \n"
                            + "• 123-456-7890 x1234\n"
                            + "• 123-456-7890 ext1234\n"
                            + "• (123)-456-7890\n"
                            + "• 123.456.7890\n"
                            + "• 123 456 7890");
                }
                if (checkPhoneIsExist(input)) {    // If phone is exist show the notification.
                    flag = true;        // Flag will be true to show notification and allow user input again.
                    System.out.println("Phone is exsit!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!"); //Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is equal true.
        return input;  // Return input to add information to the object.
    }
}

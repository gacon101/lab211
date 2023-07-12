/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11contactmanagement;

import java.util.Scanner;

/**
 * @author trong
 */
public class S11ContactManagement {

    /**
     * Main driver using for class ContactManagement().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContactManegement cm = new ContactManegement();  // Create object.
        try {  // try...catch exception of user input.
            Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
            String choice = "";                   // This variable catch input from keyboard of user.
            boolean flag = true;                // Flag can to check input of user correct or not
            do {        // do...while the loop will check start when input incorrect.
                System.out.println("========= Contact program =========");
                System.out.println("1.Add a contact");
                System.out.println("2.Display all contact");
                System.out.println("3.Delete a contact");
                System.out.println("4.Exit");
                do { // The loop check input choice of user.
                    try { // try...catch to catch exception.
                        flag = false;  // Flag is false to pause the loop for user input from keyboard.
                        System.out.print("Please enter: ");  // Notificaton for user know to input.
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
                    case 1:   // Case 1 is feature add a Contact this feature allow user add object.
                        System.out.println("####### Add a Contact #######");  // Notification in this situation.
                        int id = cm.autoID(); // Call method auto Id to generate automatic ID.
                        String fullName = cm.inputFullName();  // Call method inputFullName().
                        String lastName = cm.getLastName(fullName); // Call method getLastName().
                        String firstName = cm.getFirtName(fullName); // Call method getFirstName().
                        String group = cm.inputGroup();     // Call method inputGroup().
                        String address = cm.inputAddress(); // Call method inputAddress().
                        String phone = cm.inputPhone();     // Call method inputPhone().
                        cm.addContact(id, fullName, group, address, phone, lastName, firstName); // Call method add to add new object.
                        break;
                    case 2: // Case 2 is feature Display all Contact
                        System.out.println("###################################### Display all Contact ######################################");
                        if (cm.checkListIsEmpty() == true) { // Call method cehckListIsEmpty() to check list is empty or not.
                            System.out.println("No Data Please Choose Option 1 To Add Data"); // Notification in this situation.
                        } else {
                            cm.displayAllContacts();   // Call method displayAllContacts().
                        }
                        break;
                    case 3: // Case 3 feature Delete a Contact.
                        System.out.println("###### Delete a Contact ######");
                        if (cm.checkListIsEmpty() == true) { // Call method checkListIsEmpty() to check list is empty or not.
                            System.out.println("No Data Please Choose Option 1 To Add Data"); // Notification in this situation.
                        } else {
                            cm.displayAllContacts();  // Call method displayAllContacts()
                            int ID = cm.inputID();  // Call method inputID() to find ID.
                            cm.deleteContact(ID);  // Call method deleteContact() to delete contact by ID.
                        }
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

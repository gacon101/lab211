/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12doctormanagement;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S12DoctorManagement {

    /**
     * Main driver for using class DoctorManagement().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoctorManagement dm = new DoctorManagement();  // Create object.
        try {  // try...catch to catch exception input from user incorrect
            Scanner sc = new Scanner(System.in); // Create Scanner for user input from keyboard.
            String choice = "";  // This variable to catch input user from keyboard.
            boolean flag = true;  // Flag will check input from keyboard of user.
            do { // do...while will loop when user input incorrect.
                System.out.println("   DOCTOR MANAGEMENT");
                System.out.println("1. Add Doctor.");
                System.out.println("2. Update Doctor.");
                System.out.println("3. Delete Doctor.");
                System.out.println("4. Search Doctor.");
                System.out.println("5. Exit.");
                do {    // do...while to loop when user input choice incorrect.
                    try { // try...catch to catch exception when user input choice incorrect.
                        flag = false;  // Flag will be true to pause the loop for user input from keyboard.
                        System.out.print("   Please choose: ");  // Notification for user know to input from keyboard.
                        choice = sc.nextLine();   // Scanner to allow user input from keyboard.
                        if (choice.isEmpty()) {  // If input of user is empty show notification.
                            flag = true;   // Flag is true to show notification and allow user input agian.
                            System.out.println("Don't allow empty input!!!"); // Notification in this situation.
                        }
                        if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 6) { // If user input over the range show notification.
                            flag = true; //Flag will be true to show notification and allow user input agian.
                            System.out.println("Please choose follow the menu option!!!"); // Notification in this situation.
                        }
                    } catch (Exception e) { // Catch exception if have throw exception.
                        if (!choice.isEmpty()) { // If input from user is not empty show notification.
                            flag = true;  // Flag will be true to show notification and allow user input again.
                            System.out.println("Don't allow alphabet and charater!!!"); // Notification in this situation.
                        }
                    }
                } while (flag == true); // The loop will be loop when flag is true.
                switch (Integer.parseInt(choice)) { // Switch...case to create feature.
                    case 1: // Case 1 feature add doctor.
                        System.out.println("--------- Add Doctor ---------"); //Notification in this feature.
                        String code = dm.inputCode(); // Call method inputCode().
                        String name = dm.inputName(); // Call method inputName().
                        String specialization = dm.inputSpecialization(); // Call method inputSpecialization().
                        int availability = dm.inputAvailability();  // Call method inputAvailability().
                        dm.addDoctor(code, name, specialization, availability); // Call method addDoctor() to add new doctor in the List.
                        dm.displayAllDoctors(); // Display doctor after add.
                        break;
                    case 2: // Case 2 feature Update doctor.
                        if (dm.checkListIsEmpty() == true) { // If List is empty show notification.
                            System.out.println("No data please choose option 1 to add data!!!"); // Notification in this situation.
                        } else {  // If List is not empty allow user update doctor.
                            dm.displayAllDoctors(); // Show list doctor for user choose doctor to update.
                            String upateCode = dm.inputFindCode(); // Call method inputFindCode() for user input Code of doctor want to update.
                            dm.updateDoctorByCode(upateCode);  // Call method updateDoctorByCode() to update information of doctor.
                            dm.displayAllDoctors(); // Display doctor after update.
                        }
                        break;
                    case 3:  // Case 3 feature Delete doctor
                        if (dm.checkListIsEmpty() == true) { // If List is empty show notification.
                            System.out.println("No data please choose option 1 to add data!!!"); // Notification in this situation.
                        } else {  // If List is not empty allow user delete doctor.
                            dm.displayAllDoctors(); // Show list doctor for user choose doctor to delete.
                            String removeCode = dm.inputFindCode(); // Call method inputFindCode() to find code of doctor.
                            dm.deleteDoctorByCode(removeCode);   // Call method deleteDoctorByCode() to delete doctor by code.
                            dm.displayAllDoctors(); // Display doctor after delete.
                        }
                        break;
                    case 4: // Case 4 feature Search doctor.
                        if (dm.checkListIsEmpty() == true) {  // If the List is empty show notification.
                            System.out.println("No data please choose option 1 to add data!!!"); // Notification in this situation.
                        } else {  // If the List is not empty allow user search doctor by code.
                            String findCode = dm.inputFindCode(); // Call method inputFindCode() to find the code of doctor.
                            dm.displayDoctorByCode(findCode);  // Call method displayDoctorByCode() to show doctor follow the Code.
                        }
                        break;
                    case 5: // Case 5 featrue Exit.
                        System.out.println("Thank's for using software. See you again."); // Notification before exit program.
                        System.exit(0); // Method exit() allow user exit.
                }
            } while (Integer.parseInt(choice) != 6); // The loop will be loop when choice diference 6.
        } catch (Exception e) { // Catch exception if have throw exception.
            System.out.println(e.getMessage()); // Show message of exception.
        }
    }
}

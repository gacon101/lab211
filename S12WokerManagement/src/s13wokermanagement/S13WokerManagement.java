/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s13wokermanagement;

import java.util.Scanner;

/**
 *
 * @author trong
 */
public class S13WokerManagement {

    /**
     * Main driver using class WorkerManagement().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WorkerManagement wm = new WorkerManagement();   // Create object.
        try {   // try...catch to catch exception when program have exception.
            Scanner sc = new Scanner(System.in);    // Create Scanner for user input from keyboard.
            String choice = ""; // This variable will catch input from keyboard of user.
            boolean flag = true;    // Flag will check the loop when user input incorrect.
            do {    // do...while will loop when input of user is incorrect.
                System.out.println("   WORKER MANAGEMENT");
                System.out.println("1. Add Worker.");
                System.out.println("2. Up Salary.");
                System.out.println("3. Down Salary.");
                System.out.println("4. Display Information salary.");
                System.out.println("5. Exit.");
                do {    // do...while will loop when input of user is incorrect.
                    try {   // try...catch exception when input of user is incorrect.
                        flag = false;   // Flag will be false to pause the loop and allow user input from keyboard.
                        System.out.print("   Please choose: "); // Notification for user know to input from keyboard.
                        choice = sc.nextLine(); // Scanner input user from keyboard.
                        if (choice.isEmpty()) { // If input of user is empty display notification.
                            flag = true;    // Flag will be true to display notification and allow user input again.
                            System.out.println("Don't allow empty input!!!");   // Notification in this situation.
                        }
                        if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 6) {   // If input of user over the range display notification.
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
                    case 1: // Case 1 feature Add Worker.
                        System.out.println();
                        System.out.println("--------- Add Worker ---------");
                        String Id = wm.inputID();   // Call method inputID() to input ID of worker.
                        String name = wm.inputName();   // Call method inputName() to input name of worker.
                        int age = wm.inputAge();    // Call method inputAge() to input age of worker.
                        int salary = wm.inputSalary();  // Call method inputSalary() to input salary of worker.
                        String workLocation = wm.inputWorkLocation();   // Call method inputWorkLocation() to input work location of worker.
                        wm.addWorker(Id, name, age, salary, workLocation);  // Call method add to add new worker.
                        System.out.println();
                        wm.displayAllWorkers(); // Display worker after add.
                        System.out.println();
                        break;
                    case 2: // Case 2 feature update salary up.
                        System.out.println();
                        System.out.println("-------- Up Salary --------");
                        if (wm.checkListIsEmpty() == true) { // Call method checkListEmpty to check list is empty or not.
                            System.out.println("No data please choose option 1 to add data!!!");    // Notifiaction in this situation.
                        } else {    // If list is not empty allow user update salary.
                            wm.displayAllWorkers(); // Display all worker in the list.
                            System.out.println();
                            System.out.println("Update Salary");
                            String updateId = wm.inputUpdateID();   // Call method inputUpdateID() to input Id of worker.
                            int updateSalary = wm.inputSalary();    // Call method inputSalary() to input salary of worker.
                            wm.updateStatusSalaryUp(updateId, updateSalary);    // Call method updateStatusSalary() to find ID and update salary.
                        }
                        System.out.println();
                        break;
                    case 3: // Case 3 feature update salary down.
                        System.out.println();
                        System.out.println("-------- Down Salary --------");
                        if (wm.checkListIsEmpty() == true) {    // Call method checkListIsEmpty to check list is empty or not.
                            System.out.println("No data please choose option 1 to add data!!!");    // Notification in this situation.
                        } else {    // If list is not empty allow user update salary.
                            wm.displayAllWorkers(); // Display all worker in the list.
                            System.out.println();
                            System.out.println("Update Salary");
                            String upId = wm.inputUpdateID();   // Call method inputUpdateID() to input Id of worker.
                            int upSalary = wm.inputSalary();    // Call method inputSalary() to input salary of worker.
                            wm.updateStatusSalaryDown(upId, upSalary); // Call method updateStatusSalary() to find ID and update salary.
                        }
                        System.out.println();
                        break;
                    case 4: // Case 4 feature display information salary.
                        System.out.println();
                        System.out.println("-------------------- Display Information Salary --------------------");
                        if (wm.checkListWorkerIsEmpty() == true) {   // Call method checkListIsEmpty to check list is empty or not.
                            System.out.println("No data please choose option 1 to add data!!!");
                        } else {    // If list history is not empty display all history on console.
                            wm.sortByID();  // Call Method sortByID to sort the list before display on console.
                            wm.displaySalaryInformation();  // Call method displaySalaryInformation() to display history on console.
                            System.out.println();
                        }
                        break;
                    case 5: // Case 5 feature exit.
                        System.out.println();
                        System.out.println("Thank's for using software. See you again."); // Notification when exit application.
                        System.out.println();
                        System.exit(0); // Call method exit() to exit application.
                }
            } while (Integer.parseInt(choice) != 6);    // The loop will be loop if choice difference 6.
        } catch (Exception e) { // Catch exception if have throw exception.
            System.out.println(e.getMessage()); // Display exception.
        }
    }

}

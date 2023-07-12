/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12doctormanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class DoctorManagement {

    private ArrayList<Doctor> list;
    private final String VALIDATION = "^$";
    private final String CODE_VALIDATION = "^[DOC]{3}[\\s]{1}(?!(0))[\\d]{1,2}$";
    private final String NAME_VALIDATION = "^[A-Za-z\\s]{0,15}$";
    private final String SPECIALIZATION_VALIDATION = "[A-Za-z\\s]{0,20}$";

    /**
     * Constructor for main driver using.
     */
    public DoctorManagement() {
        this.list = new ArrayList<>(); // Create list for main driver.
    }

    /**
     * Method addDoctor().
     * This method allow user add new doctor into the arrayList.
     * In this method have parameter.
     * @param code this parameter get value from keyboard of user.
     * @param name this parameter get value from keyboard of user.
     * @param specialization this parameter get value from keyboard of user.
     * @param availability this parameter get value from keyboard of user.
     */
    public void addDoctor(String code, String name, String specialization, int availability) {
        this.list.add(new Doctor(code, name, specialization, availability)); // Use collection add to add new object.
        System.out.println("Add successfully"); // Notification when add success.
    }

    /**
     * Method displayAllDoctors().
     * This method will display all doctor in the arrayList.
     * The for loop to scan all object in the arrayList.
     */
    public void displayAllDoctors() {
        System.out.println("+------+----------------------+------------------------+---------------+"); // Show the table.
        System.out.println("|Code  |Name                  |Specialization          |Availability   |"); // Show collum in the table.
        System.out.println("+------+----------------------+------------------------+---------------+"); // Show the table.
        for (int i = 0; i < this.list.size(); i++) {  // The for loop to scan object in the arrayList
            Doctor d = this.list.get(i);  // Create object to get each object.
            System.out.printf("|%-6s|%-22s|%-24s|%-15d|\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability()); // Show object in the arrayList.
        }
        System.out.println("+------+----------------------+------------------------+---------------+"); // The end of table.
    }

    /**
     * Method updateDoctorByCode().
     * This method will update doctor follow the doctor code.
     * If doctor code is correct and exist in the List that doctor will be update.
     * @param code this parameter will be catch code of doctor from user keyboard.
     */
    public void updateDoctorByCode(String code) {
        System.out.println("Update doctor information"); // Show notification.
        int i = findDoctorCode(code);       // Call method findDoctorCode() to find the code from user input. If the code is exist in the array return index else return -1.
        if (i != -1) {  // If the code is exist in the List start update doctor.
            this.list.get(i).setName(inputName()); // Call method setName() to set name of doctor.
            this.list.get(i).setSpecialization(inputSpecialization()); // Call method setSpecialization() to set specialization of doctor.
            this.list.get(i).setAvailability(inputAvailability()); // Call method setAvailability() to set availability of doctor.
            System.out.println("Update successfully");   // Show notification when update success.
        } else { // If the code of doctor is not exist in the List show the notification.
            System.out.println("The code can't found!!!"); // Notification in this situation.
        }
    }

    /**
     * Method deleteDoctorByCode().
     * This method will delete doctor follow by doctor code.
     * In this method have parameter.
     * @param code this parameter will be catch code of doctor from user keyboard.
     */
    public void deleteDoctorByCode(String code){
        int i = findDoctorCode(code);   // Call method findDoctorCode() to find the code from user input. If the code of doctor is exist return index else return -1.
        if (i != -1) {  // If the code is exist in the List. Delete that doctor follow by code.
            this.list.remove(findDoctorCode(code));  // Use collection remove to delete doctor.
            System.out.println("Delete successfully"); // Show notification when delete is success.
        }else{  // If the code is not exist in the List show notification
            System.out.println("The code can't found!!!"); // Notification in this situation.
        }
    }
    
    /**
     * Method displayDoctorByCode().
     * This method will display doctor follow the code input from user keyboard.
     * In this method have parameter.
     * @param code this parameter will be catch code of doctor from user keyboard.
     */
    public void displayDoctorByCode(String code) {
        System.out.println("+------+----------------------+------------------------+---------------+");  // Show table.
        System.out.println("|Code  |Name                  |Specialization          |Availability   |"); // Show collum of table.
        System.out.println("+------+----------------------+------------------------+---------------+");// Show table.
        Doctor d = this.list.get(findDoctorCode(code));  // Create object to get each object value.
        System.out.printf("|%-6s|%-22s|%-24s|%-15d|\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability()); // Show value of object.
        System.out.println("+------+----------------------+------------------------+---------------+"); // Show the end of table.
    }

    /**
     * Method findDoctorCode().
     * This method will be find doctor follow the code.
     * In this method have parameter.
     * @param code this parameter will be catch code of doctor from user keyboard.
     * @return i index of doctor in the List, -1 if doctor code not exist.
     */
    public int findDoctorCode(String code) {
        for (int i = 0; i < this.list.size(); i++) {  // The loop to scan all object of List.
            Doctor d = this.list.get(i); // Create object to get each value.
            if (code.equals(d.getCode())) { // If code from user keyboard equal code in the List return index of object.
                return i; // Return index of object.
            }
        }
        return - 1;  // Return -1 when code is not exist.
    }

    /**
     * Method checkCode().
     * This method will be check code exist
     * In this method have parameter.
     * @param code this parameter will be catch the code of doctor from user keyboard.
     * @return true if code of doctor is exist, false if code of doctor is not exist.
     */
    public boolean checkCode(String code) {
        for (int i = 0; i < this.list.size(); i++) { // The for loop will be scan all of the object.
            Doctor d = this.list.get(i); // Create object to get each object value.
            if (d.getCode().equals(code)) { // If the code of doctor in the List equal code of doctor in the user input from keyboard return true else false.
                return true;  // Return true when code is exist.
            }
        }
        return false; // Return false when code is not exist.
    }

    /**
     * Method checkListIsEmpty().
     * This method will be check list is empty or not.
     * @return true when List is empty, false when list is not empty.
     */
    public boolean checkListIsEmpty() {
        if (this.list.isEmpty()) { // If this list is empty return true else return false.
            return true; // Return true when list is empty.
        }
        return false;  // Return false when list is not empty.
    }
    
    /**
     * Method checkNameIsExist().
     * This method will be check name of the object is exist or not
     * @param name this parameter will be catch name of the doctor in the List
     * @return true when name of doctor is exist, false when name of doctor not exist.
     */
    public boolean checkNameIsExist(String name){
        for (int i = 0; i < this.list.size(); i++) {    // The loop will scan all object in the list.
            Doctor d = this.list.get(i);   // Create the object to get value each object.
            if (d.getName().equals(name)) {  // If name of doctor is exist return true, else return false.
                return true; // Return true when name exist.
            }
        }
        return false;   // Return false when name is not exist.
    }
    
    /**
     * Method inputFindCode().
     * This method will find code from input user keyboard.
     * If the code is exist in the list return code of doctor.
     * @return code to get that code for update or delete doctor.
     */
    public String inputFindCode() {
        Scanner sc = new Scanner(System.in);    // Create Scanner for user can input from keyboard.
        String code = "";   // This variable will catch the value of user input from keyboard.
        boolean flag = true; // Flag will be check the input user from keyboard.
        do {  // do...while will be loop when input of user will be incorrect.
            try { // try...catch will be catch exception from input of user.
                flag = false;   // Flag be false to pause the loop for user input value from keyboard.
                System.out.print("Enter Code: "); // Notification for user know to input value.
                code = sc.nextLine().trim();    // Scanner to allow user input value from keyboard
                if (code.isEmpty()) {  // If input of user is empty show notification.
                    flag = true;    // Flag will be true to show notification and allow user input again.
                    System.out.println("Code can't be empty!!!"); // Notification in this situation.
                }
                if (!code.matches(VALIDATION) && !code.matches(CODE_VALIDATION)) { // If input from user keyboard is not matches the regex format show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Code must be follow three character uppercase, whitespace and 2 digit. For example: DOC 1!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true; // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!");  // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is true.
        return code; // Return input from keyboard of user.
    }

    /**
     * Method inputCode().
     * This method will be allow user input value from keyboard.
     * In this method will check some exception of user.
     * @return code the input of user from keyboard.
     */
    public String inputCode() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for user can input value from keyboard.
        String code = "";  // This variable will be catch the value input from keyboard of user.
        boolean flag = true;    // Flag will be check the input from keyboard of user.
        do {  // do...while will be loop when input of user incorrect.
            try { // try..catch will be catch exception from input of user.
                flag = false;  // Flag will be false to pause the loop for user input the value from the keyboard.
                System.out.print("Enter Code: "); // Notification for user know to input from keyboard.
                code = sc.nextLine().trim();  // Scanner to allow user input value from the keyboard.
                if (code.isEmpty()) {  // If input of user is empty show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Code can't be empty!!!"); // Notification in this situation.
                }
                if (!code.matches(VALIDATION) && !code.matches(CODE_VALIDATION)) { // If input from user keyboard is not matches the regex format show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Code must be follow three character uppercase, whitespace and 2 digit. For example: DOC 1!!!");  // Notification in this situation.
                }
                if (checkCode(code) == true) {  // If method checkCode() is true show notification. 
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Code is exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!");  // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is true.
        return code;  // Return input of user.
    }

    /**
     * Method inputName().
     * This method allow user can input value from keyboard.
     * In this method have check some exception.
     * @return name the input of user from keyboard.
     */
    public String inputName() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
        String name = "";  // This variable will be catch the value input from the user keyboard.
        boolean flag = true;  // Flag will check the input from keyboard of the user.
        do {  // do...while will be loop when input of the user is incorrect.
            try { // try...catch will be catch exception when input of user is incorrect.
                flag = false; // Flag will be false to pause the loop for user input the value from keyboard.
                System.out.print("Enter Name: "); // Notification for user know to input value.
                name = sc.nextLine().trim(); // Scanner for user input value from keyboard.
                if (name.isEmpty()) { // If input of user is empty show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Name can't be empty!!!"); // Notification in this situation.
                }
                if (!name.matches(NAME_VALIDATION)) { // If input of user is not matches the regex format show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Your input too long!!!"); // Notification in this situation.
                }
                if (checkNameIsExist(name)) { // If name is exist show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Name is exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!"); // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is true.
        return name;  // Return input from keyboard of user.
    }

    /**
     * Method inputSpecialization().
     * This method allow user input value from keyboard.
     * In this method will check some exception.
     * @return specialization input of user from keyboard.
     */
    public String inputSpecialization() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
        String specialization = "";   // This variable will be catch the value input from keyboard user.
        boolean flag = true;  // Flag will check the input from keyboard of the user.
        do {   // do...while will be loop when input of user is incorrect.
            try {   // try...catch will be catch exception when input of user incorrect.
                flag = false;  // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Specialization: "); // Notification for user know to input value.
                specialization = sc.nextLine().trim();  // Scanner input of user from keyboard.
                if (specialization.isEmpty()) {  // If input of user is empty show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Specialization can't be empty!!!");  // Notification in this situation.
                }
                if (!specialization.matches(SPECIALIZATION_VALIDATION)) { // If input of user is not matches the regex format show notification.
                    flag = true; // Flag will be true to show notification and allow user input again.
                    System.out.println("Your input too long!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!"); // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is true.
        return specialization; // Return input of user from keyboard.
    }

    /**
     * Method inputAvailability().
     * This method will allow user input from keyboard.
     * In this method will check some exception.
     * @return availability input of user from keyboard.
     */
    public int inputAvailability() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
        String availability = "";       // This variable will catch value input from keyboard of user.
        boolean flag = true;   // Flag will check input from keyboard of user.
        do {  // do...while will check input of user is correct or not.
            try {   // try...catch will catch exception if input of user is incorrect.
                flag = false;  // Flag will be false for pause the loop and allow user input from keyboard.
                System.out.print("Enter Availability: "); // Notification for user know to input value.
                availability = sc.nextLine().trim();  // Scanner input from keyboard of user.
                if (availability.isEmpty()) {  // If input of user is empty show notification.
                    flag = true;        // Flag will be true to show notification and allow user input again.
                    System.out.println("Availability can't be empty!!!"); //Notification in this situation.
                }
                if (Integer.parseInt(availability) <= 0 || Integer.parseInt(availability) >= 100) {  // If user input over the range show notification.
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("Your input must from 1 to 99!!!"); // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true;  // Flag will be true to show notification and allow user input again.
                System.out.println("Input wrong format!!!");  // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when falg is true.
        return Integer.parseInt(availability);  // Return input from keyboard of user.
    }
}

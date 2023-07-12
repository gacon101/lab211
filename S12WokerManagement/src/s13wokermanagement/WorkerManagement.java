/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s13wokermanagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class WorkerManagement {

    private ArrayList<Worker> listWorker;  // list of worker.
    private ArrayList<StatusSalary> statusSalary;  // list history salary update.
    private final String VALIDATION = "^$";
    private final String NAME_VALIDATION = "^[A-Za-z\\s]{0,15}$";
    private final String WL_VALIDATION = "^[A-Za-z\\s]{0,15}$";
    private final String ID_VALIDATION = "^[W]{1}[\\s]{1}(?!(0))[\\d]{1,2}$";

    /**
     * Constructor for main driver.
     * This constructor will create two list for first time running.
     */
    public WorkerManagement() {
        this.listWorker = new ArrayList<>();
        this.statusSalary = new ArrayList<>();
    }

    /**
     * Method addWorker().
     * This method allow user add new worker into listWorker.
     * In this method have parameter.
     * @param Id This parameter will set value for object worker.
     * @param name This parameter will set value for object worker.
     * @param age This parameter will set value for object worker.
     * @param salary This parameter will set value for object worker.
     * @param workLocation This parameter will set value for object worker.
     */
    public void addWorker(String Id, String name, int age, int salary, String workLocation) {
        this.listWorker.add(new Worker(Id, name, age, salary, workLocation)); // Collection add will add new object worker into the listWorker.
        System.out.println("Add successfully"); // Notification when add new object success.
    }

    /**
     * Method displayAllWorkers().
     * This method will show all object worker in listWorker.
     * When display on console this method will draw the table format.
     * Scan all object by the for loop and display all object on the console.
     */
    public void displayAllWorkers() {
        System.out.println("+------+-------------------------+------+-------------------+--------------------------+");  // Header of the table.
        System.out.println("|ID    |Name of Woker            |Age   |Salary             |Work Location             |"); // Name of collum table.
        System.out.println("+------+-------------------------+------+-------------------+--------------------------+"); // Header of the table.
        for (int i = 0; i < this.listWorker.size(); i++) {  // The for loop for scan all object in the listWorker.
            Worker w = this.listWorker.get(i);  // Create object for get each object in the listWorker.
            System.out.printf("|%-6s|%-25s|%-6d|%-19d|%-26s|\n", w.getId(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation());  // Display all object in listWorker.
        }
        System.out.println("+------+-------------------------+------+-------------------+--------------------------+");  // The end of the table.
    }

    /**
     * Method updateStatusSalaryUp().
     * This method will update salary and status salary follow ID of worker.
     * In this method only allow user update upper the salary.
     * If user update salary lower than current salary, notification will be show on console.
     * @param updateId This parameter will catch Id of worker.
     * @param updateSalary This parameter will catch the salary update.
     */
    public void updateStatusSalaryUp(String updateId, int updateSalary) {
        int i = findID(updateId);  // Call method findID to find the ID user input return index if ID exist return -1 if ID is not exist.
        if (i != -1) {  // If Variable i difference -1 allow user update salary.
            int currentSalary = this.listWorker.get(i).getSalary();  // crurentSalary will get salary before update.
            if (updateSalary == currentSalary) {  // if currentSalary equal update salary show notification.
                System.out.println("New salary must be greater or smaller than curent salary!!!"); // This notidication in this situation.
            }
            if (updateSalary < currentSalary) { // If updateSalary less than curentSalary show notification.
                System.out.println("New salary must be greater than curent salary!!!");  // Notification in this situation.
            }
            if (updateSalary > currentSalary) {  // If updateSalary greater than curentSalary allow user update salary.
                String ID = this.listWorker.get(i).getId();  // This variable will get ID of object.
                String name = this.listWorker.get(i).getName();  // This variable will get name of object.
                int age = this.listWorker.get(i).getAge();  // This variable will get age of object.
                this.listWorker.get(i).setSalary(updateSalary);  // Call method setSalary to set new update salary.
                int salary = this.listWorker.get(i).getSalary();  // This variable will get salary of object.
                String workLocation = this.listWorker.get(i).getWorkLocation(); // This variable wil get work location of object.
                this.statusSalary.add(new StatusSalary(ID, name, age, salary, "UP", getCurrentDate(), workLocation));  // Add the history update salary.
            }
        } else {  // If Id is not exist show notification.
            System.out.println("ID is not exist!!!");  // Notification in this situation.
        }
    }

    /**
     * Method updateStatusSalaryDown().
     * This method will update salary and status salary follow ID of worker.
     * In this method only allow user update downer the salary.
     * If user update salary higher than current salary, notification will be show on console.
     * @param updateId This parameter will get Id of the object in the listWorker.
     * @param updateSalary This parameter will set new salary for object.
     */
    public void updateStatusSalaryDown(String updateId, int updateSalary) {
        int i = findID(updateId);  // Call method findID() to find the ID of worker, if ID is exist in listWorker return index, if ID is not exist return -1.
        if (i != -1) {  // If variable i is difference -1 allow user update salary of object. 
            int currentSalary = this.listWorker.get(i).getSalary();  // Variable curentSalary will get curent salary of the object.
            if (updateSalary == currentSalary) {  // If updateSalary equal curentSalary show notification.
                System.out.println("New salary must be greater or smaller than curent salary!!!");  // Notification in this situation.
            }
            if (updateSalary > currentSalary) {  // If updateSalary higher than curentSalary show notification.
                System.out.println("New salary must be smaller than curent salary!!!"); // Notification in this situation.
            }
            if (updateSalary < currentSalary) {  // If updateSalary less than curentSalary allow user update salary of object.
                String ID = this.listWorker.get(i).getId();   // This variable will get ID of object.
                String name = this.listWorker.get(i).getName();  // This variable will get ID of object.
                int age = this.listWorker.get(i).getAge();  // This variable will get age of object.
                this.listWorker.get(i).setSalary(updateSalary); // Call method setSalary to set new update salary.
                int salary = this.listWorker.get(i).getSalary();  // This variable will get salary of object.
                String workLocation = this.listWorker.get(i).getWorkLocation(); // This variable wil get work location of object.
                this.statusSalary.add(new StatusSalary(ID, name, age, salary, "DOWN", getCurrentDate(), workLocation));  // Add history update salary.
            }
        } else {  // If variable i euqal -1 show notification.
            System.out.println("ID is not exist!!!"); // Notification in this situation.
        }
    }

    /**
     * Method getCurentDate().
     * This method will get current date on computer.
     * In this method use DateFormat and Calendar to set date format and get date on the computer.
     * @return String of date.
     */
    public String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // Use Dateformat to format date follow dd/MM/yyyy.
        Calendar c = Calendar.getInstance();   // Use Calendar to get date on computer.
        return df.format(c.getTime());  // Return String date.
    }

    /**
     * Method sortByID().
     * This method will sort history update salary.
     * In this method use ID of worker to sort.
     */
    public void sortByID() {
        Collections.sort(this.statusSalary, (StatusSalary o1, StatusSalary o2) -> o1.getId().compareTo(o2.getId()));  // Use collection sort to sort all object in list.
    }

    /**
     * Method displaySalaryInformation().
     * This method will display all history update salary.
     */
    public void displaySalaryInformation() {
        System.out.println("+------+-------------------------+------+-------------------+--------+--------------+");  // Display header of table.
        System.out.println("|ID    |Name of Woker            |Age   |Salary             |Status  |Date          |");  // Display name of collum.
        System.out.println("+------+-------------------------+------+-------------------+--------+--------------+");  // Display header of table.
        for (int i = 0; i < this.statusSalary.size(); i++) {   // The for loop will scan all object in the list.
            StatusSalary ss = this.statusSalary.get(i);   // Create object to get each object in the list.
            System.out.printf("|%-6s|%-25s|%-6d|%-19d|%-8s|%-14s|\n", ss.getId(), ss.getName(), ss.getAge(), ss.getSalary(), ss.getStatus(), ss.getDate()); // Display each object in the list.
        }
        System.out.println("+------+-------------------------+------+-------------------+--------+--------------+");  // Displat the end of the table.
    }

    /**
     * Method findID().
     * This method will be find ID of the object in the list.
     * In this method use list of worker to find the ID.
     * This method  user for update salary feature.
     * @param ID This parameter will get input ID of the user when user input from keyboard.
     * @return
     */
    public int findID(String ID) {
        for (int i = 0; i < this.listWorker.size(); i++) { // The for loop will scan for all object in the list.
            Worker w = this.listWorker.get(i);  // Create object to get each object in the list.
            if (w.getId().equals(ID)) {  // If ID of input user is exist in the list. Return index of object in the list, else return -1.
                return i;    // Return index i if ID is exist.
            }
            
        }
        return -1;  // Return -1 when ID is not exist.
    }

    /**
     * Method checkListIsEmpty().
     * This method will check list is empty or not.
     * If list is empty method will return true, else method will return false.
     * @return true when list is empty, false when list is not empty.
     */
    public boolean checkListIsEmpty() {
        if (this.listWorker.isEmpty()) {  // If the list is empty return true.
            return true;        // Return in this situation.
        }
        return false;       // Return false when list is not empty.
    }

    /**
     * Method checkIdIsExist().
     * This method will check ID of the object in the is exist or not.
     * This method use boolean type to return result.
     * If ID is exist return of the method will be true, else return of the method will be false.
     * @param Id This parameter will be catch the input value of the user.
     * @return true when ID is exist, false when ID is not exist.
     */
    public boolean checkIdIsExist(String Id) {
        for (int i = 0; i < this.listWorker.size(); i++) {  // The for loop will scan all object in the list.
            Worker w = this.listWorker.get(i); // Create object to get each object in the list.
            if (w.getId().equals(Id)) {  // If ID of input user mathces to ID object in the list. Return true, else return false.
                return true;  // Return true when ID is exist in the list.
            }
        }
        return false;  // Retrun false when ID is not exist in the list.
    }

    /**
     * Method checkListWorkerIsEmpty().
     * This method will check list is empty or not.
     * This method will be use boolean type to return result.
     * If list is empty the method will return true, else the method will return false.
     * @return true when list is empty, false when list is not empty.
     */
    public boolean checkListWorkerIsEmpty() {
        for (int i = 0; i < this.listWorker.size(); i++) {  // The for loop will scan all object in the list.
            if (this.listWorker.isEmpty()) {  // If list is empty return true, else return false.
                return true; // Return true when list is empty.
            }
        }
        return false;  // Return false when list is not empty.
    }

    /**
     * Method checkNameIsExist().
     * This method will check name of worker is exist in the list or not.
     * This method will use boolean type to return result.
     * If name of worker is exist method will return true, else method will return false.
     * @param name This parameter will get input value of user.
     * @return true when name is exist in the list, else return false when name is not exist in the list.
     */
    public boolean checkNameIsExist(String name) {
        for (int i = 0; i < this.listWorker.size(); i++) {  // The for loop will scan all object in the list.
            Worker w = this.listWorker.get(i);   // Create object to get each object in the list.
            if (w.getName().equals(name)) {  // If the name input of user matches to the name in the list return true, else return false.
                return true;  // Return true when name is exist in the list.
            }
        }
        return false;  // Return false when then name is not exist in the list. 
    }

    /**
     * Method inputUpdateID().
     * This method will allow user input value from keyboard.
     * This method use String type to return result.
     * In this method use:
     * + Method isEmpty() to check input value empty.
     * + ReGex VAlIDATION: to allow empty String for check ID.
     * + ReGex ID_VALIDATION: to check format of the worker ID.
     * + Method checkIdIsExist(): to check ID of worker.
     * If input ID from user correct method will return result, else method will display notification.
     * @return Id input of user from keyboard.
     */
    public String inputUpdateID() {
        Scanner sc = new Scanner(System.in);  // Create Scanner for user input from keyboard.
        String Id = "";        // This variable will catch input of user.
        boolean flag = true;  // Flag will check input of user when user input incorrect.
        do {  // do...while loop will be loop when user input imcorrect.
            try {  // try...catch will catch exception when input of user is incorrect.
                flag = false;  // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter ID: "); // Notification for user know to input from keyboard.
                Id = sc.nextLine().trim();  // Scanner for user input from keyboard, trim() to remove whitespace.
                if (Id.isEmpty()) { // If input of user is empty display notification.
                    flag = true;  // Flag will be true to display notifiacation and allow user input again.
                    System.out.println("ID can't be empty!!!");  // Notification in this situation.
                }
                if (!Id.matches(VALIDATION) && !Id.matches(ID_VALIDATION)) { // If input of user matches to the ReGex display notification.
                    flag = true;  // Flag will be true to display notification and allow user input again.
                    System.out.println("ID must be follow letter W uppercase, whitespace and 2 digit. For example: W 1!!!");  // Notification in this situation.
                }
                if (checkIdIsExist(Id) == false) {  // If method checkIdExist is false display notification
                    flag = true;  // Flag will be true to show notification and allow user input again.
                    System.out.println("ID is not exist");  // Notification in this situation.
                }
            } catch (Exception e) {  // Catch exception if have throw exception.
                flag = true;  // Flag will be true to display notification and allow user input again.
                System.out.println("Input wrong format!!!"); // Notification in this situation.
            }
        } while (flag == true);  // The loop will be loop when flag is true.
        return Id;  // Return the input from keyboard of user.
    }

    /**
     * Method inputID().
     * This method will allow user input value from keyboard.
     * This method use String type to return the result.
     * In this method use:
     * + Method isEmpty: to check input of user is empty or not.
     * + ReGex VALIDATION: to allow user input empty String.
     * + ReGex ID_VALIDATION: to check ID input format.
     * + Method checkIdIsExist(): to check ID from input of user is exit or not.
     * @return ID the input from keyboard of user.
     */
    public String inputID() {
        Scanner sc = new Scanner(System.in);  // Create Scanner to allow user input from keyboard.
        String Id = "";   // This variable will catch the value input of user from keyboard.
        boolean flag = true;    // Flag will check the loop when input of user incorrect.
        do {    // do...while for loop when input of user is incorrect.
            try {   // try...catch for catch exception when inupt of user is in correct.
                flag = false;   // Flag will be false to pause the loop for use input from keyboard.
                System.out.print("Enter ID: "); //Notificaton for user know to input from keyboard.
                Id = sc.nextLine().trim();  //Scanner for user can input from keyboard.
                if (Id.isEmpty()) { // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notifiacaton and allow user input again.
                    System.out.println("ID can't be empty!!!"); //Notification in this situation.
                }
                if (!Id.matches(VALIDATION) && !Id.matches(ID_VALIDATION)) {    // If ID is mot matches to the ReGex show notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("ID must be follow letter W uppercase, whitespace and 2 digit. For example: W 1!!!");    //Notification in this situation.
                }
                if (checkIdIsExist(Id) == true) {   // If checkIdIsExist() is true display notification.
                    flag = true; // Flag will be true to display notification and allow user input agaian.
                    System.out.println("ID is exist!!!");   // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notification.
                System.out.println("Input wrong format!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return Id;  // Reture input of user.
    }

    /**
     * Method inputName().
     * This method will allow user input from keyboard.
     * This method use String type to return the result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + ReGex NAME_VALIDATION: to check format name input.
     * + Method checkNameIsExist(): to check name is exist in the list or not.
     * @return name input of user from keyboard.
     */
    public String inputName() {
        Scanner sc = new Scanner(System.in);    // Create Scanner for user input from keyboard.
        String name = "";   // This variable to catch the input of user from the keyboard.
        boolean flag = true;    // Flag will be check the loop when user input incorrect. 
        do {    // do...while to loop when user input value from keyboard inocrrect.
            try {   // try..catch will catch exception when input of user incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Name: ");  // Notification for user know to input from keyboard.
                name = sc.nextLine().trim();    // Scanner for allow user input from keyboard.
                if (name.isEmpty()) {   // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Name can't be empty!!!");   // Notificaton in this sitaution.
                }
                if (!name.matches(NAME_VALIDATION)) {   // If input of user not matches to the ReGex display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Your input is too long or wrong format!!!");    // Notification in this situation.
                }
                if (checkNameIsExist(name) == true) {   // If method checkNameIsExist() is true display notification.
                    flag = true;    // Flag will be true to display notifcation and allow uaser input again.
                    System.out.println("Name is exist!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Input wrong format!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return name;    // Return input from keyboard of user.
    }

    /**
     * Method inputAge().
     * This method allow user input from keyboard.
     * This method use integer type to return the result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + Integer.parseInt(): to convert String type to integer type. 
     * @return age the input from keyboard of user.
     */
    public int inputAge() {
        Scanner sc = new Scanner(System.in);    // Create Scanner to allow user input from keyboard.
        String age = "";    // This variable will catch input from keyboard of user.
        boolean flag = true;    // Flag will check the loop when user input incorrect.
        do {    // do...while will loop when user input incorrect.
            try {   // try...catch will catch exception when user input incorrect.
                flag = false;   // Flag will false to pause the loop for user input from keyboard.
                System.out.print("Enter Age: ");    // Notification for user know to input from keyboard.
                age = sc.nextLine().trim(); // Scanner will allow user input from keyboard.
                if (age.isEmpty()) {    // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notificaton and allow user input again.
                    System.out.println("Age can't be empty!!!");    // Notification in this situation.
                }
                if (Integer.parseInt(age) <= 17 || Integer.parseInt(age) >= 51) {   // If input of user over the range display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Age must be from 18 to 50!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Input wrong format!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is empty.
        return Integer.parseInt(age);   // Return input from keyboard of user.
    }

    /**
     * Method inputSalary().
     * This method will allow user input value from keyboard.
     * This method use integer type to return the result.
     * In this method use:
     * + Method isEmpty: to check input of user is empty or not.
     * + Integer.parseInt(): to convert String type to integer type.
     * @return salary the input from keyboard of user.
     */
    public int inputSalary() {
        Scanner sc = new Scanner(System.in);    // Create Scanner will allow uer input from keyboard.
        String salary = ""; // This variable will catch the input from keyboard of user.
        boolean flag = true;    // Flag will check the loop when user input incorrect.
        do {    // do...while loop when user input incorrect.
            try {   // try...catch exception when user input incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter Salary: "); // Notification for user know to input.
                salary = sc.nextLine().trim();  //Scanner to allow user input from keyboard.
                if (salary.isEmpty()) { // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notificarion and allow user to input again.
                    System.out.println("Salary can't be empty!!!"); // Notification in this situation.
                }
                if (Integer.parseInt(salary) <= 0 || Integer.parseInt(salary) >= 9999999) { // If input of user over the range.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Salary must be greater than zero!!!");  // Notification in this situation.
                }
            } catch (Exception e) { // Catch the exception if have exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Input wrong format!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return Integer.parseInt(salary);    // Return input of user from keyboard.
    }

    /**
     * Method inputWorkLocation().
     * This method will allow user input from keyboard.
     * This method use String type to return the result.
     * In this method use:
     * + Method isEmpty(): to check input of user is empty or not.
     * + ReGex WL_VALIDATION: to check format input of user.
     * @return workLocation the input of user from keyboard.
     */
    public String inputWorkLocation() {
        Scanner sc = new Scanner(System.in);    // Create Scanner to allow user input from keyboard.
        String workLocation = "";   // This variable will catch input of user from keyboard.
        boolean flag = true;    // Flag will check the loop when input of user is incorrect.
        do {    // do...while will loop if user input incorrect.
            try {   // try...catch will be catch exception when input of user is incorrect.
                flag = false;   // Flag will be false to pause the loop for user input from keyborad.
                System.out.print("Enter Work Location: ");  // Notification for user know to input from keyboard.
                workLocation = sc.nextLine().trim();    // Scanner will be allow user input from keyboard.
                if (workLocation.isEmpty()) {   // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Work location can't be empty!!!");  // Notification in this situation.
                }
                if (!workLocation.matches(WL_VALIDATION)) { // If input of user not matches to ReGex display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Your input is too long or wrong format!!!");    // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Input wrong format!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return workLocation;    // Return input of user from keyboard.
    }
}

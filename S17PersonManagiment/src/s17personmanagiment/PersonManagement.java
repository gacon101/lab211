/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s17personmanagiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class PersonManagement {

    private ArrayList<Person> listOfPerson;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor for main driver using.
     * In this constructor have parameter
     * @param size This parameter will catch size of ArrayList from user input.
     */
    public PersonManagement(int size) {
        this.listOfPerson = new ArrayList<>(size);
    }

    /**
     * Method addPerson().
     * This method will allow user add new person into ArrayList.
     * @param name This parameter will catch input from user.
     * @param address This parameter will catch input from user.
     * @param salary This parameter will catch input from user.
     */
    public void addPerson(String name, String address, double salary) {
        this.listOfPerson.add(new Person(name, address, salary));   // Call method add to add new person.
        System.out.println("Adding successfully\n");    // Notification when add success.
    }

    /**
     * Method displayPerson().
     * This method will display on console all object in the ArrayList.
     */
    public void displayPerson() {
        for (int i = 0; i < this.listOfPerson.size(); i++) {    // The loop will scan all object in the ArrayList.
            Person p = this.listOfPerson.get(i);    // Cearte object to get each data in the ArrayList.
            System.out.println("\nInformation of Person you have entered: ");   // Notification for user know.
            System.out.println("Name: " + p.getName()); // Get data in the object.
            System.out.println("Address: " + p.getAddress());   // Get data in the object.
            System.out.println("Salary: " + p.getSalary()); // Get data in the object.
            System.out.println();
        }
    }

    /**
     * Method sortBySalary().
     * This method will sort object in the ArrayList by salary attribute.
     * This method use Lambda expression. 
     */
    public void sortBySalary() {
        Collections.sort(this.listOfPerson, (Person o1, Person o2) -> (int) (o1.getSalary() - o2.getSalary())); // Use Collection Sort write follow Lambda expression to sort ArrayList.
    }

    /**
     * Method inputName().
     * This method allow user can input from keyboard.
     * In this method use:
     * + Method isEmpty: to check empty input.
     * @return name The value from input of user.
     */
    public String inputName() {
        String input = "";  // This variable will contain value from user input.
        boolean flag = true;    // Flag will be check the loop if user input incorrect.
        do {    // do...while will loop if user input incorrect.
            try {   // try...catch will catch exception if user input incorrect.
                flag = false;   // Flag will be false for pause the loop for user input from keyboard.
                System.out.print("Enter Name: ");   // Notification for user know to input from keyboard.
                input = this.sc.nextLine(); // Scanner input from user keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard.
                    System.out.println("Name can't be emrpty!!!");  // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notifiaction and allow user input again.
                System.out.println("Input incorrcet!!!");   // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when user input incorrect.
        return input;   // Return input of user.
    }

    /**
     * Method inputAddress().
     * This method allow user can input from keyboard.
     * In this method use:
     * + Method isEmpty: to check empty input.
     * @return address The value from input of user
     */
    public String inputAddress() {
        String input = "";  // This variable will contain value from user input.
        boolean flag = true;    // Flag will be check the loop if user input incorrect.
        do {    // do...while will loop if user input incorrect.
            try {   // try...catch will catch exception if user input incorrect.
                flag = false;   // Flag will be false for pause the loop for user input from keyboard.
                System.out.print("Enter Address: ");   // Notification for user know to input from keyboard.
                input = this.sc.nextLine(); // Scanner input from user keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard.
                    System.out.println("Address can't be emrpty!!!");  // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notifiaction and allow user input again.
                System.out.println("Input incorrcet!!!");   // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when user input incorrect.
        return input;   // Return input of user.
    }

    /**
     * Method inputSalary().
     * This method allow user can input from keyboard.
     * In this method use:
     * + Method isEmpty: to check empty input.
     * @return salary The value from input of user.
     */
    public double inputSalary() {
        String input = "";  // This variable will contain value from user input.
        boolean flag = true;    // Flag will be check the loop if user input incorrect.
        do {    // do...while will loop if user input incorrect.
            try {   // try...catch will catch exception if user input incorrect.
                flag = false;   // Flag will be false for pause the loop for user input from keyboard.
                System.out.print("Enter Salary: "); // Notification for user know to input from keyboard.
                input = this.sc.nextLine(); // Scanner input from user keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard.
                    System.out.println("Salary can't be empty!!!"); // Notification in this situation.
                }
                if (Double.parseDouble(input) < 0) {    // If salary of user less than zero display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Salary must be greater than zero!!!");  // Notification in this situation
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notification and allow user input again.
                System.out.println("Input incorrect!!!");   // Notification in this situation
            }
        } while (flag == true); // The loop will be loop when user input incorrect.
        return Double.parseDouble(input);   // Return input of user.
    }
}

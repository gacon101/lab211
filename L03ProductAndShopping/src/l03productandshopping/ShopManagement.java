/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03productandshopping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class ShopManagement {

    private ArrayList<Fruit> listOfFruit;
    private ArrayList<CustomerOrder> listOrderFruit;
    private Hashtable<String, ArrayList<CustomerOrder>> listOrderOfCustomer;
    private int numberOfFruit;
    private int numberOfFruitInOrder;
    private Scanner sc = new Scanner(System.in);
    private final String ORIGIN_VALIDATION = "^[A-Za-z\\s]{2,20}$";
    private final String FRUIT_NAME_VALIDATION = "^[A-Za-z\\s]{2,20}$";
    private final String NAME_VALIDATION = "^[A-Za-z]{2,10}$";
    private final String CHOICE_VALIDATION = "^[A-Z]{1}$";

    /**
     * Constructor for main driver using.
     */
    public ShopManagement() {
        this.numberOfFruit = 0;
        this.numberOfFruitInOrder = 0;
        this.listOfFruit = new ArrayList<>();
        this.listOrderOfCustomer = new Hashtable<>();
    }

    /**
     * Method addFruit(). 
     * This method will add fruit into list fruit of the shop. 
     * This parameter use integer type to return the result. 
     * This method use: 
     * + Method add(): To add object into the ArrayList. 
     * + numberOfFruit: To count fruit. In this parameter have parameter:
     * @param fruitName This parameter will get input of user and add into the list.
     * @param price This parameter will get input of user and add into the list.
     * @param quantity This parameter will get input of user and add into the list.
     * @param origin This parameter will get input if user and add into the list.
     * @return numberOfFruit To count fruit in the list.
     */
    public int addFruit(String fruitName, double price, int quantity, String origin) {
        this.listOfFruit.add(new Fruit(++this.numberOfFruit, fruitName, price, quantity, origin));  // Call method add to add object into the list.
        System.out.println("Create fruit successfully.");   // Notification when add successfully.
        return this.numberOfFruit;  // Return numberOfFruit to count fruit in the list.
    }

    /**
     * Method addOrder(). 
     * This method will add order of user into the list order of shop. 
     * This method use: 
     * + Method add(): To add object into the ArrayList. 
     * In this method have parameter:
     * @param fruitID This parameter will get input of user and add into the list.
     * @param fruitName This parameter will get input of user and add into the list.
     * @param price This parameter will get input of user and add into the list.
     * @param quantity This parameter will get input user and add into the list.
     * @param origin This parameter will get input user and add into the list.
     * @param amount This parameter will get input user and add into the list.
     */
    public void addOrder(int fruitID, String fruitName, double price, int quantity, String origin, double amount) {
        this.listOrderFruit.add(new CustomerOrder(fruitID, fruitName, price, quantity, origin, amount));    // Call method add to add object in to the list.
    }

    /**
     * Method displayTotalFruit(). 
     * This method will display total number of fruit in list.
     */
    public void displayTotalFruits() {
        if (this.numberOfFruit == 1) {  // If numberOfFruit equal 1 display notification in this situation.
            System.out.println("Total: " + this.numberOfFruit + " fruit");  // Notification in this situation.
        } else {    // If numberOfFriut not equal 1 display notification in this situation.
            System.out.println("Total: " + this.numberOfFruit + " fruits"); // Notification in this situation.
        }
    }

    /**
     * Method displayAllFruit(). 
     * This method will display all fruit in the fruit list. 
     * This method use: 
     * + displayTotalFruits(): to display on console total of fruit in list.
     */
    public void displayAllFruits() {
        displayTotalFruits();   // Display on console total of fruit.
        System.out.println("+----+--------------------+---------------+------+----------+");    // Display header of table.
        System.out.println("| No.|Fruit Name          |Origin         | Price|  Quantity|");    // Display name of collum.
        System.out.println("+----+--------------------+---------------+------+----------+");    // Display header of table.
        for (int i = 0; i < this.listOfFruit.size(); i++) { // The loop will scan all object in the list.
            Fruit f = this.listOfFruit.get(i);  // Create object to get each value.
            // Display each object in the list.
            if (f.getOrigin().length() == 2) {
                System.out.printf("|%4d|%-20s|%-15s|%5.0f$|%10d|\n", f.getFruitID(),
                        f.getFruitName().substring(0, 1).toUpperCase() + f.getFruitName().substring(1).toLowerCase(),
                        f.getOrigin().toUpperCase(),
                        f.getPrice(),
                        f.getQuantity());
            } else {
                System.out.printf("|%4d|%-20s|%-15s|%5.0f$|%10d|\n", f.getFruitID(),
                        f.getFruitName().substring(0, 1).toUpperCase() + f.getFruitName().substring(1).toLowerCase(),
                        f.getOrigin().substring(0, 1).toUpperCase() + f.getOrigin().substring(1).toLowerCase(),
                        f.getPrice(),
                        f.getQuantity());
            }
        }
        System.out.println("+----+--------------------+---------------+------+----------+");    // Display footer of table.
    }

    /**
     * Method displayOrderOfCustomer().
     * This method will display all order in the list order.
     */
    public void displayOrderOfCustomer() {
        double total = 0;
        System.out.println("+----+--------------------+---------------+----------+----------+----------+"); // Display header of table.
        System.out.println("| No.|Fruit Name          |Origin         |  Quantity|     Price|    Amount|"); // Display name collum of table.
        System.out.println("+----+--------------------+---------------+----------+----------+----------+"); // Display header of table.
        for (int i = 0; i < this.listOrderFruit.size(); i++) {  // The loop will scan all object in the ArrayList.
            if (this.listOrderFruit.get(i).getOrigin().length() == 2) {
                System.out.printf("|%4d|%-20s|%-15s|%10d|%9.0f$|%9.0f$|\n", this.listOrderFruit.get(i).getFruitID(),
                        this.listOrderFruit.get(i).getFruitName().substring(0, 1).toUpperCase() + this.listOrderFruit.get(i).getFruitName().substring(1).toLowerCase(),
                        this.listOrderFruit.get(i).getOrigin().toUpperCase(),
                        this.listOrderFruit.get(i).getQuantity(),
                        this.listOrderFruit.get(i).getPrice(),
                        this.listOrderFruit.get(i).getAmount());    // Display object on the console.
            } else {
                System.out.printf("|%4d|%-20s|%-15s|%10d|%9.0f$|%9.0f$|\n", this.listOrderFruit.get(i).getFruitID(),
                        this.listOrderFruit.get(i).getFruitName().substring(0, 1).toUpperCase() + this.listOrderFruit.get(i).getFruitName().substring(1).toLowerCase(),
                        this.listOrderFruit.get(i).getOrigin().substring(0, 1).toUpperCase() + this.listOrderFruit.get(i).getOrigin().substring(1).toLowerCase(),
                        this.listOrderFruit.get(i).getQuantity(),
                        this.listOrderFruit.get(i).getPrice(),
                        this.listOrderFruit.get(i).getAmount());    // Display object on the console.
            }
            total += this.listOrderFruit.get(i).getAmount();
        }
        System.out.println("+----+--------------------+---------------+----------+----------+----------+"); // Display footer of the table.
        System.out.print("|                                                          TOTAL|");
        System.out.printf("%9.0f$|\n", total);  // Display total amount of order.
        System.out.println("+----+--------------------+---------------+----------+----------+----------+");
    }

    /**
     * Method viewOrders(). 
     * This method will display orders on console. 
     * This method use HashTable to display all orders.
     */
    public void viewOrders() {
        if (this.listOrderOfCustomer.isEmpty()) {   // If listOrdersOfCustomer is empty display notification.
            System.out.println("The shop has no orders yet!!!\n");  // Notification in this situation.
        } else {    // If listOrderOfCustomer have data display all orders.
            System.out.println();
            for (Map.Entry<String, ArrayList<CustomerOrder>> entry : listOrderOfCustomer.entrySet()) {  // The loop for scan all object in the list.
                String key = entry.getKey();    // Key is name and date order of user.
                ArrayList<CustomerOrder> value = entry.getValue();  // Value is the data in list of fruit of customer order.
                double total = 0;   // Variable total will caculate total of amount.
                System.out.println("Customer: " + key.substring(0, 1).toUpperCase() + key.substring(1).toLowerCase());  // Display customer name and date order.
                System.out.println("+----+--------------------+---------------+----------+----------+----------+"); // Display header of table.
                System.out.println("| No.|Fruit Name          |Origin         |  Quantity|     Price|    Amount|"); // Display name of the collum.
                System.out.println("+----+--------------------+---------------+----------+----------+----------+"); // Display header of the table.
                for (int i = 0; i < value.size(); i++) {    // The loop will scan all object in order.
                    if (value.get(i).getOrigin().length() == 2) {
                        System.out.printf("|%4d|%-20s|%-15s|%10d|%9.0f$|%9.0f$|\n", value.get(i).getFruitID(),
                                value.get(i).getFruitName().substring(0, 1).toUpperCase() + value.get(i).getFruitName().substring(1).toLowerCase(),
                                value.get(i).getOrigin().toUpperCase(),
                                value.get(i).getQuantity(),
                                value.get(i).getPrice(),
                                value.get(i).getAmount());  // Display all object in the list.
                    } else {
                        System.out.printf("|%4d|%-20s|%-15s|%10d|%9.0f$|%9.0f$|\n", value.get(i).getFruitID(),
                                value.get(i).getFruitName().substring(0, 1).toUpperCase() + value.get(i).getFruitName().substring(1).toLowerCase(),
                                value.get(i).getOrigin().substring(0, 1).toUpperCase() + value.get(i).getOrigin().substring(1).toLowerCase(),
                                value.get(i).getQuantity(),
                                value.get(i).getPrice(),
                                value.get(i).getAmount());  // Display all object in the list.
                    }
                    total += value.get(i).getAmount();  // Caculate total amount of order.
                }
                System.out.println("+----+--------------------+---------------+----------+----------+----------+");
                System.out.print("|                                                          TOTAL|");
                System.out.printf("%9.0f$|\n", total);  // Display total amount of order.
                System.out.println("+----+--------------------+---------------+----------+----------+----------+\n");
            }
        }
    }

    /**
     * Method findFruit(). 
     * This method will find fruit by origin. 
     * In this method have parameter.
     * @param fruitName This parameter will catch input of user.
     * @param origin This parameter will catch input of user.
     * @return index of object if object is exist, -1 if object is not exist.
     */
    public int findFruit(String fruitName, String origin) {
        int index = 0;
        for (int i = 0; i < this.listOfFruit.size(); i++) { // The loop will scan all the object in the list.
            Fruit f = this.listOfFruit.get(i);  // Create object to get each value.
            if (f.getFruitName().equals(fruitName) && f.getOrigin().equals(origin)) {   // If object is exist, variable index will equal variable i.
                index = i;  // Variable index have value of variable i.
            }
        }
        return index;   // Return index of fruit
    }

    /**
     * Method setNo(). 
     * This method will set Id again when object remove from list. 
     * This method use: 
     * + Method setFruitID(): to set ID of fruit after remove.
     */
    public void setNo() {
        for (int i = 0; i < this.listOfFruit.size(); i++) { // The loop for scan all object in the list.
            Fruit f = this.listOfFruit.get(i);  // Create object to get each value.
            f.setFruitID(i + 1);    // Call method setFruitID() to set ID .
        }
    } 

    /**
     * Method getDateAndTime(). 
     * This method will get date and time of order.
     * This method use String type to return the result. 
     * In this method use: 
     * + Method SimpleDateFormat(): to format date and time of order. 
     * + Method getIntance(): to get date and time in calendar.
     * @return dateFormat.format(c.getTime()) to get date time of order.
     */
    public String getDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    // Format to get date and time of order.
        Calendar c = Calendar.getInstance();    // get date and time from calendar.
        return dateFormat.format(c.getTime());  // Return date and time of order.
    }

    /**
     * Method updateQuantity(). 
     * This method will update quantity of list fruit when buyer order. 
     * This method use: 
     * + Method findFruit(): to find the fruit in the list fruit. 
     * + Method setQuantity(): to set quantity in the list fruit. 
     * + Method remove(): to remove object. 
     * + Method setNo(): to set fruit ID.
     * @param i This parameter will catch index of object in ArrayList.
     * @param updateQuantity This parameter will get input of user.
     */
    public void updateQuantity(int i, int updateQuantity) {
        this.listOfFruit.get(i).setQuantity(this.listOfFruit.get(i).getQuantity() - updateQuantity);    // Call method set quantity for set quantity of fruit when customer order.
        if (this.listOfFruit.get(i).getQuantity() <= 0) {   // If quantity of object equal or less than zero that object will be remove from list of fruit.
            this.listOfFruit.remove(i); // Call method to remove object.
            --this.numberOfFruit;   // Minus numberOfFruit to count total of fruit.
            setNo();    // Call method setNo to set fruit ID again.
            System.out.println("Sold out!!!");  // Notification in this situation.
        }
    }

    /**
     *
     * @param updateQuantity
     * @param fruitName
     * @param origin
     */
    public void updateQuantityInOrder(int updateQuantity, String fruitName, String origin) {
        int i = findFruitInOrder(fruitName, origin);
        this.listOrderFruit.get(i).setQuantity(this.listOrderFruit.get(i).getQuantity() + updateQuantity);
        this.listOrderFruit.get(i).setAmount(this.listOrderFruit.get(i).getPrice() * this.listOrderFruit.get(i).getQuantity());
    }

    /**
     * Method createFruit(). 
     * This method will create new fruit in the shop. 
     * In this method use: 
     * + Method inputChoice(): to allow user input choice to continue loop or not. 
     * + Method inputFruitName(): to allow user input value from keyboard. 
     * + Method inputOrigin(): to allow user input value from keyboard. 
     * + Method inputQuantity(): to allow user input value from keyboard. 
     * + Method inputPrice(): to allow user input value from keyboard.
     * + Method checkFruit(): to check fruit exist or not. 
     * + Method addFruit(): to add fruit into the list.  
     * + Method displayAllFruits(): display on console fruit in the list.
     */
    public void createFruit() {
        boolean flag = true;    // Flag will check the loop to continue or not.
        do {    // do...while the loop will be loop when user input to continue.
            flag = false;   // Flag will be false to allow user input from keyboard.
            String fruitName = inputFruitName();    // Call method for allow user input from keyboard.
            String origin = inputOrigin();  // Call method for allow user input from keyboard.
            if (checkFruit(origin, fruitName) == true) {    // Call method to check fruit is exist or not.
                flag = true;    // Flag will be true if fruit is exit in the list, then display notification.
                System.out.println("Fruit is exist!!!");    // Notification in this situation.
            } else {    // If fruit is not exist allow user continue input from keyboard.
                int quantity = inputQuantity(); // Call method for allow user input from keyboard.
                double price = inputPrice();    // Call method for allow user input from keyboard.
                addFruit(fruitName, price, quantity, origin);   // Call method to add fruit in to the list.
                System.out.print("\nDo you want to continue create fruit (Y/N): "); // Notification for user know to input choice loop.
                String choice = inputChoice();  // Call method for allow user input from keyboard.
                if (choice.equals("Y")) {   // If choice is equal character "Y" the loop will be loop to create fruit again.
                    flag = true;    // Flag will be true to loop.
                }
                if (choice.equals("N")) {   // If choice is equal character "N" the loop will be stop and display result.
                    System.out.println("\nList of fruit:"); // Notification in this situation.
                    displayAllFruits(); // Call method displayAllFruits() to display all fruits in the list. 
                    System.out.println();
                    return; // Return to exit the loop
                }
            }
        } while (flag == true);  // The loop will be loop when flag is true.
    }

    /**
     * Method orderAndPay().
     * This method allow user select fruit and create order.
     * In this method use:
     * + Method displayAllFruits(): display on console all object in the list.
     * + Method inputFruitName(): allow user input from keyboard.
     * + Method inputOrigin(): allow user input from keyboard.
     * + Method inputQuantity(): allow user input from keyboard.
     * + Method inputChoice(): allow user input from keyboard.
     * + Method inputCustomer(): allow user input from keyboard.
     * + Method findFruit(): this method will find the fruit by fruitName and origin.
     * + Method updateQuantity(): this method will update quantity of fruit when user create order.
     * + Method checkFruitOrder(): this method will check fruit in order list is exit or not.
     * + Method getDateAndTime(): this method will get date and time to add into the order of customer.
     * + Method updateQuantityInOrder(): this method will update quantity in order when the fruit is exist.
     * + Method addOrder(): this method will allow customer add order into the list order of customer.
     * + Method displayOrderOfCustomer(): this method will display list of order fruit of customer.
     */
    public void orderAndPay() {
        this.listOrderFruit = new ArrayList<>();    // Create new ArrayList for catch fruit order of customer.
        boolean flag = true;    // Variable flag will check the loop for customer add fruit order in to the list order.
        do {    // The loop will be loop when flag is true.
            flag = false;   // Flag is false to to pause the loop and allow user input from keyboard.
            if (this.listOfFruit.isEmpty()) {   // If the list of fruit is empty display notification on console.
                System.out.println("There are no fruits in the shop!!!\n"); // Notification in this situation.
                return; // Return to break the loop.
            } else {    // If the list of fruit isn't empty allow user input from keyboard.
                System.out.println("\nList of fruit:"); // Display this notification on console for user know.
                displayAllFruits(); // This method will display on console list of fruit.
                boolean flagFruit   = true;   // Variable flagFruit will check input of user from keyboard.
                String fruitName = "";  // This variable will contain value of user input from keyboard.
                String origin = ""; // This variable will contain value of user input from keyboard.
                do {    // This loop will be loop when user input incorrect.
                    flagFruit = false;  // Variable flagFruit will be false to pause the loop for user input from keyboard.
                    fruitName = inputFruitName();   // Call method for user input from keyboard.
                    origin = inputOrigin(); // Call method for user input from keyboard.
                    if (checkFruit(origin, fruitName) == false) {   // Call method checkFruit() to check fruit is exist or not.
                        flagFruit = true;   // flagFruit will be true to display notification and allow user input again.
                        System.out.println("Fruit isn't exist!!!"); // Notification in this siyuation.
                    }
                } while (flagFruit == true);    // The loop will be loop when flagFruit is true. 
                int i = findFruit(fruitName, origin);   // Call method findFruit() to find index of the object.
                Fruit f = this.listOfFruit.get(i);  // Create object to get each value of object.
                int quantity = 0;   // This variable will be catch value from user input.
                boolean flagQuantity = true;    // flagQuantity will be check input of user.
                do {    // The loop will be loop when input of user incorrect.
                    flagQuantity = false;   // lagQuantity will be false to pause the the loop for user input from keyboard.
                    quantity = inputQuantity(); // Call method for user input from keyboard.
                    if (f.getQuantity() < quantity) {   // If quantity in the of the object less than quantity of user input display notification.
                        flagQuantity = true;    // Variable flagQuantity will be true to display notification and allow user input again.
                        System.out.println("Quantity is too big!!!");   // Notification in this situation.
                    }
                } while (flagQuantity == true); // The loop will be loop when flagQuantity is true.
                String product = f.getFruitName();  // This variable will be catch value from object.
                double price = f.getPrice();    // This variable will be catch value from object.
                String fruitOrigin = f.getOrigin(); // This variable will be catch value from object.
                double amount = f.getPrice() * quantity;    // This variable will be catch value from object.
                updateQuantity(i, quantity);    // This method will update quantity of object in the listOfFruit().
                if (checkFruitOrder(fruitName, origin) == true) {   // If checkFruitOrder() is true don't add new object, quantity will be update.
                    updateQuantityInOrder(quantity, fruitName, origin); // Call method to update quantity in listOrderFruit.
                } else {    // If checkFruitOrder() is false call method and add new object.
                    addOrder(++this.numberOfFruitInOrder, product, price, quantity, fruitOrigin, amount);   // Call method to add new object.
                }
                System.out.print("Do you want to create order now (Y/N): ");    // Display notification to ask user continue or not.
                String choice = inputChoice();  // Call method for user input from keyboard.
                if (choice.equals("N")) {   // If choice is equal character "N" allow user continue to order.
                    if (this.listOfFruit.isEmpty()) {   // If listOfFruit is empty allow user create order and break the loop.
                        System.out.println("\nThere are no fruits in the shop please enter your name to order!!!!");    // Notification in this situation.
                        displayOrderOfCustomer();   // Display on console order of customer.
                        String customerName = inputCustomerName();  // Call method inputCustomerName() allow user input from keyboard.
                        String date = getDateAndTime(); // Call method getDateAndTime() to get the date in order.
                        String customer = customerName + " " + date;    // This variable will contain name and date of order.
                        this.listOrderOfCustomer.put(customer, listOrderFruit); // Call method put() to add object into HashTable.
                        this.numberOfFruitInOrder = 0;  // Reset numberOfFruitInOrder.
                        System.out.println("Create order successfully.\n"); // Notification in this situation.
                        return; // Return to break the loop.
                    } else {    // If listOfruit isn't empty allow user continue order.
                        flag = true;    // Flag will be true to continue the loop.
                    }
                }
                if (choice.equals("Y")) {   // If choice is equal character "Y" allow  user to create order.
                    System.out.println("\nYour order here, enter your name to confirm:");   // Notification in this situation.
                    displayOrderOfCustomer();   // Display on console order of customer.
                    String customerName = inputCustomerName();  // Call method inputCustomerName() allow user input from keyboard.
                    String date = getDateAndTime(); // Call method getDateAndTime() to get the date in order.
                    String customer = customerName + " " + date;    // This variable will contain name and date of order.
                    this.listOrderOfCustomer.put(customer, listOrderFruit); // Call method put() to add object into HashTable.
                    this.numberOfFruitInOrder = 0;  // Reset numberOfFruitInOrder.
                    System.out.println("Create order successfully.\n"); // Notification in this situation.
                    return; // Return to break the loop.
                }
            }
        } while (flag == true); // The loop will be loop when flag is true.
    }

    /**
     * Method checkFruitOrde().
     * This method will check fruit in the listOrderFruit is exist or not.
     * This method use boolean type to return result.
     * In this method have parameter:
     * @param fruitName This parameter will catch value from input of user.
     * @param origin This parameter will catch value from input of user.
     * @return true when fruit is exist in the listOrderFruit, false when fruit isn't exist listOrderFruit. 
     */
    public boolean checkFruitOrder(String fruitName, String origin) {
        for (int i = 0; i < this.listOrderFruit.size(); i++) {  // The loop will be scan all object in the listOrderFruit.
            if (this.listOrderFruit.get(i).getFruitName().equals(fruitName) && this.listOrderFruit.get(i).getOrigin().equals(origin)) { // If fruit is exist in the list return true.
                return true;    // Return true in this situation.
            }
        }
        return false;   // Return false when fruit in list order isn't exist. 
    }

    /**
     * Method findFruitInOrder().
     * This method will find fruit in the listOrderFruit.
     * This method use integer type to return the result.
     * In this method have parameter:
     * @param fruitName This parameter will catch input from keyboard of user.
     * @param origin This parameter will catch input from keyboard of user.
     * @return index of the object in the listOrderFruit. 
     */
    public int findFruitInOrder(String fruitName, String origin) {
        int index = 0;  // This variable will catch index of object in the ArrayList.
        for (int i = 0; i < this.listOrderFruit.size(); i++) {  // The for loop will scan all object in the ArrayList.
            if (this.listOrderFruit.get(i).getFruitName().equals(fruitName) && this.listOrderFruit.get(i).getOrigin().equals(origin)) { // If fruit is exist in the ArrayList the variable index will be equal variable i.
                index = i;  // Variable index will equal variable i in this situation.
            }
        }
        return index;   // Return after assigning value.
    }

    /**
     * Method checkFruit().
     * This method will check fruit in the listOfFruit is exist or not.
     * This method use boolean type to return the result.
     * In this method have parameter:
     * @param origin This parameter will catch input from keyboard of user.
     * @param fruitName This parameter will catch input from keyboard of user.
     * @return true when fruit is exist, false when fruit isn't exist.
     */
    public boolean checkFruit(String origin, String fruitName) {
        for (int i = 0; i < this.listOfFruit.size(); i++) { // The loop will be scan all object of the listOfFruit.
            Fruit f = this.listOfFruit.get(i);  // Create object to get each value of the object.
            if (f.getOrigin().equals(origin) && f.getFruitName().equals(fruitName)) {   // If the fruit is exist in the listOfFruit return true.
                return true;    // Return true in this situation.
            }
        }
        return false;   // Return false when fruit is not exist.
    }

    /**
     * Method inputChoice().
     * This method will allow user input from keyboard.
     * In this method use:
     * + ReGex CHOICE_VALIDATION: this ReGex will check format input.
     * @return
     */
    public String inputChoice() {
        String choice = ""; // This varibale will catch the value of input user.
        boolean flag = true;    // Variable flag will check the loop.
        do {    // do...while will loop when user input incorrect.
            try {   // try...catch will catch exception when input of user is incorrect.
                flag = false;   // Variable flag will be false to pause the loop.
                choice = this.sc.nextLine().trim(); // Allow user input from keyboard.
                if (choice.isEmpty()) { // If input of user is empty display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Input can't be empty!!!");  // Notification in this situation.
                    System.out.print("Enter again: ");  // Notification for user input again.
                }
                if (!choice.matches(CHOICE_VALIDATION) && !choice.isEmpty()) {  // If input of user is not matches the ReGex display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Your input: " + choice + " is incorrect!!!");   // Notification in this situation.
                    System.out.print("Enter again: ");  // Notification for user input again.
                }
            } catch (Exception e) { // Catch excpetion when have throw exception.
                flag = true;    // Variable will be true to display notification and allow .
                System.out.println("Incorrect format!!!");  // Notifiacation in this situation.
            }
        } while (flag == true); // The loop will be loop when variable flag will be true.
        return choice; // Return value of variable choice.
    }

    /**
     * Method inputFruitName().
     * This method will allow user input from keyboard.
     * In this method use:
     * + ReGex FRUIT_NAME_VALIDATION: to check format user input.
     * @return  input value from input of user.
     */
    public String inputFruitName() {
        String input = "";  // This variable will catch user input from keyboard.
        boolean flag = true;    // Variable flag will be check the loop.
        do {    // do...while will loop when input of user is incorrect.
            try {   // try...catch to catch exception when user input incorrect.
                flag = false;   // The flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter name of fruit: ");  // Notify the user to enter from the keyboard.
                input = this.sc.nextLine().trim();  // Allow user input from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Variable will be true to display notification and allow user input again.
                    System.out.println("Name of fruit can't be empty!!!");  // Notification in this situation.
                }
                if (!input.matches(FRUIT_NAME_VALIDATION)) {    // If input of user isn't matches to ReGex display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Name of fruit is incorrect!!!");    // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception when have throw exception.
                flag = true;    // Variable will be true to display notification and allow user input again.
                System.out.println("Input format incorrect!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when variable flag will be true.
        return input.toLowerCase(); // Call method toLowerCase() to lower case all input of user.
    }

    /**
     * Method inputPrice().
     * This method will allow user input from keyboard.
     * @return input value from input of user.
     */
    public double inputPrice() {
        String input = "";  // This variable will catch value from input of user.
        boolean flag = true;    // Variable flag will be check the loop.
        do {    // do...while will loop when user input incorrect.
            try {   // try...catch to catch exception when input from user incorrect.
                flag = false;   // Variable flag will be false to pause the loop and allow user input from keyboard.
                System.out.print("Enter price of fruit: "); // Notify the user to enter from the keyboard.
                input = this.sc.nextLine().trim();  // Allow user input from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification. 
                    flag = true;    // Variable flag will be true to display notificaton and allow user input again.
                    System.out.println("Price of fruit can't be empty!!!"); // Notification in this situation.
                }
                if (Double.parseDouble(input) <= 0.0) { // If input of user less than zero.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Price must be greater than zero!!!");   // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception when have throw exception.
                if (!input.isEmpty()) { // If input of user isn't empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Don't allow alphabet and chacracter!!!");   // Notification in this situation.
                }
            }
        } while (flag == true); // The loop will be loop when variable flag is true.
        return Double.parseDouble(input);   // Return value from input of user.
    }

    /**
     * Method inputQuantity().
     * This method allow user input from keyboard.
     * @return input value from input of user keyboard.
     */
    public int inputQuantity() {
        String input = "";  // This variable will contain the value from input of user.
        boolean flag = true;    // Variable flag will check the loop.
        do {    // do...while loop will loop when input from user keyboard is incorrect.
            try {   // try..catch will catch exception when input of user is incorrect.
                flag = false;   // Variable flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter quantily of fruit: ");  // Notify the user to enter from the keyboard.
                input = this.sc.nextLine().trim();  // Allow user input from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Quantity of fruit can't be empty!!!");  // Notification in this situation.
                }
                if (Integer.parseInt(input) <= 0) { // If input of user less than zero display notification.
                    flag = true;    // Flag will be true to display notification and allow user input again.
                    System.out.println("Quantity must be greater than zero!!!");    // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception when have throw exception.
                if (!input.isEmpty()) { // If input of user isn't empty display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Don't allow alphabet and chacracter!!!");   // Notification in this situation.
                }
            }
        } while (flag == true); // The loop will be loop when variable flag is true.
        return Integer.parseInt(input); // Return value from input of user.
    }

    /**
     * Method inputOrigin().
     * This method will allow user input from keyboard.
     * In this method use:
     * + ReGex ORIGIN_VALIDATION: to check format user input.
     * @return input value from input of user keyboard.
     */
    public String inputOrigin() {
        String input = "";  // This variable will contain value input of user from keyboard.
        boolean flag = true;    // This variable flag will check the loop.
        do {    // do...while loop will loop when input of user incorrect.
            try {   // try...catch exception when input of user throw exception.
                flag = false;   // Variable flag will be false to pause the loop for user input from keyboard.
                System.out.print("Enter origin of fruit: ");    // Notify for user input from keyboard.
                input = this.sc.nextLine().trim();  // Allow user input from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Origin of fruit can't be empty!!!");    // Notification in this situation.
                }
                if (!input.matches(ORIGIN_VALIDATION)) {    // If the user input from the keyboard does not match the regex.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Origin of fruit is incorrect!!!");  // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception when have throw exception.
                flag = true;    // Variable flag will be true to display notification and allow user input again.
                System.out.println("Input format incorrect!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when variable flag is true.
        return input.toLowerCase(); // Return value from input of user.
    }

    /**
     * Method inputCustomerName().
     * This method will allow user input from keyboard.
     * In this method use:
     * + ReGex NAME_VALIDATION: to check format from input of user.
     * @return  input value from input of user keyboard.
     */
    public String inputCustomerName() {
        String input = "";  // This variable will contain value input of user from keyboard.
        boolean flag = true;    // Variable flag will check the loop.
        do {    // do...while loop will be loop when user input incorrect.
            try {   // try...catch exception when user input throw exception.
                flag = false;   // Variable flag will be false to pause the loop for user input.
                System.out.print("Enter your name: ");  // Notify for user input from keyboard.
                input = this.sc.nextLine().trim();  // Allow user input from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Variable flag will true to display notification and allow user input again.
                    System.out.println("Your name can't be empty!!!");  // Notification in this situation.
                }
                if (!input.matches(NAME_VALIDATION)) {  // If the user input from the keyboard does not match the regex.
                    flag = true;    // Variable flag will be true to display notification and allow user input again.
                    System.out.println("Your name: " + input + " is incorrect!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception when have throw exception.
                flag = true;    // Variable flag will be true to display notification and allow user input again.
                System.out.println("Input format incorrect!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when variable flag is true.
        return input.toLowerCase(); // Return value from input of user.
    }
}

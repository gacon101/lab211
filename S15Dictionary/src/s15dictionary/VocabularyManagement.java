/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s15dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author trong
 */
public class VocabularyManagement {

    private ArrayList<Vocabulary> listVocabulary;
    private HashMap<String, String> dictionary;
    private int numberOfVocabulary;
    private String DICTIONARY_FILE;
    private final String VOCABULARY_VALIDATION = "^[A-Za-z\\s]{1,20}$";
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor for main driver using. In this method have parameter.
     *
     * @param DICTIONARY_FILE This parameter will catch the name of file for
     * load and save.
     */
    public VocabularyManagement(String DICTIONARY_FILE) {
        this.numberOfVocabulary = 0;
        this.DICTIONARY_FILE = DICTIONARY_FILE;
        this.listVocabulary = new ArrayList<>();
        this.dictionary = new HashMap<>();
    }

    /**
     * Method addVocabulary(). This method will be add new vocabulary into the
     * list. In this method have parameter.
     *
     * @param en This parameter will be catch the value input of user.
     * @param vn This parameter will be catch the value input of user.
     * @return ++numberOfVocabulary This return will be count number of word in
     * the dictionary.
     */
    public int addVocabulary(String en, String vn) {
        this.listVocabulary.add(new Vocabulary(en, vn));
        return ++this.numberOfVocabulary;
    }

    /**
     * Method loadDictionaryFile(). This method will load data file for system.
     * This method will read file data and add data from file to listOfUser. In
     * this method use: + Method exist(): to check file is exist or not. +
     * Method createNewFile(): to create file if file not exist in the system. +
     * Object BufferedReader: will read data in file data. + Method sleep: will
     * delay program.
     *
     * @throws IOException This exception will throw when IO system crash.
     * @throws InterruptedException This exception will throw when system
     * interrupt crash.
     */
    public void loadDictionaryFile() throws IOException, InterruptedException {
        File f = new File(this.DICTIONARY_FILE);  // Object file will create to scan file data.
        if (!f.exists()) {  // If file is not exist in the system show notifcation and create new file data.
            f.createNewFile();  // Call method from object File to create new file.
            System.out.printf("The data file " + this.DICTIONARY_FILE + " is not exits. "
                    + "Creating new data file " + this.DICTIONARY_FILE + "...");  // Notification in this situation.
            Thread.sleep(3000); // Call method to create interrupt.
            System.out.print(" Done!"); // Show this notification in after in terrupt.
        } else {    // If file is exist in the system show notification and read file.
            System.out.printf("The data file " + this.DICTIONARY_FILE + " is found. "
                    + "Data of user is loading...");    // Notification in this situation.
            String English;    // This variable will catch data after read file.
            String Vietnamese;    // This variable will catch data after read file.
            try (BufferedReader br = new BufferedReader(new FileReader(this.DICTIONARY_FILE))) {  // try...catch BufferedReader to catch exception
                this.numberOfVocabulary = Integer.parseInt(br.readLine()); // Read number of users to create the loop for scan all data in file data.
                for (int i = 0; i < this.numberOfVocabulary; i++) {   // This loop will scan data in file data.
                    English = br.readLine();   // Read data and give data for variable.
                    Vietnamese = br.readLine();   // Read data and give data for variable.
                    this.listVocabulary.add(new Vocabulary(English, Vietnamese));  // Add data to the listOfUser.
                    this.dictionary.put(English, Vietnamese);   // Put data to the dictionary.
                }
                Thread.sleep(3000); // Create interrupt.
                System.out.print(" Done!"); // Display notification
            } catch (Exception e) { // Catch exception if system throw exception.
                Thread.sleep(3000); // Create interrupt.
                System.out.print(" Done!"); // Display notification.
                System.out.print("\nFile " + this.DICTIONARY_FILE + " is empty data choose option 1 to add new word."); // Display notification.
            }
        }
    }

    /**
     * Method saveDictionaryFile(). This method will save data in to file data
     * of system. This method will scan the listOfUser and write data in to file
     * data of system. In this method use: + Object FileWriter: to scan file
     * data and write data. + Method append(): will write data into file data. +
     * Method sleep: will delay program. + Method close(): will stop write file
     * data.
     *
     * @throws IOException This exception will throw when IO system crash.
     * @throws InterruptedException This exception will throw when system
     * interrupt crash.
     */
    public void saveDictionaryFile() throws IOException, InterruptedException {
        FileWriter fw = new FileWriter(DICTIONARY_FILE);  // Create FileWriter to write data into file data.
        try {   // try...catch to catch exception system.
            System.out.print("Dictionary word is saving into data file " + this.DICTIONARY_FILE + "... ");    // Display notification.
            fw.append(String.valueOf(this.numberOfVocabulary) + "\n");    // Write number of user into file data.
            for (int i = 0; i < this.numberOfVocabulary; i++) {   // The loop will scan number of user before write data.
                Vocabulary v = this.listVocabulary.get(i);    //  Create object to get each data in listOfUser.

                String English = v.getEn().substring(0, 1).toUpperCase() + v.getEn().substring(1).toLowerCase();  // Get data.
                String Vietnamese = v.getVn().substring(0, 1).toUpperCase() + v.getVn().substring(1).toLowerCase();  // Get data .

                fw.append(English + "\n"); // Write data into the file data after get data.
                fw.append(Vietnamese + "\n"); // Write data into the file data after get data.
            }
        } finally {
            fw.close(); // Stop write data.
            if (this.numberOfVocabulary > 1) {    // If number of user greater than 1 display notification.
                Thread.sleep(3000); // Create interrupt.
                System.out.println("Done! [" + this.numberOfVocabulary + " words]");   // Notification in this situation.
            } else {    // If number of user less than 1 display notification.
                Thread.sleep(3000); //Create interrupt.
                System.out.println("Done! [" + this.numberOfVocabulary + " word]");    // Notification in this situation.
            }
        }
    }

    /**
     * Method putVocabularyToDictionary(). This method will use HashMap to
     * processing all data in the ArrayList. In this method will use: + Method
     * put(): to put data from ArrayList to HashMap.
     */
    public void putVocabularyToDictionary() {
        for (int i = 0; i < this.listVocabulary.size(); i++) {  // The loop will be scan data in ArrayList.
            Vocabulary v = this.listVocabulary.get(i);  // Create object to get each data of object.
            String en = v.getEn();  // This variable wil contain value of Enlish attribute.
            String vn = v.getVn();  // This variable will contain value of Vietnamese attribute
            this.dictionary.put(en, vn);    // Method put will put all value of object into the HashMap.
        }
        System.out.println("Add new word successfully.");   // Notification after put.
    }

    /**
     * Method deleteVocabulay(). This method will delete object in ArrayList. In
     * this method use: + Method findEngLishVocabulary(): This method will be
     * find English vocabulary by input of user. + Method remove(): This method
     * will be remove object in the ArrayList.
     *
     * @param removeInput This parameter will be contain input of user from
     * keyboard.
     */
    public void deleteVocabulary(String removeInput) {
        int i = findEnglishVocabulary(removeInput); // Call method to find object.
        this.listVocabulary.remove(findEnglishVocabulary(removeInput)); // Firstly remove object in the ArrayList.
        --this.numberOfVocabulary;  // Reconount number of vocabulary.
    }

    /**
     * Method deleteWord(). This method will delete the vocabulary in the
     * dictionary. In this method use: + Method findEnglish(): to find the value
     * from input user.
     *
     * @param removeInput This parameter will catch input of user from keyboard.
     */
    public void deleteWord(String removeInput) {
        String i = findEngLish(removeInput);    // Call method findEnglish() to find vocabulary.
        this.dictionary.remove(i);  // Use method remove to remove object from HashMap.
        System.out.println((i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase()) + " vocabulary has been removed from the dictionary."); // Notification after delete.
    }

    /**
     * Method displayDictionary(). This method will be display all object in
     * HashMap.
     */
    public void displayDictionary() {
        System.out.println("Number of word: " + this.numberOfVocabulary);   // Display number of vocabulary.
        System.out.println("+--------------------+--------------------+");  // Display header of the table.
        System.out.println("|Enlish              |Vietnamese          |");  // Display name of collum.
        System.out.println("+--------------------+--------------------+");  // Display header of the table.
        for (Map.Entry<String, String> entry : dictionary.entrySet()) { // The loop will scan all object in the HashMap.
            String key = entry.getKey();  // This variable will contain the value of key in the HashMap.
            String value = entry.getValue();    // This variable will contain the value of key value in the HashMap.
            System.out.printf("|%-20s|%-20s|\n",
                    key.substring(0, 1).toUpperCase() + entry.getKey().substring(1).toLowerCase(),
                    value.substring(0, 1).toUpperCase() + entry.getValue().substring(1).toLowerCase());   // Display all object in the HashMap on console.
        }
        System.out.println("+--------------------+--------------------+");  // The footer of the table.
    }

    /**
     * Method displayDictionary(). This method is overloading from method
     * displayDictionary() (the method above this method). This method use
     * HashMap to display data.
     *
     * @param inputTranlate input of user to translate.
     */
    public void displayDictionary(String inputTranlate) {
        System.out.println("+--------------------+--------------------+");  // Display header of table.
        System.out.println("|Enlish              |Vietnamese          |");  // Display name of collum.
        System.out.println("+--------------------+--------------------+");  // Display header of table.
        for (Map.Entry<String, String> entry : dictionary.entrySet()) { // The loop will scan all object in HashMap.
            String key = entry.getKey();  // This variable will get value in HashMap.
            String value = entry.getValue();    // This variable will get value in HashMap.
            if (key.contains(inputTranlate)) {  // If input of user equal key in HashMap display object on console.

                System.out.printf("|%-20s|%-20s|\n",
                        key.substring(0, 1).toUpperCase() + entry.getKey().substring(1).toLowerCase(),
                        value.substring(0, 1).toUpperCase() + entry.getValue().substring(1).toLowerCase());   // Display object on console.
            }
        }
        System.out.println("+--------------------+--------------------+");  // Display footer of table.
    }

    /**
     * Method checkVocabulary(). This method will check vocabulary from input
     * user is exist or not. This method use boolean type to return the result.
     *
     * @param input This parameter will get input of user from keyboard.
     * @return true when input of user is exist, false when input of user is not
     * exist.
     */
    public boolean checkVocabulary(String input) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) { // The loop will be scan all object in the HashMap.
            String key = entry.getKey();    // This variable will contain value of the key.
            String value = entry.getValue();    // This variable will contain value of the value.
            if (input.equalsIgnoreCase(key) || input.equalsIgnoreCase(value)) { // If key or value equal input return true.
                return true;    // Return in this situation.
            }
        }
        return false;   // Retrun false when key or value is not exist in the HashMap.
    }

    /**
     * Method findEnglishVocabulary(). This method will be find vocabulary in
     * dictionary. This method use integer type to return the result.
     *
     * @param removeInput This parameter will get value from input user.
     * @return i when vocabulary is exist, -1 when vocabulary is not exist.
     */
    public int findEnglishVocabulary(String removeInput) {
        int index = 0;
        for (int i = 0; i < this.listVocabulary.size(); i++) {  // The loop will be scan all object in the ArrayList.
            Vocabulary v = this.listVocabulary.get(i);  // Create object to get each object in the ArrayList.
            if (removeInput.equals(v.getEn())) {  // If input from user equal object in the ArrayList return index of object.
                index = i;   // Return in this situation.
            }
        }
        return index;  // Return -1 when object is not exist in the ArrayList.
    }

    /**
     * Method findEnglish(). This method will find vocabulary in the HashMap.
     * This method use String type to return the result.
     *
     * @param removeInput This parameter will catch value from input of user.
     * @return key in HashMap when vocabulary is exist, empty String when key in
     * HashMap is not exist.
     */
    public String findEngLish(String removeInput) {
        String word = null;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) { // The loop will scan all object in the HashMap.
            String key = entry.getKey();    // This variable will get key in the HashMap.
            String value = entry.getValue();    // This variable will gey value in the HashMap.
            if (key.equals(removeInput)) { // If the key is equal the input from user return that key.
                word = key; // Return in this situation.
            }
        }
        return word;  // Return empty String when key is not exist in the HashMap. 
    }

    /**
     * checkVietnamese(). This method check input of user. If user enter
     * Vietnamese in field English.
     *
     * @param input This parameter will catch input of user.
     * @return true when input of user is Vietnamese, false when input of user
     * is English.
     */
    public boolean checkVietnamese(String input) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) { // The loop will scan all words in the HashMap.
            String key = entry.getKey();    // This variable will contain data of key.
            String value = entry.getValue();    // This variable will contain data of value.  
            if (input.equalsIgnoreCase(value)) {  // If input of user equal variable value return true.
                return true;    // Return in this situation.
            }
        }
        return false;   // Return false when input of user not equal variable value.
    }

    /**
     * Method checkVocabularyList(). This method will check the ArrayList is
     * empty or not. This method use boolean type to return the result.
     *
     * @return true when the ArrayList is empty, false when the ArrayList is not
     * empty.
     */
    public boolean checkVocabularyList() {
        return this.listVocabulary.isEmpty() || this.numberOfVocabulary == 0;   // Return true when the ArrayList is empty, false when the ArrayList is not empty.
    }

    /**
     * Method checkDictionary(). This method will check the HashMap is empty or
     * not. This method use boolean type to return the result.
     *
     * @return true when the HashMap is empty, false when the HashMap is not
     * empty.
     */
    public boolean checkDictionary() {
        return this.dictionary.isEmpty();   // Return true when the HashMap is empty, false when the HashMap is not empty.
    }

    /**
     * Method inputFindString(). This method will allow user input from
     * keyboard. This method use String type to return the result. In this
     * method will use: + Method isEmpty(): to check the input of user is empty
     * or not. + ReGex VOCABULARY_VALIDATION: to check format of user input. +
     * Method matches(): to check input of user is correct format or not. +
     * Method checkVocabulary(): to check input of user is exist or not.
     *
     * @return input The value of user input from keyboard.
     */
    public String inputFindString() {
        String input = null;  // This variable will catch the input of user from keyboard.
        boolean flag = true;    // Flag will check the loop when input user incorrect.
        do {    // do...while the loop will loop when input of user is incorrect.
            try {   // try...catch to catch the exception when input of user is incorrect.
                flag = false;   // Flag will be false for user input from keyboard.
                System.out.print("Enter Enlish: "); //Notification for user know to input from keyboard.
                input = this.sc.nextLine().trim();  // Scanner input of user from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Don't accept empty input!!!");  // Notification in this situation.
                }
                if (!input.matches(VOCABULARY_VALIDATION)) {    // If input of user is not matches the ReGex display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Input incorrect format!!!");    // Notification in this situation.
                }
                if (checkVietnamese(input) == true) {   // If method checkVietnamese equal true display notification.
                    flag = true;    // Variable flag will be true for allow user input again.
                    System.out.println("You should search english to find you words!!!"); // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will bew true to display notification and allow user input from keyboard again.
                System.out.println("Input fail!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return input.toLowerCase();   // Return input of user from keyboard.
    }

    /**
     * Method inputStringEN(). This method will allow user input from keyboard.
     * This method use String type to return the result. In this method will
     * use: + Method isEmpty(): to check the input of user is empty or not. +
     * ReGex VOCABULARY_VALIDATION: to check format of user input. + Method
     * matches(): to check input of user is correct format or not. + Method
     * checkVocabulary(): to check input of user is exist or not.
     *
     * @return input the value of user from keyboard.
     */
    public String inputStringEN() {
        String input = null;  // This variable will catch the input of user from keyboard.
        boolean flag = true;    // Flag will check the loop when input user incorrect.
        do {    // do...while the loop will loop when input of user is incorrect.
            try {   // try...catch to catch the exception when input of user is incorrect.
                flag = false;   // Flag will be false for user input from keyboard.
                System.out.print("Enter Enlish: "); //Notification for user know to input from keyboard.
                input = this.sc.nextLine().trim();  // Scanner input of user from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Don't accept empty input!!!");  // Notification in this situation.
                }
                if (!input.matches(VOCABULARY_VALIDATION)) {    // If input of user is not matches the ReGex display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Input incorrect format!!!");    // Notification in this situation.
                }
                if (checkVocabulary(input) == true) {    // If method checkVocabulary() equal true display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase() + " is exit in the dictionary!!!");    // Notification in this situation.
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will bew true to display notification and allow user input from keyboard again.
                System.out.println("Input fail!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return input.toLowerCase();   // Return input of user from keyboard.
    }

    /**
     * Method inputStringVN(). This method will allow user input from keyboard.
     * This method use String type to return the result. In this method will
     * use: + Method isEmpty(): to check the input of user is empty or not. +
     * ReGex VOCABULARY_VALIDATION: to check format of user input. + Method
     * matches(): to check input of user is correct format or not. + Method
     * checkVocabulary(): to check input of user is exist or not.
     *
     * @return input The value of user input from keyboard.
     */
    public String inputStringVN() {
        String input = null;  // This variable will catch the input of user from keyboard.
        boolean flag = true;    // Flag will check the loop when input user incorrect.
        do {    // do...while the loop will loop when input of user is incorrect.
            try {   // try...catch to catch the exception when input of user is incorrect.
                flag = false;   // Flag will be false for user input from keyboard.
                System.out.print("Enter Vietnamese: "); //Notification for user know to input from keyboard.
                input = this.sc.nextLine().trim();  // Scanner input of user from keyboard.
                if (input.isEmpty()) {  // If input of user is empty display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Don't accept empty input!!!");  // Notification in this situation.
                }
                if (!input.matches(VOCABULARY_VALIDATION)) {    // If input of user is not matches the ReGex display notification.
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println("Input incorrect format!!!");    // Notification in this situation.
                }
                if (checkVocabulary(input) == true) {
                    flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                    System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase() + " is exit in the dictionary!!!");
                }
            } catch (Exception e) { // Catch exception if have throw exception.
                flag = true;    // Flag will be true to display notification and allow user input from keyboard again.
                System.out.println("Input fail!!!");    // Notification in this situation.
            }
        } while (flag == true); // The loop will be loop when flag is true.
        return input.toLowerCase();   // Return input of user from keyboard.
    }
}

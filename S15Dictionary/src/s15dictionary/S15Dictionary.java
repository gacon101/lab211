/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s15dictionary;

import java.util.Scanner;

/**
 * Main driver for using class VocabularyManagement().
 *
 * @author trong
 */
public class S15Dictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {   // try...catch to catch exception when program have exception.
            String FILE = "Dictionary.dat";   // File for save and load data in this system.
            Scanner sc = new Scanner(System.in);    // Create Scanner for user input from keyboard.
            VocabularyManagement vm = new VocabularyManagement(FILE);  // Create object.
            vm.loadDictionaryFile();  // Load data file of this system.
            String choice = ""; // This variable will catch input from keyboard of user.
            boolean flag = true;    // Flag will check the loop when user input incorrect.
            do {    // do...while will loop when input of user is incorrect.
                System.out.println();
                System.out.println("   WORKER MANAGEMENT");
                System.out.println("1. Add new word.");
                System.out.println("2. Delete word.");
                System.out.println("3. Search word.");
                System.out.println("4. Exit.");
                do {    // do...while will loop when input of user is incorrect.
                    try {   // try...catch exception when input of user is incorrect.
                        flag = false;   // Flag will be false to pause the loop and allow user input from keyboard.
                        System.out.print("   Please choose: "); // Notification for user know to input from keyboard.
                        choice = sc.nextLine(); // Scanner input user from keyboard.
                        if (choice.isEmpty()) { // If input of user is empty display notification.
                            flag = true;    // Flag will be true to display notification and allow user input again.
                            System.out.println("Don't allow empty input!!!");   // Notification in this situation.
                        }
                        if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) >= 5) {   // If input of user over the range display notification.
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
                    case 1: // Case 1 feature Add new word.
                        String en = vm.inputStringEN();
                        String vn = vm.inputStringVN();
                        vm.addVocabulary(en, vn);
                        vm.putVocabularyToDictionary();
                        break;
                    case 2: // Case 2 feature Delete word.
                        if (vm.checkVocabularyList() == true) {
                            System.out.println("Dictionary is empty!!!");
                        } else {
                            vm.displayDictionary();
                            String removeInput = vm.inputFindString();
                            vm.deleteVocabulary(removeInput);
                            vm.deleteWord(removeInput);
                            if (vm.checkDictionary() == true) {
                                System.out.println("Dictionary is empty!!!");
                            } else {
                                vm.displayDictionary();
                            }
                        }
                        break;

                    case 3: // Case 3 feature Search word.
                        if (vm.checkDictionary() == true) {
                            System.out.println("Dictionary is empty!!!");
                        } else {
                            String inputTranlate = vm.inputFindString();
                            vm.displayDictionary(inputTranlate);
                        }
                        break;
                    case 4: // Case 4 feature Exit.
                        vm.saveDictionaryFile();
                        System.out.println("Thank's for using software. See you again."); // Notification when exit application.
                        System.out.println();
                        System.exit(0); // Call Method system to exit program.
                        break;
                }
            } while (Integer.parseInt(choice) != 5);    // The loop will be loop if choice difference 6.
        } catch (Exception e) { // Catch exception if have throw exception.
            System.out.println(e.getMessage()); // Display exception.
        }
    }

}

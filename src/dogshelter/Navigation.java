/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogshelter;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mondi
 */

public class Navigation {
    private static int swValue;
    //Set and reset colors
    private static final String COLOR_GREEN = "\033[32m";
    private static final String COLOR_RED = "\033[31m";
    private static final String COLOR_RESET = "\033[0m";
    private static boolean hasManager = false;
    private static int selection;
    
    //System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
    //System.out.println("\033[31mRed\033[32m, Green\033[33m, Yellow\033[34m, Blue\033[0m");
    
    private static ShelterManager manager;
    public static void selectionMenu(){
        
        //Check if a shelter manager is created and create one if it is not
        if(!hasManager){
            manager = new ShelterManager();
            hasManager = true;
        }
        
        System.out.println(COLOR_GREEN+"|============= [MENU] ================|"+COLOR_RESET);
        System.out.println("|        1. Add dog                   |");
        System.out.println("|        2. View all dogs             |");
        System.out.println("|        3. View all available dogs   |");
        System.out.println("|        4. View a dog                |");
        System.out.println("|        5. Update dog  home status   |");
        System.out.println("|        6. Exit                      |");
        swValue = Keyin.inInt(" Select option: ");

        // Switch construct
        switch (swValue) {
        case 1:
            manager.addDog();
            System.out.println();
            try{
            TimeUnit.MILLISECONDS.sleep(1200);
            }catch(Exception e){
            }
            selection();
            break;
        case 2:
            manager.viewAllDogs();
            System.out.println();
            try{
            TimeUnit.MILLISECONDS.sleep(1200);
            }catch(Exception e){
            }
            selection();
            break;
        case 3:
            manager.viewAvailableDogs();
            System.out.println();
            try{
            TimeUnit.MILLISECONDS.sleep(1200);
            }catch(Exception e){
            }
            selection();
            break;
        case 4:
            manager.viewDog();
            System.out.println();
            try{
            TimeUnit.MILLISECONDS.sleep(1200);
            }catch(Exception e){
            }
            selection();
            break;
        case 5:
            manager.updateHomeStatus();
            System.out.println();
            try{
            TimeUnit.MILLISECONDS.sleep(1200);
            }catch(Exception e){
            }
            selection();
            break;
        case 6:
            System.exit(0);
            break;
        default:
            System.out.println(COLOR_RED+"Invalid selection!"+COLOR_RESET);
            System.out.println();
            selection();
            break;
        }
    }
    
    //Use selection to return to the menu or exit
    public static void selection(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1 to continue to the menu; 0 to exit the program: ");
        
        String Selection = input.nextLine();
        
        while(!DataValidator.isSelectionCorrect(Selection)){
            System.out.print(COLOR_RED+"Invalid Selection!  Enter 1 to continue to the menu; 0 to exit the program: "+COLOR_RESET); 
            input = new Scanner(System.in);
            Selection = input.next();
        }
        selection = Integer.parseInt(Selection);
        if(selection == 1){
            Navigation.selectionMenu();
        }else if(selection == 0){
            System.exit(0);
        }  
    }
}

class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    
    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }
  
  //Method to 
  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }
      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  } 
}


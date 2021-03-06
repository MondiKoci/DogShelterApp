/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogshelter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Mondi
 */
public class ShelterManager {
    private static int id = 1;
    private static String name;
    private static double age = -1;
    private static String breed;
    private static char sex;
    private static boolean foundHome = false;
    private static ArrayList<Dog> dogList;
    
    private static Scanner input = new Scanner(System.in);
    //Static field for searching dog ID
    private static String dogId;
    
    //Initialize a ShelterManager object and an ArrayList to store all dog objects
    public ShelterManager(){
        dogList = new ArrayList<Dog>();
    }
    
    //==============ADD DOG METHOD============================
    //Get user data to create and store a dog object
    public static void addDog(){
        System.out.println();
                
        System.out.println("============Enter Dog information=============");
        System.out.println(COLOR_RED + "Note! Dog ID is generated automatically by the system!\n" + COLOR_RESET);
        //=======================Get name=============================
        System.out.print("Please enter the name: ");
        input = new Scanner(System.in);
        name = input.nextLine();
        while(!DataValidator.isStringOnlyAlphabet(name)){
            System.out.print(COLOR_RED+"Please enter a valid name (use only alphabetic characters): "+COLOR_RESET);
            name = input.nextLine(); //Store the valid name
        }
        
        //====================Get age=================================
        input = new Scanner(System.in);
        System.out.print("Please enter age (between 0 and 25): ");
        String Age = input.nextLine();
        
        while(!DataValidator.isAgeInRange(Age)){
            System.out.print(COLOR_RED+"Please enter a valid age (between 0 - 25): "+COLOR_RESET); 
            input = new Scanner(System.in);
            Age = input.next();
        }
        age = Double.parseDouble(Age); //Store the valid age
        
        //====================Get breed===============================
        System.out.print("Enter breed: ");
        breed = input.next();
        while(!DataValidator.isStringOnlyAlphabet(breed)){
            System.out.print(COLOR_RED+"Enter breed (only alphabetic characters allowed): "+COLOR_RESET);
            breed = input.next();
        }
        
        //====================Get sex=================================
        System.out.print("Enter sex (F for female, M for male): ");
        sex = input.next().charAt(0);
        while(!DataValidator.isSexChar(sex)){
            System.out.print(COLOR_RED+"Please enter correct sex (F for female, M for male): "+COLOR_RESET);
            sex = input.next().charAt(0);
        }
        Dog temp = new Dog(id, name, age, breed, sex, foundHome);
        dogList.add(temp);
        
        System.out.println(COLOR_GREEN+"SUCCESS! Dog added in the system!"+COLOR_RESET);       
    }
    
    //*******************************
    //   support methods
    //*******************************    
    //View a dog using a dog id
    public static void viewDog(){
        System.out.print("Search for dog using a dog id: ");
        input = new Scanner(System.in);
        dogId = input.next();
        int Dogid;
        while(!DataValidator.isIdCorrect(dogId)){
            System.out.println(COLOR_RED+"Incorrect entry: Please enter a correct id (e.g 1): "+COLOR_RESET);
            dogId = input.next();
        }
        Dogid = Integer.parseInt((dogId));
        if(dogList.size() > 0){
            for (int i = 0; i < dogList.size(); i++) {
                if(searchDog(Dogid) != null){
                    System.out.println(COLOR_GREEN + "ID\t\tName\t\tAge\t\t"
                    + "Breed\t\tSex\t\tFound Home" + COLOR_RESET);
                    System.out.println(searchDog(Dogid));
                }else{
                    System.out.println(COLOR_RED+"There is not dog with that id!"+COLOR_RESET);
                }
            }
        }else{
            System.out.println(COLOR_RED+"There are no dogs in the system yet!"+COLOR_RESET);
        }  
    }
    
    //Adopt a dog
    //View a dog using a dog id
    public static void updateHomeStatus(){
        System.out.print("Enter the ID of the dog to be adopted: ");
        input = new Scanner(System.in);
        dogId = input.next();
        int Dogid;
        while(!DataValidator.isIdCorrect(dogId)){
            System.out.println(COLOR_RED+"Incorrect entry: Please enter a correct id (e.g 1): "+COLOR_RESET);
            dogId = input.next();
        }
        Dogid = Integer.parseInt((dogId));
        if(dogList.size() > 0){
            for (int i = 0; i < dogList.size(); i++) {
                if(searchDog(Dogid) != null){
                    if(!searchDog(Dogid).isFoundHome()){
                        System.out.println();
                        System.out.println(COLOR_RED + "ID\t\tName\t\tAge\t\t"
                        + "Breed\t\tSex\t\tFound Home" + COLOR_RESET);
                        searchDog(Dogid).setFoundHome(true);
                        System.out.println(searchDog(Dogid));
                        System.out.println();
                        System.out.println(COLOR_GREEN+"Home status for dog with ID ("+ Dogid+") successfully updated!"+COLOR_RESET);
                    }else{
                        System.out.println(COLOR_RED+"The dog with id ("+Dogid+") is already adopted!"+COLOR_RESET);
                    }
                }else{
                    System.out.println(COLOR_RED+"There is not dog with that id!"+COLOR_RESET);
                }
            }
        }else{
            System.out.println(COLOR_RED+"There are no dogs in the system yet!"+COLOR_RESET);
        }  
    }
            
    //Search a dog; return dog object if found
    private static Dog searchDog(int id){
        Dog temp = null;
        for (int i = 0; i < dogList.size(); i++) {
            if(dogList.get(i).getDogId() == id){
                temp = dogList.get(i);
            }
        }
        return temp;
    }
    
    //View all dogs registered in the system
    public static void viewAllDogs(){
        if(dogList.size() > 0){
            System.out.println(COLOR_GREEN + "ID\t\tName\t\tAge\t\t"
                    + "Breed\t\tSex\t\tFound Home" + COLOR_RESET);
            for (int i = 0; i < dogList.size(); i++) {
                System.out.println(dogList.get(i));
            }
        }else{
            System.out.println(COLOR_RED+"There are no dogs in the system yet!"+COLOR_RESET);
        }
    }
    
    //View only dogs available for adoption
    public void viewAvailableDogs(){
        if(dogList.size() > 0){
            System.out.println(COLOR_GREEN + "ID\t\tName\t\tAge\t\t"
                    + "Breed\t\tSex\t\tFound Home" + COLOR_RESET);
            for (int i = 0; i < dogList.size(); i++) {
                if(!dogList.get(i).isFoundHome()){
                    System.out.println(dogList.get(i));
                }else{
                    continue;
                }
            }
        }else{
            System.out.println(COLOR_RED+"There are no dogs in the system yet!"+COLOR_RESET);
        }
    }
    
    //Set and reset colors
    private static final String COLOR_GREEN = "\u001B[32;9m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_RESET = "\u001B[0m";
}

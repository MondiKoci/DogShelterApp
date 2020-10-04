/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogshelter;

/**
 *
 * @author Mondi
 */
public class ShelterManager {
    private int numDogs;
    private int maxNumDogs;
    private Dog[] dogsList;
    
    public ShelterManager(int max){
        numDogs = 0;
        maxNumDogs = max;
        dogsList = new Dog[maxNumDogs];
    }
    
    //Main ShelterManager (list constructor) constructor
    public void addDog(int id, String name, int age, String breed, char sex, boolean foundHome){
        if(numDogs < maxNumDogs){
            dogsList[numDogs] = new Dog(id, name, age, breed, sex, foundHome);
            numDogs++;
        }
    }
    //Check if id already exists
    private boolean checkId(int id){
        for (int i = 0; i < numDogs; i++) {
            if(dogsList[i].getDogId() == id){
                return true;
            }
        }
        return false;
    }
    //Search a dog; return dog object if found
    public Dog searchDog(int id){
        Dog temp = null;
        for (int i = 0; i < numDogs; i++) {
            if(dogsList[i].getDogId() == id){
                temp = dogsList[i];
            }
        }
        return temp;
    }
    
    //View all dogs registered in the system
    public void viewAllDogs(){ 
        System.out.println(COLOR_RED + "ID\t\tName\t\tAge\t\tBreed\t\tSex\t\tFound Home" + COLOR_RESET);
        for (int i = 0; i < numDogs; i++) {
            System.out.println(dogsList[i]);
        }
    }
    
    //Update a dog's home status to adopted
    public void adoptDog(int id){
        Dog temp = searchDog(id);
        if(temp != null){
            temp.setFoundHome(true);
        }else{
            System.out.println("No dog was found with that ID!");
        }
    }
    
    //View only dogs available for adoption
    public void viewAvailableDogs(){
        
    }
    
    
    //Set and reset colors
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";
    
}

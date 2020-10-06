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

public class Dog {
    private static int dogId; // Must be unique
    private String name;
    private double age; // between 0 - 25
    private String breed;
    private char sex; //M for male F for female
    private boolean foundHome = false;
    
    //Default dog constructor
    public Dog(){
        dogId = 0;
        name = "Not Set";
        age = 0.0;
        breed = "Not Set";
        sex = 'X';
        foundHome = false;    
    }
    
    //Valid constructor
    public Dog(int dogId, String name, double age, String breed, char sex, boolean foundHome){
        this.dogId = dogId;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.sex = sex;
        this.foundHome = foundHome;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isFoundHome() {
        return foundHome;
    }

    public void setFoundHome(boolean foundHome) {
        this.foundHome = foundHome;
    }
    
    public String toString(){
        String displayInfo = dogId+"\t\t"+name+"\t\t"+age+"\t\t"+breed+"\t\t"+sex+"\t\t"+foundHome;
        return displayInfo;
    }
    
    
    
    
}

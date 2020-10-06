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
public class DataValidator {
    
    //Check if input is only alphabetic characters
    public static boolean isStringOnlyAlphabet(String input){ 
        return ((!input.equals("")) 
            && (input != null) 
            && (input.matches("^[a-zA-Z]*$")));
    } 
    
    //Check if age input is between 0 and 25
    public static boolean isAgeInRange(String input){
        double age;
        try{
            age = Double.parseDouble(input);
        }catch(Exception e){
            return false;
        }
        if(age > 0 && age <= 25){
            return true;
        }
        return false;
    }
    
    //Check if input is char
    public static boolean isSexChar(char input){
        return input == 'F' || input == 'M' || input == 'f' || input == 'm';
    }
    
    //Check selection
    public static boolean isSelectionCorrect(String input){
        int number;
        try{
            number = Integer.parseInt(input);
        }catch(Exception e){
            return false;
        }
        if(number == 0){
            return true;
        }else if(number == 1){
            return true;
        }
        return false;
    }
    
    //Check if entry is a valid Dog id
    public static boolean isIdCorrect(String input){
        int number;
        try{
            number = Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

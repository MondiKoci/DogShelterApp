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
public class DogShelter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShelterManager manager = new ShelterManager(3);
        manager.addDog(123, "Dog", 12, "Pitbull", 'F', false);
        manager.addDog(222, "Mog", 2, "Pincher", 'M', false);
        manager.addDog(333, "FogMogd", 4, "Mincher", 'F', false);
        manager.adoptDog(123);
        
        manager.viewAllDogs();
    }
    
}

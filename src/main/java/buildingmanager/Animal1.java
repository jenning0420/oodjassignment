/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildingmanager;

/**
 *
 * @author User
 */
// Main program
public class Animal1 {

    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Output: "Woof!"
        myDog.sleep();     // Output: "Zzz"

        myCat.makeSound(); // Output: "Meow!"
        myCat.sleep();     // Output: "Zzz"
    }
}

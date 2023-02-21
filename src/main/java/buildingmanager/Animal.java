/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buildingmanager;

/**
 *
 * @author User
 */
// Abstract class
abstract class Animal {
    // Abstract method

    public abstract void makeSound();

    // Non-abstract method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass
class Dog extends Animal {

    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Subclass
class Cat extends Animal {

    public void makeSound() {
        System.out.println("Meow!");
    }
}


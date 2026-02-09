package edu.naukma.theme4;

public class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Woof!");
    }

    void fetchStick(){ System.out.println("Пес приніс палку");}
}

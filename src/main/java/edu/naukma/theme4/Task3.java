package edu.naukma.theme4;

public class Task3 {
    public static void main(String[] args) {
        run();
    }

    static void run() {
        Animal a = new Dog();
        Animal b = new Cat();

        if (a instanceof Dog dog) {
            dog.fetchStick();
        }

        if (b instanceof Dog dog) {
            dog.fetchStick();
        } else
            System.out.println("Це не пес");

    }
}

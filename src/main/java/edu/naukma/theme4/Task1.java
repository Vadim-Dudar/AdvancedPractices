package edu.naukma.theme4;

public class Task1 {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Cat()};

        for (Animal a: animals) a.speak();
    }
}

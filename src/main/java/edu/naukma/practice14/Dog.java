package edu.naukma.practice14;

import java.util.Objects;

public class Dog extends Animal{

    private DogBreed breed;

    public Dog(String name, DogBreed breed) {
        super(name);

        this.breed = breed;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Dog{" +
                "breed=" + breed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return breed == dog.breed;
    }

    @Override
    public void eat() {
        System.out.print("Dog is happy :)) ");
        super.eat();
    }

    private void bark() {
        System.out.println("Bark! Bark!");
    }
}

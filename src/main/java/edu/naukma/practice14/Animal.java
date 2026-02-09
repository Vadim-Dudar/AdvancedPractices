package edu.naukma.practice14;

import java.util.Objects;

public class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    public void eat() {
        System.out.println("Animal is eating now..");
        System.out.println("Animal has eaten.");
    }
}

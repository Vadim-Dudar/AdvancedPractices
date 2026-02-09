package edu.naukma.practice14;

public class Cat extends Animal{

    private CatBreed breed;

    public Cat(String name, CatBreed breed) {
        super(name);

        this.breed = breed;
    }
}

package edu.naukma.practice14;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Baks", DogBreed.Bulldog);
        Dog dog2 = new Dog("dfg", DogBreed.Bulldog);


        System.out.println(dog);
        System.out.println(dog.equals(dog2));
    }
}
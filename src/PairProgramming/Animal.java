package PairProgramming;

public abstract class Animal {
    String name;
    String breed;
    static int totalAnimals = 0;

    public Animal(String name, String species) {

        this.name = name;
        this.breed = species;
        totalAnimals++;
    }

    public abstract void makeSound();
}

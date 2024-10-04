package PairProgramming;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Microondas","Nose");
        Cat cat2 = new Cat("Microondas2","Nose");
        Dog dog1 = new Dog("Rompe","Delmer");
        dog1.makeSound();
        System.out.println(Animal.totalAnimals);
        System.out.println(Dog.totalDogs);
        System.out.println(Cat.totalCats);
        cat1.makeSound();
    }
}

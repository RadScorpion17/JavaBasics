package PairProgramming;

public class Dog extends Animal {

    public static int totalDogs = 0;
    public Dog(String name, String breed)
    {
        super(name, breed);
        totalDogs++;
    }
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

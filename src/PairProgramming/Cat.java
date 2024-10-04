package PairProgramming;

public class Cat extends Animal {

    public static int totalCats = 0;
    public Cat(String name, String breed)
    {
        super(name, breed);
        totalCats++;
    }
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

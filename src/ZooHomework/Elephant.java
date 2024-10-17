package ZooHomework;

public class Elephant implements Animal {
    private String name;
    private String species;
    private String breed;
    private int age;
    private int weight;

    public Elephant(String name, String species, String breed, int age, int weight) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public Elephant(){

    }

    @Override
    public void eat() {
        System.out.println("Elephant " + name + " eats");
    }
    @Override
    public void makeSound() {
        System.out.println("Elephant noise!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSpecies() {
        return species;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}

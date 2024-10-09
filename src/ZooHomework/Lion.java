package ZooHomework;

public class Lion implements Animal {
    private String name;
    private String species;
    private String breed;
    private int age;
    private int weight;

    public Lion(String name, String species, String breed, int age, int weight) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public void eat() {
        System.out.println("Lion " + name + " eats");
    }
    @Override
    public void makeSound() {
        System.out.println("Roar!");
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

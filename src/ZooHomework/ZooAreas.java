package ZooHomework;

import java.util.ArrayList;

public class ZooAreas {
    public String name;
    public int capacity;
    private ArrayList<Animal> animals = new ArrayList<>();

    public ZooAreas(String name,int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addAnimal(Animal animal) {
        int currentCapacity = animals.size();

        if(currentCapacity == capacity){
            System.out.println("Current animal capacity is at maximum for this area " + "("+this.name+")");
            return;
        }

        animals.add(animal);
    }

    public void addAnimal(ArrayList<Animal> animal) {
        int currentCapacity = animals.size();

        if(currentCapacity == this.capacity){
            System.out.println("Current animal capacity is at maximum for this area " + "("+this.name+")");
            return;
        }

        if(currentCapacity + animal.size() > this.capacity){
            System.out.println("List of animals is too big for this area "+"("+this.name+")");
            return;
        }

        animals.addAll(animal);
    }

    public ArrayList<Animal> getAnimals(){
        if(animals.isEmpty()){
            System.out.println("No animals available");
            return null;
        }
        return animals;
    }

    public int getCurrentCapacity(){
        return this.animals.size();
    }
}

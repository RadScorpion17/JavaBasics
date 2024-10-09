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
        int currentCapacity = 0;

        if(animals != null){
            currentCapacity = animals.size();
        }

        if(currentCapacity > capacity){
            System.out.println("Current animal capacity is at maximum for this area");
            return;
        }

        animals.add(animal);
    }

    public ArrayList<Animal> getAnimals(){
        if(animals.isEmpty()){
            System.out.println("No animals available");
            return null;
        }
        return animals;
    }

    public int getCapacity() {
        return capacity;
    }
}

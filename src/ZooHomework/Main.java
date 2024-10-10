package ZooHomework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Zoo zoo1 = new Zoo("Botánico");

        ZooAreas zooArea1 = new ZooAreas("Mamíferos", 5);
        ZooAreas zooArea2 = new ZooAreas("Reptiles", 3);
        ZooAreas zooArea3 = new ZooAreas("Felinos", 3);

        ArrayList<Animal> elephants = new ArrayList<>(){{
            add(new Elephant("Dumbo", "???","Orejon",10,1000));
            add(new Elephant("Unicorn", "???","Orejon",15,1250));
            add(new Elephant("Mario", "???","Patudo",7,950));
            add(new Elephant("Miggy", "???","Orejon",36,2000));
            add(new Elephant("Felipe", "???","Orejon",14,1800));
            add(new Elephant("Felipe", "???","Orejon",14,1800));
        }};
        zooArea1.addAnimal(elephants);

        Lion lion1 = new Lion("Nala", "Feline","cat",6,60);
        Lion lion2 = new Lion("Simba", "Feline","brown mane",5,65);
        zooArea3.addAnimal(lion1);
        zooArea3.addAnimal(lion2);
        zoo1.addArea(zooArea1);
        zoo1.addArea(zooArea3);

        int filterCapacity = 2;
        ArrayList<ZooAreas> filteredAreas = new ArrayList<>(){{
            addAll(zoo1.areas.stream().filter(zooArea -> zooArea.getCurrentCapacity() >= filterCapacity).toList());
        }};

        filteredAreas.forEach(zooAreas -> zooAreas.getAnimals()
                                      .forEach(animal -> System.out.println("Name: "+animal.getName()+
                                                                            "\nSpecie: "+animal.getSpecies()+
                                                                            "\nBreed: "+animal.getBreed()+
                                                                            "\nAge: "+animal.getAge()+
                                                                            "\nWeight: "+animal.getWeight()+"\n")));

    }
}

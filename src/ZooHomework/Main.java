package ZooHomework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Zoo zoo1 = new Zoo("Botánico");

        ZooAreas zooArea1 = new ZooAreas("Mamíferos", 5);
        ZooAreas zooArea2 = new ZooAreas("Reptiles", 3);
        ZooAreas zooArea3 = new ZooAreas("Felinos", 3);

        Elephant elephant1 = new Elephant("Dumbo", "???","Orejon",10,1000);
        Elephant elephant2 = new Elephant("Unicorn", "???","Big guy",4,900);
        Lion lion1 = new Lion("Nala", "Feline","cat",6,60);
        Lion lion2 = new Lion("Simba", "Feline","brown mane",5,65);

        zooArea1.addAnimal(elephant1);
        zooArea1.addAnimal(elephant2);
        zooArea3.addAnimal(lion1);
        zooArea3.addAnimal(lion2);
        zoo1.addArea(zooArea1);
        zoo1.addArea(zooArea3);
        

        int filterCapacity = 2;
        zoo1.areas.stream().filter(zooArea -> zooArea.getCapacity() >= filterCapacity)
                           .forEach(zooArea -> zooArea.getAnimals()
                                   .forEach(animal -> System.out.println("Name: "+animal.getName()+
                                                                         "\nSpecie: "+animal.getSpecies()+
                                                                         "\nBreed: "+animal.getBreed()+
                                                                         "\nAge: "+animal.getAge()+
                                                                         "\nWeight: "+animal.getWeight()+"\n")));
    }
}

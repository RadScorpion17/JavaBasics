package ZooHomework;

public class Main {
    public static void main(String[] args) {
        Zoo zoo1 = new Zoo("Botánico");

        ZooAreas zooArea1 = new ZooAreas("Mamíferos", 5);
        ZooAreas zooArea2 = new ZooAreas("Reptiles", 3);
        ZooAreas zooArea3 = new ZooAreas("Felinos", 3);

        Elephant elephant1 = new Elephant("Dumbo", "???","Orejon",10,1000);

        zooArea1.addAnimal(elephant1);

        for(Animal animal : zooArea1.getAnimals()){
            System.out.println(animal.getName());
        };
    }
}

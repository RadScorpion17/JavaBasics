/*
 *  ---- PARTE 2 ----
 *  Resumen de homework sobre manejo de excepciones y file i/o:
 *  En el mismo trabajo anterior del zoo, hacer que los datos de los animales (especie, raza, nombre y año de
 *  nacimiento o edad) y de las áreas (nombre y capacidad máxima) se tome de uno o dos archivos de texto. Puede
 *  ser un csv o con alguna estructura que Uds decidan, solo que si es un csv probablmente necesiten 2
 *  archivos, uno con datos de los animales y otro con datos de las zonas. Agreguen manejo de excepciones para
 *  la lectura del o los archivos y, si están inspirados y con ganas, si se supera la capacidad de una zona.
 */

package ZooHomework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo zoo1 = new Zoo("Botánico");
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/ZooHomework/zooAreas.csv"));
            writer1.write("zoo_area_name, capacity\n");
            List<String> zooAreasFileLoadArray = new ArrayList<>();
            zooAreasFileLoadArray.add("Elephants, 5");
            zooAreasFileLoadArray.add("Reptiles, 3");
            zooAreasFileLoadArray.add("Felines, 3");
            for (String zooArea : zooAreasFileLoadArray) {
                writer1.write(zooArea + "\n");
            }
            writer1.close();
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }

        try {
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/ZooHomework/animals.csv"));
            writer2.write("animal, name, species, breed, age, weight\n");
            List<String> animalsFileLoadArray = new ArrayList<>();
            animalsFileLoadArray.add("Elephant, Dumbo, Pachyderm, Orejon, 10, 1000");
            animalsFileLoadArray.add("Elephant, Unicorn, Pachyderm, Orejon, 15, 1250");
            animalsFileLoadArray.add("Elephant, Mario, Pachyderm, Patudo, 7, 950");
            animalsFileLoadArray.add("Elephant, Miggy, Pachyderm, Orejon, 36, 2000");
            animalsFileLoadArray.add("Elephant, Felipe, Pachyderm, Orejon, 14, 1800");
            animalsFileLoadArray.add("Elephant, Felipe, Pachyderm, Orejon, 14, 1800");
            animalsFileLoadArray.add("Lion, Nala, Feline, cat, 6, 65");
            animalsFileLoadArray.add("Lion, Simba, Feline, brown mane, 5, 65");

            for (String animal : animalsFileLoadArray) {
                writer2.write(animal + "\n");
            }
            writer2.close();
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }

        ArrayList<ZooAreas> zooAreasFileReadArray = new ArrayList<>();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("src/ZooHomework/zooAreas.csv"));
            reader1.readLine();
            String[] areas;
            String line = reader1.readLine();
            int i = 0;
            while (line != null) {
                areas = line.split(", ");
                zooAreasFileReadArray.add(i, new ZooAreas(areas[0], Integer.parseInt(areas[1])));
                i++;
                line = reader1.readLine();
            }
            reader1.close();
        } catch (IOException e) {
            System.out.println("Could not access file: " + e.getMessage());
        }

        ArrayList<Animal> animalsFileReadArray = new ArrayList<>();
        try {
            BufferedReader reader2 = new BufferedReader(new FileReader("src/ZooHomework/animals.csv"));
            reader2.readLine();
            String[] animals;
            String line = reader2.readLine();
            int i = 0;

            while (line != null) {
                animals = line.split(", ");
                if (animals[0].equals("Elephant")) {
                    animalsFileReadArray.add(i, new Elephant(animals[1],
                                                             animals[2],
                                                             animals[3],
                                                             Integer.parseInt(animals[4]),
                                                             Integer.parseInt(animals[5])));
                } else if (animals[0].equals("Lion")) {
                    animalsFileReadArray.add(i, new Lion(animals[1],
                                                         animals[2],
                                                         animals[3],
                                                         Integer.parseInt(animals[4]),
                                                         Integer.parseInt(animals[5])));
                }
                i++;
                line = reader2.readLine();
            }
            reader2.close();
        } catch (IOException e) {
            System.out.println("Could not access file: " + e.getMessage());
        }

        ZooAreas zooArea1 = zooAreasFileReadArray.get(0);
        ZooAreas zooArea2 = zooAreasFileReadArray.get(1);
        ZooAreas zooArea3 = zooAreasFileReadArray.get(2);

        for (Animal animal: animalsFileReadArray) {
            String animalType = animal.getClass().getSimpleName();
            if (animalType.equals("Elephant")) {
                zooArea1.addAnimal(animal);
            } else if (animalType.equals("Lion")) {
                zooArea3.addAnimal(animal);
            } else {
                zooArea2.addAnimal(animal);
            }
        }

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

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "./data.csv";

        Zoo zoo = new Zoo("Botanic");
        ZooAreas zooArea = new ZooAreas("Mammals",4);

        ArrayList<Animal> mammals = new ArrayList<>(){{
            add(new Elephant("Nala","????","Orejon",25,1250));
            add(new Elephant("Dambo","????","Orejon",26,1000));
        }};
        //Add to Animal to the Area
        zooArea.addAnimal(mammals);
        //Add Zoo Area to the Zoo
        zoo.addArea(zooArea);

        //Write file to csv
        writeFile(filePath , formatZooData(zoo));
        //Read file to a collection of String[]
        readFile(filePath);
        //TODO
        // 1. Further refactoring, especially the statics methods below
        // 2. Try to map readFile() collection output back to the corresponding class:
        //    2.1 In case there's numerous zoos in the list, generate a collection of zoos
        // 3. Noah's code: test the capacity constraint of the ZooAreas class
    }

    public static void writeFile(String path, StringBuilder file){
        try{
            Path filePath = Paths.get(path);
            Scanner scanner = new Scanner(System.in);

            if(Files.exists(filePath)){
                System.out.println("File already exists, would you like to overwrite? (Y/N)");
                String option = scanner.nextLine().toUpperCase();

                if(option.equals("N")){
                    System.out.println("File will not be overwritten, closing the program.....");
                    System.exit(0);
                }else if(option.equals("Y")){
                    System.out.println("Overwriting existing file...");
                    Files.deleteIfExists(filePath);
                }
            }

            Files.createFile(filePath);

            Files.write(filePath, file.toString().getBytes(), StandardOpenOption.APPEND);

        }catch (IOException e){
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    public static List<String[]> readFile(String path){
        try{
            Path filePath = Paths.get(path);
            List<String[]> lines = new ArrayList<>();

            if(Files.notExists(filePath)){
                throw new FileNotFoundException("File not found: " + path);
            }

            BufferedReader rd = Files.newBufferedReader(filePath);

            //Skip headers
            rd.readLine();

            String line;
            //Read till the end :D
            while((line = rd.readLine()) != null){
                String[] data = line.split(";");
                lines.add(data);
            }

            return lines;

        } catch (Exception e) {
            System.out.println("Could not read file: " + e.getMessage());
            return null;
        }
    }

    public static StringBuilder formatZooData(Zoo zoo) {
        StringBuilder sb = new StringBuilder();

        // Headers
        sb.append("Zoo;Area;Name;Species;Breed;Age;Weight\n");

        // Data body
        zoo.getAreas().forEach(zooArea -> zooArea.getAnimals()
                .forEach(animal ->
                    sb.append(String.format("%s;%s;%s;%s;%s;%d;%d%n",
                            zoo.name,
                            zooArea.name,
                            animal.getName(),
                            animal.getSpecies(),
                            animal.getBreed(),
                            animal.getAge(),
                            animal.getWeight()))
        ));

        return sb;
    }
}
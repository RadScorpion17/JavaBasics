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
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "./data.csv";

        //region Initialize objects and write'em to a csv file
        Zoo zoo = new Zoo("Botanic");
        ZooAreas zooArea = new ZooAreas("Mammals",4);
        ArrayList<Animal> mammals = new ArrayList<>(){{
            add(new Elephant("Nala","????","Orejon",25,1250));
            add(new Elephant("Dambo","????","Orejon",26,1000));
        }};
        //Add Animal to the Area
        zooArea.addAnimal(mammals);
        //Add ZooArea to the Zoo
        zoo.addArea(zooArea);
        //Write file to csv
        writeFile(filePath , formatZooData(zoo));
        //endregion

        //region Read csv file and print data
        //TODO
        // 1. Further refactoring, especially the statics methods below
        // 2. Noah's code: test the capacity constraint of the ZooAreas class, also, filter data with stream()
        // Nvm trying to map to the class
        List<Map<String,String>> csvData = mapCSV(filePath);
        csvData.forEach(System.out::println);
        //endregion
    }

    public static void writeFile(String path, StringBuilder file) {
        try {
            Path filePath = Paths.get(path);
            if (Files.exists(filePath)) {
                System.out.println("File already exists, overwriting...");
            } else {
                Files.createFile(filePath);
            }
            Files.write(filePath, file.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }

    //TODO: this method length can be reduced with stream
    public static List<Map<String,String>> mapCSV(String path){
        try{
            Path filePath = Paths.get(path);
            List<Map<String, String>> dataSet = new ArrayList<>();
            List<String> headers = new ArrayList<>();

            if(Files.notExists(filePath)){
                throw new FileNotFoundException("File not found: " + path);
            }

            BufferedReader rd = Files.newBufferedReader(filePath);

            //Extract headers from csv
            for(String header: rd.readLine().split(";")){
                headers.add(header);
            }

            //Variable to contain og csv line
            String line;
            while((line = rd.readLine()) != null){

                Map<String,String> lines = new HashMap<>();
                String[] data = line.split(";");
                int pos = 0;

                //For each header, map data from csv body (every item must be in order)
                for(String header : headers){
                    lines.put(header, data[pos]);
                    pos++;
                }

                //Add mapped line to the dataSet
                dataSet.add(lines);
            }

            return dataSet;

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
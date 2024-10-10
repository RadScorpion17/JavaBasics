/*
 *  Resumen trabajo (usando la dinámica de pair programming de vuelta):
 *  Cada equipo tiene que:
 *  Crear una interfaz "Animal" que tenga la signature de por lo menos
 *  estos métodos: getSpecie(), getBreed(), getName() y getBirthYear().
 *  Crear al menos dos clases que implemente la interfaz.
 *  Crear las clases Zoo y ZooArea. La clase Zoo tiene un nombre y
 *  varias ZooAreas (pueden implementar como ArrayList o como HashSet).
 *  Además la clase ZooArea tiene un atributo que indica su capacidad
 *  de animales (el nro máximo de animales que puede contener) que se
 *  debe indicar en el constructor.
 *  Implementar un metodo main para probar la creación del zoo, de las
 *  áreas y de los animales y validar que un área no deje agregar
 *  animales más allá de su capacidad. Usar un Stream para filtrar
 *  todas las áreas que tengan más de un x nro de animales e imprimir
 *  nombre, especie, raza y edad de cada uno.
 *  Hay libertad creativa, no hace falta que los métodos, clases e
 *  interfaz se llaman así tal cual y que se haga exactamente lo que se
 *  indicó, siempre que se respete la idea general (Ej pueden filtrar
 *  por otros criterios o hacer alguna otra operación usando el stream)
 */

package ZooHomework;

public interface Animal {
    String getName();
    String getSpecies();
    String getBreed();
    int getAge();
    int getWeight();
    void eat();
    void makeSound();

}

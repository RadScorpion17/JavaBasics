package ZooHomework;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Mapper {
    public enum AnimalsAvailable{
        ELEPHANT,
        LION
    }

    public static List<Object> dynamicInstance(List<Map<String, String>> data) {
        List<Object> instances = new ArrayList<>();  // Lista para almacenar las instancias creadas
        int s = 1;
        for (Map<String, String> obj : data) {
            String className = obj.get("Animal");  // Asegúrate de que la clave "Animal" exista
            try {
                Class<?> dynamicClass = Class.forName("ZooHomework."+className);

                Constructor<?> constructor = dynamicClass.getDeclaredConstructor(
                        String.class, String.class, String.class, int.class, int.class);

                Object instance = constructor.newInstance(
                        obj.get("Name"),
                        obj.get("Species"),
                        obj.get("Breed"),
                        Integer.parseInt(obj.get("Age")),
                        Integer.parseInt(obj.get("Weight"))
                );

                instances.add(instance);

            } catch (ClassNotFoundException e) {
                System.err.println("Clase no encontrada: " + className);
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                System.err.println("Constructor no encontrado en la clase: " + className);
                e.printStackTrace();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println("Error al instanciar la clase: " + className);
                e.printStackTrace();
            }
        }

        return instances;
    }


}


package ud6.ejercicios.limpiezaplaya.poo;

import java.io.*;
import java.util.List;

public class UtilFicheros {

    public static <T> List<T> leerFichero(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            // System.out.println("No se pudo leer " + ruta + ": " + e.getMessage());
            return null;
        }
    }

    public static <T> void escribirFichero(String ruta, List<T> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(datos);
        } catch (IOException e) {
            System.out.println("Error guardando " + ruta + ": " + e.getMessage());
        }
    }
}

package ud7.limpieza;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilFicheros {

    public static <T> void escribirFichero(String nombreFichero, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(lista);
            System.out.println(" Datos guardados en " + nombreFichero);
        } catch (IOException e) {
            System.out.println(" Error al guardar en " + nombreFichero + ": " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> leerFichero(String nombreFichero) {
        List<T> lista = new ArrayList<>();
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println(" Fichero " + nombreFichero + " no encontrado. Se iniciará vacío.");
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            lista = (List<T>) ois.readObject();
            System.out.println(" Datos cargados desde " + nombreFichero);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error al leer " + nombreFichero + ": " + e.getMessage());
        }
        return lista;
    }
}

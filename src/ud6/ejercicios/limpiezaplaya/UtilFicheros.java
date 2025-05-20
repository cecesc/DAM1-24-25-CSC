package ud6.ejercicios.limpiezaplaya;

import java.io.*;
import java.util.List;

public class UtilFicheros {

    public static <T> void escribirFichero(String nomeFicheiro, List<T> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiro))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> lerFicheiro(String nomeFicheiro) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiro))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}

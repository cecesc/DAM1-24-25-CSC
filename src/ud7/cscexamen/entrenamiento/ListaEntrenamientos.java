//Autor:Celia Sanmartín Chapela
package ud7.cscexamen.entrenamiento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaEntrenamientos implements Serializable {

    public List<Entrenamiento> lista;
    public double totalNómina = 0;

    public ListaEntrenamientos() {
        lista = new ArrayList<>();
    }

    public void guardarLista(String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(this);
        }
    }

    public static ListaEntrenamientos cargarLista(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (ListaEntrenamientos) ois.readObject();
        }
    }

}

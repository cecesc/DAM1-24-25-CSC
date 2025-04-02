package ud6.coleccionesejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ud5.rol.Personaje;

public class Sorteo<T> {
    Set<T> elementos = new HashSet<>();


    boolean add(T elemento) {
        elementos.add(elemento);
        return true;
    }


    Set<T> premiados(int numPremiados) {
        List<T> listaAux = new ArrayList(elementos);
        Collections.shuffle(listaAux);

        Set<T> premiados = new TreeSet<>();
        for (int i = 0; i < numPremiados; i++)
            premiados.add(listaAux.get(i));

        return premiados;
    }
    
    public static void main(String[] args) {
        // Crea un sorteo entre 4 personajes para seleccionar los 2 que se enfrentarán en combate singular
        Sorteo<Personaje> sorteo = new Sorteo<>();
        sorteo.add(new Personaje("Aragorn", Raza.HUMANO, 90, 90, 90, 10, 16252, 125));
        sorteo.add(new Personaje("Mara", Raza.ELFO, 100, 100, 100));
        sorteo.add(new Personaje("Dodol Bazbal", Raza.ENANO));
        sorteo.add(new Personaje("Lady Jet"));

        Set<Personaje> elegidos = sorteo.premiados(2);

        System.out.println(elegidos);
    }

}

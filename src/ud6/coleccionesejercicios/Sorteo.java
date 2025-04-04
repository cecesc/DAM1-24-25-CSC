package ud6.coleccionesejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ud5.rol.Personaje;
import ud5.rol.Personaje.raza;



public class Sorteo<T> {
    Set<T> elementos = new HashSet<>();


    boolean add(T elemento) {
        return elementos.add(elemento);
    }


    Set<T> premiados(int numPremiados) {
        if (numPremiados <=0) {
            return null;
        }
        if (numPremiados>elementos.size()) {
            numPremiados=elementos.size();
        }

        List<T> listaAux = new ArrayList(elementos);
        Set<T> premiados = new TreeSet<>();
        Collections.shuffle(listaAux);

        
        for (int i = 0; i < numPremiados; i++)
            premiados.add(listaAux.get(i));
        return premiados;
    }
    
    public static void main(String[] args) {
        // Crea un sorteo entre 4 personajes para seleccionar los 2 que se enfrentarán en combate singular
        Sorteo<Personaje> sorteo = new Sorteo<>();
        sorteo.add(new Personaje("Aragorn", raza.ELFO, 0 ,21,90,20,20));
        sorteo.add(new Personaje("Mara", raza.ELFO, 100,0,100,100,0));
        sorteo.add(new Personaje("Dodol Bazbal", raza.ENANO));
        sorteo.add(new Personaje("Lady Jet"));

        Set<Personaje> elegidos = sorteo.premiados(2);

        System.out.println(elegidos);
    }

}

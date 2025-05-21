//Autor: Celia Sanmartín Chapela
package ud6.cscexamenrec.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UtilGenerico {

    public static <T> Collection<T> contarCoincidencias(Collection<T> coleccion, Collection<T> coleccion2) {
        Set<T> vistos = new LinkedHashSet<>(coleccion);
        Map<T, Integer> contador = new HashMap<>();

        for (T elem : coleccion) {
            contador.put(elem, contador.getOrDefault(elem, 0) + 1);
        }
        return new ArrayList<>(vistos);
    }

    public static <K extends Comparable<K>, V> Map<K, V> invertirOrden(Set<K> claves, List<V> valores) {
        List<K> clavesOrdenadas = new ArrayList<>(claves);
        Collections.sort(clavesOrdenadas);

        List<V> valoresOrdenados = new ArrayList<>(valores);
        valoresOrdenados.sort(Collections.reverseOrder());

        Map<K, V> resultado = new TreeMap<>();
        Iterator<K> itClave = clavesOrdenadas.iterator();
        Iterator<V> itValor = valoresOrdenados.iterator();

        while (itClave.hasNext()) {
            K clave = itClave.next();
            V valor = itValor.hasNext() ? itValor.next() : null;
            resultado.put(clave, valor);
        }

        return resultado;
    }

    public static void main(String[] args) {

        Set<String> claves = new LinkedHashSet<>(Arrays.asList("a", "b", "c"));
        List<Integer> valores = Arrays.asList(1, 2, 3);
        Map<String, Integer> mapa = invertirOrden(claves, valores);
        System.out.println(mapa);
    }
}
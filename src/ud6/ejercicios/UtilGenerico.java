package ud6.ejercicios;

import java.util.Collection;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;

public class UtilGenerico {

    // 1. Método sinRepetidos()
    public static <T> Collection<T> sinRepetidos(Collection<T> coleccion) {
        Set<T> vistos = new LinkedHashSet<>(coleccion);
        return new ArrayList<>(vistos);
    }

    // 2. Método contarRepetidos()
    public static <T> Map<T, Integer> contarRepetidos(Collection<T> coleccion) {
        Map<T, Integer> contador = new HashMap<>();
        for (T elem : coleccion) {
            contador.put(elem, contador.getOrDefault(elem, 0) + 1);
        }
        return contador;
    }

    // 3. Método iniciarMapa()
    public static <K extends Comparable<K>, V> Map<K, V> iniciarMapa(Set<K> claves, List<V> valores) {
        List<K> clavesOrdenadas = new ArrayList<>(claves);
        Collections.sort(clavesOrdenadas); // orden natural de las claves

        List<V> valoresOrdenados = new ArrayList<>(valores);
        valoresOrdenados.sort(Collections.reverseOrder()); // orden descendente

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

    // Programa principal con ejemplos
    public static void main(String[] args) {
        // Ejemplo sinRepetidos
        List<String> lista = Arrays.asList("manzana", "pera", "manzana", "uva", "pera");
        Collection<String> sinDupes = sinRepetidos(lista);
        System.out.println("Sin repetidos: " + sinDupes);

        // Ejemplo contarRepetidos
        Map<String, Integer> repetidos = contarRepetidos(lista);
        System.out.println("Contar repetidos: " + repetidos);

        // Ejemplo iniciarMapa
        Set<String> claves = new LinkedHashSet<>(Arrays.asList("A", "C", "B", "D"));
        List<Integer> valores = Arrays.asList(10, 5, 20); // falta uno
        Map<String, Integer> mapa = iniciarMapa(claves, valores);
        System.out.println("Mapa iniciado: " + mapa);
    }
}

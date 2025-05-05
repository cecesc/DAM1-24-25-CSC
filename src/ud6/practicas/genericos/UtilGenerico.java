package ud6.practicas.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilGenerico {
    public static <T> List<T> repetidos(List<T> lista) {
    Map<T, Integer> contador = new HashMap<>();
    for (T elem : lista) {
        contador.put(elem, contador.getOrDefault(elem, 0) + 1);
    }
    List<T> resultado = new ArrayList<>();
    for (T elem : lista) {
        if (contador.get(elem) > 1) {
            resultado.add(elem);
        }
    }
    return resultado;
}

public static <T> Collection<T> filtrarMayores(Collection<T> coleccion, T elemento, Comparator<T> cmp) {
    List<T> resultado = new ArrayList<>();
    for (T item : coleccion) {
        if (cmp.compare(item, elemento) >= 0) {
            resultado.add(item);
        }
    }
    return resultado;
}

public static void main(String[] args) {
    List<String> lista = Arrays.asList("a", "b", "a", "c", "b", "d", "e");
    System.out.println("Repetidos: " + repetidos(lista));

    List<Integer> numeros = Arrays.asList(1, 3, 5, 7, 9);
    System.out.println("Mayores que 5: " + filtrarMayores(numeros, 5, Integer::compareTo));
}

}

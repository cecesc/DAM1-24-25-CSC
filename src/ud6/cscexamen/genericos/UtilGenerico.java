package ud6.cscexamen.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class UtilGenerico {
    public static <T> List<T> repetidos(List<T> lista) {
        List<T> soloRepetidos = new ArrayList<>();
        for (T elem : lista) {
            if (lista.indexOf(elem) != lista.lastIndexOf(elem)) {
                soloRepetidos.add(elem);
            }
        }
        return soloRepetidos;
    }

    public static <T> Collection<T> filtrarMayores(Collection<T> coleccion, T valor, Comparator<T> comp) {
        Collection<T> resultado = new ArrayList<>();
        for (T e : coleccion) {
            if (comp.compare(e, valor) >= 0) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Integer[] t = { 1, 3, 3, 4, 5, 5, 6 };
        System.out.println(repetidos(Arrays.asList(t)));

        Comparator<Integer> comp= Comparator.naturalOrder();
    System.out.println(filtrarMayores(Arrays.asList(t), 4, comp));
    }

}

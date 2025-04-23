package ud6.apuntesstream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class E1305 {
    public static <T, V> List<V> transformar(List<T> t, Function<T, V> f) {
        List<V> resultado = new ArrayList<>();
        for (T elem : t) {
            resultado.add(f.apply(elem));
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Raices cuadradas");

        List<Integer> lista = new ArrayList<>();
        int rnd;
        for (int i = 0; i < 10; i++) {
            rnd = (int) (Math.random() * 100 + 1);
            lista.add(rnd);
        }
        System.out.println(lista);
        List<Double> raices = transformar(lista, x -> Math.sqrt(x));
        System.out.println(raices);
    }

}

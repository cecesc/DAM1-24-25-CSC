package ud6.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ep1224 {
 public static List<Integer> fusiona(List<Integer> l1, List<Integer> l2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                resultado.add(l1.get(i++));
            } else {
                resultado.add(l2.get(j++));
            }
        }

        while (i < l1.size()) resultado.add(l1.get(i++));
        while (j < l2.size()) resultado.add(l2.get(j++));

        return resultado;
    }
}


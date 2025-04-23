package ud6.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ep1228 {
    public static List<Character> uneCadenas(List<Character> cad1, List<Character> cad2) {
        List<Character> resultado = new ArrayList<>(cad1);
        resultado.addAll(cad2);
        return resultado;
    }
}



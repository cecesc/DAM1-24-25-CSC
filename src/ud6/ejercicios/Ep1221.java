package ud6.ejercicios;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ep1221 {
    public static void main(String[] args) {
        Set<Integer> numeros = new TreeSet<>(Collections.reverseOrder());
        Random rand = new Random();

        while (numeros.size() < 20) {
            int num = rand.nextInt(100);
            numeros.add(num);
        }

        System.out.println("Números generados: " + numeros);
    }
}

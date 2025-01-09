/* Escribe la función: static int[] rellenaPares(int longitud, int fin) que crea 
y devuelve una tabla ordenada de la longitud especificada rellena con números 
pares aleatorios en el rango desde 2 hasta el valor de fin inclusive.  */

package ud4.apuntes;

import java.util.Arrays;
import java.util.Random;

public class E0505 {
    public static int[] rellenaPares(int longitud, int fin) {
        int[] t = new int[longitud];

        for (int i = 0; i < t.length; i++) {
            Random rnd = new Random();
            do
                t[i] = rnd.nextInt(2, fin + 1);
            while (t[i] % 2 != 0);

        }
        Arrays.sort(t);

        return t;

    }

    public static void main(String[] args) {
        int[] t = rellenaPares(10, 20);

        System.out.println(Arrays.toString(t));
    }
}

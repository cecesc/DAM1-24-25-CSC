//Autor: Celia Sanmartín Chapela
package ud4.csc20250110;

import java.util.Random;

public class EP0512_Desordenar {
    public static void desordenar(int[] t) {
        Random rdn = new Random();

        for (int i = 0; i < t.length; i++) {
            int j = rdn.nextInt(t.length);
            int temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] t = { 1, 2, 3, 4, 5, 6 };
        desordenar(t);
        System.out.print("Array desordenado: " + java.util.Arrays.toString(t));
    }
}

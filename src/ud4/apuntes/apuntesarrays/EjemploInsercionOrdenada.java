package ud4.apuntes.apuntesarrays;

import java.util.Arrays;

public class EjemploInsercionOrdenada {
    public static void main(String[] args) {
        int[] t = { 5, 2, 7, 9, 4, 1, 8, 5, 4, 2, 8 };

        Arrays.sort(t);
        System.out.println(Arrays.toString(t));
        int valor = 6;

        t = insertarOredenado(t, valor);
        System.out.println(Arrays.toString(t));
    }

    static public int[] insertarOredenado(int[] t, int num) {
        int[] tRes = new int[t.length + 1];
        int posicion = Arrays.binarySearch(t, num);
        if (posicion < 0)
            posicion = -posicion - 1;

        System.arraycopy(t, 0, tRes, num, posicion);
        tRes[posicion]= num;
        System.arraycopy(t, posicion, tRes, posicion +1, t.length - posicion);
        return tRes;

    }
}

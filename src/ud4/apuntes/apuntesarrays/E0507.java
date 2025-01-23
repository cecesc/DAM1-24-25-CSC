package ud4.apuntes.apuntesarrays;

import java.util.Arrays;

import ud4.ArraysUtil;

public class E0507 {
    static Integer[] sinRepetidos(Integer t[]) {
        Integer[] tOrdenado = t.clone();
        Arrays.sort(tOrdenado);
        
        Integer[] sinRepetidos = new Integer[0];
        for (int i = 0; i < t.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < sinRepetidos.length; j++){
                if (t[i] == sinRepetidos[j])
                    repetido = true;
            }
            if (!repetido) {
                sinRepetidos = Arrays.copyOf(sinRepetidos, sinRepetidos.length + 1);
                sinRepetidos[sinRepetidos.length - 1] = t[i];
            }
        }

        return sinRepetidos;
    }

    public static void main(String[] args) {
        Integer[] t = ArraysUtil.arrayAleatorio(20, 1, 10);
        
        System.out.println(Arrays.toString(t));

        t = sinRepetidos(t);

        System.out.println(Arrays.toString(t));        
    }
}


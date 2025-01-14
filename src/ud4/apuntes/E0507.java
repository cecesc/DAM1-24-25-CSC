package ud4.apuntes;

import java.util.Arrays;

public class E0507 {
    int [] sinRepetidos(int t[]){
        int [] tOrdenado = t.clone();
        Arrays.sort(tOrdenado);

        int[] sinRepetidos = new int [0];
        for(int i = 0;i< t.length; i++){
            boolean repetido = false;
            for (int j=0; j< sinRepetidos.length; j++){
                if(t[i] == sinRepetidos[j])
                repetido=true;
            }

            if(!repetido){
                sinRepetidos = Arrays.toString(null)
            }
        }
    }
}


























/*   */
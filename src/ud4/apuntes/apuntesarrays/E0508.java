/*Genera una tabla de n números enteros aleatorios y construye a partir de ella otras dos
tablas, una con los valores pares y otra con los valores impares. Muestra las tablas de 
pares e impares ordenadas.
Implementa sendas funciones para los procesos anteriores usando los siguientes
prototipos:
int[] getPares(int t[])
int[] getImpares(int t[]) */

package ud4.apuntes.apuntesarrays;

import java.util.Arrays;

public class E0508 {
    public static void main(String[] args) {
        int[] t = {5, 2, 7, 9, 4, 1, 8, 5, 4, 2, 8};

        int[] pares = new int [0];
        int[] impares = new int [0];
       
        for (int e : t){
            if (e % 2 == 0) {
                pares = Arrays.copyOf(pares, pares.length +1);
                pares [pares.length -1] = e;
            } else{
                impares = Arrays.copyOf(impares, pares.length +1);
                impares [impares.length -1] = e;
            }
        }
    
    Arrays.sort(pares);
    Arrays.sort(impares);

    System.out.println(Arrays.toString(t));
    System.out.println(Arrays.toString(pares));
    System.out.println(Arrays.toString(impares));
    }

}


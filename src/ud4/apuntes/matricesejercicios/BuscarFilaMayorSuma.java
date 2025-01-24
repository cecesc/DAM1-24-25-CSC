/*Escribe un programa en Java que reciba una matriz de enteros y determine devuelva la fila que 
tiene la mayor suma de sus elementos */
package ud4.apuntes.matricesejercicios;

import java.util.Arrays;

public class BuscarFilaMayorSuma {
    public static void main(String[] args) {
        int[][] matriz = generarAleatorio(4, 5);

        mostrar(matriz);
        int[] sumafila = BuscarFilaMayorSuma(matriz);
        System.out.println(Arrays.toString(sumafila));
       
    }

    static int[] BuscarFilaMayorSuma(int[][] matriz) {
        if (matriz == null)
            return null;

        if (matriz.length == 0)
            return new int[0];

        int sumaMax = 0;
        int filaMax = 0;

        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }

            System.out.println("Suma fila " + i + " = " + suma);
            
            if (i == 0 || suma > sumaMax) {
                sumaMax = suma;
                filaMax = i;
            }
           

        }
        return matriz[filaMax];
    }

    static void mostrar(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }
    }

    static int[][] generarAleatorio(int numF, int numC) {
        int[][] m = new int[numF][numC];

        for (int i = 0; i < numF; i++)
            for (int j = 0; j < numC; j++)
                m[i][j] = (int) (Math.random() * 10);

        return m;
    }

}

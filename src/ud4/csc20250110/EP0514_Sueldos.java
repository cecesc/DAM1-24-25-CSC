//Autor: Celia Sanmartín Chapela

package ud4.csc20250110;

import ud4.ArraysUtil;
import java.util.Scanner;

public class EP0514_Sueldos {
     public static void sueldos(int[] A) {
        int i, j, aux;
        for (i=0;i< A.length -1 ; i++){
            for(j=0; j < A.length -i -1; j++){
                if (A[j+1] < A[j]) {
                    aux = A[j+1];
                    A[j+1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        double sueldo;

        System.out.println("Introduce los sueldos ( -1 para finalizar):");
        ArraysUtil.leerNumeros(null);
        while (true) {
            sueldo = sc.nextDouble();
            if (sueldo == -1)
                break;
        }

        if (sueldo == 0) {
            System.out.println("No se han introducido sueldos.");
        }

     sc.close();
    }
}



/*EJERCICIO CORREGIDO */







/*   */
/*Escribe un programa en Java que lea una matriz de enteros de 3 filas y 3 columnas del
usuario y luego calcule la suma de todos los elementos de la matriz. */

package ud4.arraysejercicios;
import java.util.Scanner;

public class EjArrays10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        int suma = 0;

        System.out.println("Introduce los elementos de la matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
                suma += matriz[i][j];
            }
        }

        System.out.println("La suma de todos los elementos de la matriz es: " + suma);
     sc.close();
    }
   
}
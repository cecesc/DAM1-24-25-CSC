package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class BingoInfantil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de bolas
        System.out.print("Ingrese el número de bolas (0 para terminar): ");
        int n = scanner.nextInt();

        while (n > 0) {
            // Leer los números de las bolas
            int[] bolas = new int[n];
            System.out.println("Ingrese los números de las bolas:");
            for (int i = 0; i < n; i++) {
                bolas[i] = scanner.nextInt();
            }

            // Crear un arreglo para almacenar las diferencias
            int[] diferencias = new int[n * (n - 1)]; // Máximo número de diferencias posibles
            int index = 0;

            // Calcular las diferencias
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) { // Asegurarse de que no se comparen la misma bola
                        diferencias[index++] = Math.abs(bolas[i] - bolas[j]);
                    }
                }
            }

            // Reducir el tamaño del arreglo de diferencias
            diferencias = Arrays.copyOf(diferencias, index);

            // Ordenar las diferencias
            Arrays.sort(diferencias);

            // Imprimir las diferencias ordenadas
            for (int i = 0; i < diferencias.length; i++) {
                System.out.print(diferencias[i]);
                if (i < diferencias.length - 1) {
                    System.out.print(" "); // Espacio entre números
                }
            }
            System.out.println(); // Nueva línea al final

            // Leer el siguiente número de bolas
            System.out.print("Ingrese el número de bolas (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
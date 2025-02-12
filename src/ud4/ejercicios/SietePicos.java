package ud4.ejercicios;

import java.util.Scanner;

public class SietePicos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de alturas
        System.out.print("Ingrese el número de alturas (0 para terminar): ");
        int n = scanner.nextInt();

        // Procesar hasta que se ingrese 0
        if (n > 0) {
            // Leer las alturas
            System.out.println("Ingrese las alturas (separadas por espacio):");
            int[] alturas = new int[n];
            for (int i = 0; i < n; i++) {
                alturas[i] = scanner.nextInt();
            }

            // Contar los picos
            int picos = 0;
            for (int i = 0; i < n; i++) {
                // Considerar el índice anterior y siguiente de forma circular
                int anterior = (i - 1 + n) % n; // Índice anterior
                int siguiente = (i + 1) % n; // Índice siguiente

                // Verificar si es un pico
                if (alturas[i] > alturas[anterior] && alturas[i] > alturas[siguiente]) {
                    picos++;
                }
            }

            // Imprimir el número de picos
            System.out.println("Número de picos: " + picos);
        } else {
            System.out.println("No se procesará ninguna montaña rusa.");
        }

        scanner.close();
    }
}
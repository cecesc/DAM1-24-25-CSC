package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class CrecientePorLosPelos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el tamaño del vector
        System.out.print("Ingrese el tamaño del vector (0 para terminar): ");
        int n = scanner.nextInt();

        // Procesar hasta que se ingrese 0
        if (n > 0) {
            // Leer el vector
            int[] vector = new int[n];
            System.out.println("Ingrese los elementos del vector (separados por espacio):");
            for (int i = 0; i < n; i++) {
                vector[i] = scanner.nextInt();
            }

            // Generar el siguiente vector creciente por los pelos
            int[] siguienteVector = Arrays.copyOf(vector, n); // Copiar el vector original

            // Encontrar el siguiente vector
            for (int i = n - 1; i >= 0; i--) {
                if (siguienteVector[i] < 1000) { // Asegurarse de que no exceda 1000
                    siguienteVector[i]++;
                    // Asegurarse de que los elementos posteriores sean iguales al nuevo valor
                    for (int j = i + 1; j < n; j++) {
                        siguienteVector[j] = siguienteVector[i];
                    }
                    break; // Salir del bucle una vez que se ha encontrado el siguiente vector
                }
            }

            // Imprimir el siguiente vector
            System.out.println("El siguiente vector creciente por los pelos es:");
            for (int i = 0; i < n; i++) {
                System.out.print(siguienteVector[i]);
                if (i < n - 1) {
                    System.out.print(" "); // Espacio entre números
                }
            }
            System.out.println(); // Nueva línea al final
        } else {
            System.out.println("No se procesará ninguna entrada.");
        }

        scanner.close();
    }
}
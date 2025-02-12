package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ParrillaDeSalida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de pilotos
        System.out.print("Ingrese el número de pilotos (0 para terminar): ");
        int n = scanner.nextInt(); // Leer el número de pilotos

        while (n != 0) { // Continuar mientras no se reciba 0
            // Inicializar la parrilla de salida
            String[] parrillaSalida = new String[26];
            boolean[] ocupada = new boolean[26]; // Para verificar si una posición ya está ocupada

            // Leer los pilotos
            System.out.println("Ingrese los cambios de posición y nombres de los pilotos:");
            for (int i = 0; i < n; i++) {
                int cambio = scanner.nextInt(); // Leer el cambio
                scanner.nextLine(); // Consumir el salto de línea
                String nombrePiloto = scanner.nextLine().trim(); // Leer el nombre del piloto

                // Calcular la posición de salida
                int posicionSalida = 0; // Posición de salida inicial
                if (cambio > 0) {
                    posicionSalida = 26 - cambio; // Mejora en la posición
                } else if (cambio < 0) {
                    posicionSalida = 26 + cambio; // Empeoramiento en la posición
                } else {
                    posicionSalida = 25; // No cambio, se queda en la última posición
                }

                // Verificar si la posición de salida es válida
                if (posicionSalida < 0 || posicionSalida >= 26 || ocupada[posicionSalida]) {
                    System.out.println("IMPOSIBLE");
                    return;
                }

                // Asignar el piloto a la posición de salida
                parrillaSalida[posicionSalida] = nombrePiloto;
                ocupada[posicionSalida] = true; // Marcar la posición como ocupada
            }

            // Imprimir la parrilla de salida
            System.out.println("Parrilla de salida:");
            for (int i = 0; i < 26; i++) {
                if (parrillaSalida[i] != null) {
                    System.out.println((i + 1) + " " + parrillaSalida[i]);
                }
            }

            // Leer nuevamente el número de pilotos para la siguiente iteración
            System.out.print("Ingrese el número de pilotos (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
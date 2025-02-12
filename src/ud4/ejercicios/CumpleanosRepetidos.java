package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class CumpleanosRepetidos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de personas en el grupo
        System.out.print("Ingrese el número de personas en el grupo (0 para terminar): ");
        int n = scanner.nextInt();

        // Procesar hasta que se ingrese 0
        while (n > 0) {
            String[] fechas = new String[n]; // Array para almacenar las fechas
            boolean hayRepetidos = false; // Bandera para verificar si hay cumpleaños repetidos

            // Leer las fechas de nacimiento
            System.out.println("Ingrese las fechas de nacimiento (formato día/mes/año):");
            for (int i = 0; i < n; i++) {
                fechas[i] = scanner.next(); // Leer la fecha
            }

            // Verificar si hay fechas repetidas
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (fechas[i].equals(fechas[j])) { // Comparar fechas
                        hayRepetidos = true; // Si hay una coincidencia, hay repetidos
                        break; // Salir del bucle interno
                    }
                }
                if (hayRepetidos) {
                    break; // Salir del bucle externo si ya se encontró un repetido
                }
            }

            // Imprimir el resultado
            if (hayRepetidos) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente número de personas
            System.out.print("Ingrese el número de personas en el grupo (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
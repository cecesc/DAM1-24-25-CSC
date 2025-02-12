package ud4.ejercicios;

import java.util.Scanner;

public class ModificacionTablas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de filas y columnas
        System.out.println("Ingrese el número de filas y columnas (0 0 para terminar):");
        int F = scanner.nextInt(); // Número de filas
        int C = scanner.nextInt(); // Número de columnas

        if (F == 0 || C == 0) {
            return; // Terminar si se recibe 0 0
        }

        // Inicializar la tabla
        int[][] tabla = new int[F][C];

        // Leer las modificaciones
        System.out.println("Ingrese las modificaciones (columna, fila inicial, fila final, valor) y -1 para terminar:");
        int I, A, B, M;

        // Leer la primera modificación
        I = scanner.nextInt(); // Índice de la columna
        while (I >= 0) { // Continuar mientras el índice sea no negativo
            A = scanner.nextInt(); // Índice de la primera fila
            B = scanner.nextInt(); // Índice de la última fila
            M = scanner.nextInt(); // Valor a añadir

            // Aplicar la modificación
            for (int fila = A; fila <= B; fila++) {
                tabla[fila][I] += M;
            }

            // Leer la siguiente modificación
            I = scanner.nextInt(); // Índice de la columna
        }

        // Imprimir la tabla resultante
        System.out.println("Tabla resultante:");
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(tabla[i][j]);
                if (j < C - 1) {
                    System.out.print(" "); // Espacio entre columnas
                }
            }
            System.out.println(); // Nueva línea al final de cada fila
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
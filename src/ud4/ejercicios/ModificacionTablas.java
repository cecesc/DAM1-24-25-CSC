package ud4.ejercicios;

import java.util.Scanner;

public class ModificacionTablas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de filas, columnas y modificaciones
        int F = scanner.nextInt(); // Número de filas
        int C = scanner.nextInt(); // Número de columnas
        int N = scanner.nextInt(); // Número de modificaciones

        while (F != 0 || C != 0 || N != 0) { // Continuar mientras no se reciba 0 0 0
            // Inicializar la tabla
            int[][] tabla = new int[F][C];

            // Procesar cada modificación
            for (int i = 0; i < N; i++) {
                int I = scanner.nextInt(); // Índice de la columna
                int A = scanner.nextInt(); // Índice de la primera fila
                int B = scanner.nextInt(); // Índice de la última fila
                int M = scanner.nextInt(); // Valor a añadir

                // Aplicar la modificación
                for (int fila = A; fila <= B; fila++) {
                    tabla[fila][I] += M;
                }
            }

            // Imprimir la tabla resultante
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(tabla[i][j]);
                    if (j < C - 1) {
                        System.out.print(" "); // Espacio entre columnas
                    }
                }
                System.out.println(); // Nueva línea al final de cada fila
            }

            // Leer nuevamente el número de filas, columnas y modificaciones para la siguiente iteración
            F = scanner.nextInt();
            C = scanner.nextInt();
            N = scanner.nextInt();
        }

        scanner.close();
    }
}
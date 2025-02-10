package ud4.ejercicios;

import java.util.Scanner;

public class EspiralGalactica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer tamaño de la matriz
        int N = scanner.nextInt(); // Tamaño de la matriz

        while (N != 0) { // Continuar mientras N no sea 0
            int[][] matriz = new int[N][N];

            // Leer la matriz
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            // Contar estrellas en la espiral
            int totalEstrellas = contarEstrellasEnEspiral(matriz, N);
            System.out.println(totalEstrellas);

            // Leer el siguiente tamaño de la matriz
            N = scanner.nextInt(); // Tamaño de la matriz
        }

        scanner.close(); // Cerrar el escáner al final
    }

    private static int contarEstrellasEnEspiral(int[][] matriz, int N) {
        int totalEstrellas = 0;
        int x = N / 2; // Comenzar en el centro
        int y = N / 2; // Comenzar en el centro

        // Direcciones: arriba, derecha, abajo, izquierda
        int[][] direcciones = {
                {-1, 0}, // Arriba
                {0, 1},  // Derecha
                {1, 0},  // Abajo
                {0, -1}  // Izquierda
        };

        int pasos = 1; // Número de pasos en la dirección actual
        int direccion = 0; // Comenzar moviendo hacia arriba

        // Contar estrellas en la espiral
        for (int i = 0; i < N * N; i++) {
            totalEstrellas += matriz[x][y]; // Sumar estrellas en la posición actual

            // Mover en la dirección actual
            for (int j = 0; j < pasos; j++) {
                if (i >= N * N) break; // Salir si hemos recorrido todas las celdas
                x += direcciones[direccion][0];
                y += direcciones[direccion][1];

                // Sumar estrellas en la nueva posición
                if (x >= 0 && x < N && y >= 0 && y < N) {
                    totalEstrellas += matriz[x][y];
                }
            }

            // Cambiar dirección
            direccion = (direccion + 1) % 4;

            // Aumentar pasos cada dos direcciones
            if (direccion % 2 == 0) {
                pasos++;
            }
        }

        return totalEstrellas;
    }
}
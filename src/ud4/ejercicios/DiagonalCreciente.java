package ud4.ejercicios;

import java.util.Scanner;

public class DiagonalCreciente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        while ((N = scanner.nextInt()) != 0) {
            int[][] tablero = new int[N][N];
            boolean[] presente = new boolean[N + 1]; // Para verificar la presencia de números del 1 al N
            boolean posible = true;

            // Leer el tablero y verificar la diagonal
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tablero[i][j] = scanner.nextInt();
                }
                // Verificar el elemento de la diagonal
                int diagonalElemento = tablero[i][i];
                if (diagonalElemento < 1 || diagonalElemento > N || presente[diagonalElemento]) {
                    posible = false; // Elemento fuera de rango o duplicado
                }
                presente[diagonalElemento] = true; // Marcar el número como presente
            }

            if (!posible) {
                System.out.println("IMPOSIBLE");
            } else {
                // Contar movimientos necesarios para hacer la diagonal estrictamente creciente
                int movimientos = 0;
                for (int i = 0; i < N; i++) {
                    if (tablero[i][i] != i + 1) {
                        movimientos++;
                    }
                }
                System.out.println(movimientos);
            }
        }

        scanner.close();
    }
}
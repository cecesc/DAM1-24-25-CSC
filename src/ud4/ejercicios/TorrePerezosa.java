package ud4.ejercicios;

import java.util.Scanner;

public class TorrePerezosa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt(); // Leer el tamaño del tablero
            if (n == 0) break; // Terminar si n es 0

            char[][] tablero = new char[n][n];
            for (int i = 0; i < n; i++) {
                tablero[i] = scanner.next().toCharArray(); // Leer cada fila del tablero
            }

            // Crear la matriz dp para contar las formas
            long[][] dp = new long[n][n];
            dp[n - 1][0] = 1; // Hay una forma de estar en la posición inicial

            // Llenar la matriz dp
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (tablero[i][j] == 'X') {
                        dp[i][j] = 0; // Casilla no transitable
                    } else {
                        if (i < n - 1) {
                            dp[i][j] += dp[i + 1][j]; // Desde abajo
                        }
                        if (j > 0) {
                            dp[i][j] += dp[i][j - 1]; // Desde la izquierda
                        }
                    }
                }
            }

            // El resultado está en la esquina superior derecha
            System.out.println(dp[0][n - 1]);
        }

        scanner.close();
    }
}

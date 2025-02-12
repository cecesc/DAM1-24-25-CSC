package ud4.ejercicios;

import java.util.Scanner;

public class EligiendoCaramelos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer los pares de n y m
        System.out.println("Ingrese pares de n y m (0 0 para terminar):");
        int n, m;

        // Leer el primer par de n y m
        n = scanner.nextInt();
        m = scanner.nextInt();

        while (n != 0 || m != 0) {
            // Arreglo para almacenar las combinaciones
            long[] combinaciones = new long[m + 1];

            // Calcular combinaciones
            for (int k = 0; k <= m; k++) {
                combinaciones[k] = calcularCombinacion(n, k);
            }

            // Imprimir las combinaciones
            for (int k = 0; k <= m; k++) {
                System.out.print(combinaciones[k] + " ");
            }
            System.out.println(); // Nueva línea después de imprimir las combinaciones

            // Leer el siguiente par de n y m
            n = scanner.nextInt();
            m = scanner.nextInt();
        }

        scanner.close();
    }

    // Método para calcular combinaciones de n sobre k
    private static long calcularCombinacion(int n, int k) {
        if (k > n || k < 0) {
            return 0;
        }

        // Usar un arreglo para calcular el número de combinaciones
        long[][] combinacionesDP = new long[n + 1][k + 1];

        // Inicializar el arreglo
        for (int i = 0; i <= n; i++) {
            combinacionesDP[i][0] = 1; // C(n, 0) = 1
        }
        for (int j = 1; j <= k; j++) {
            combinacionesDP[0][j] = 0; // C(0, k) = 0 para k > 0
        }

        // Calcular combinaciones usando programación dinámica
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                combinacionesDP[i][j] = combinacionesDP[i - 1][j - 1] + combinacionesDP[i - 1][j]; // C(n, k) = C(n-1, k-1) + C(n-1, k)
            }
        }

        return combinacionesDP[n][k]; // Retornar el resultado
    }
}
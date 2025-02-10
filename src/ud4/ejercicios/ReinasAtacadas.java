package ud4.ejercicios;

import java.util.Scanner;

public class ReinasAtacadas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el tamaño del tablero y el número de reinas
        int n, m;

        // Leer hasta que se encuentre "0 0"
        n = scanner.nextInt();
        m = scanner.nextInt();

        while (n != 0 || m != 0) {
            // Arreglos para rastrear filas, columnas y diagonales
            boolean[] filas = new boolean[n + 1]; // Para filas (1 a n)
            boolean[] columnas = new boolean[n + 1]; // Para columnas (1 a n)
            boolean[] diagonalesPos = new boolean[2 * n + 1]; // Para diagonales positivas (x + y)
            boolean[] diagonalesNeg = new boolean[2 * n + 1]; // Para diagonales negativas (x - y)

            boolean atacadas = false; // Bandera para verificar si hay reinas atacadas

            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt(); // Leer coordenada X
                int y = scanner.nextInt(); // Leer coordenada Y

                // Verificar si la fila, columna o diagonal ya están ocupadas
                if (filas[y] || columnas[x] || diagonalesPos[x + y] || diagonalesNeg[x - y + n]) {
                    atacadas = true; // Hay reinas atacadas
                }

                // Marcar la posición de la reina en los arreglos
                filas[y] = true;
                columnas[x] = true;
                diagonalesPos[x + y] = true;
                diagonalesNeg[x - y + n] = true; // Ajuste para evitar índices negativos
            }

            // Imprimir el resultado
            if (atacadas) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente tamaño del tablero y número de reinas
            n = scanner.nextInt();
            m = scanner.nextInt();
        }

        scanner.close();
    }
}

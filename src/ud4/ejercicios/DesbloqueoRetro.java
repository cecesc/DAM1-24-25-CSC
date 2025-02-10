package ud4.ejercicios;

import java.util.Scanner;

public class DesbloqueoRetro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de filas, columnas y la posición inicial
        int F, C, f, c;

        // Leer la primera línea de entrada
        F = scanner.nextInt(); // Número de filas
        C = scanner.nextInt(); // Número de columnas

        // Continuar mientras no se reciba 0 0
        while (F != 0 && C != 0) {
            f = scanner.nextInt() - 1; // Fila inicial (convertir a índice 0)
            c = scanner.nextInt() - 1; // Columna inicial (convertir a índice 0)

            // Crear la matriz de desbloqueo
            char[][] matriz = new char[F][C];
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    matriz[i][j] = '.'; // Inicializar con puntos
                }
            }

            // Marcar la posición inicial
            matriz[f][c] = 'O';

            // Leer la secuencia de movimientos
            String movimientos = scanner.next();
            int prevRow = f;
            int prevCol = c;

            for (char mov : movimientos.toCharArray()) {
                if (mov == '5') break; // Fin de la secuencia

                int newRow = prevRow;
                int newCol = prevCol;

                // Determinar la nueva posición
                switch (mov) {
                    case '1': newRow--; newCol--; break; // Arriba-izquierda
                    case '2': newRow--; break; // Arriba
                    case '3': newRow--; newCol++; break; // Arriba-derecha
                    case '4': newCol--; break; // Izquierda
                    case '6': newCol++; break; // Derecha
                    case '7': newRow++; newCol--; break; // Abajo-izquierda
                    case '8': newRow++; break; // Abajo
                    case '9': newRow++; newCol++; break; // Abajo-derecha
                }

                // Marcar la nueva posición
                matriz[newRow][newCol] = 'O';

                // Dibujar la línea entre la posición anterior y la nueva
                if (prevRow == newRow) { // Movimiento horizontal
                    if (prevCol < newCol) {
                        matriz[prevRow][prevCol + 1] = '-';
                    } else {
                        matriz[prevRow][newCol + 1] = '-';
                    }
                } else if (prevCol == newCol) { // Movimiento vertical
                    if (prevRow < newRow) {
                        matriz[prevRow + 1][prevCol] = '|';
                    } else {
                        matriz[newRow + 1][prevCol] = '|';
                    }
                } else { // Movimiento diagonal
                    if (prevRow < newRow && prevCol < newCol) {
                        matriz[prevRow + 1][prevCol + 1] = '/';
                    } else if (prevRow < newRow && prevCol > newCol) {
                        matriz[prevRow + 1][prevCol - 1] = '\\';
                    } else if (prevRow > newRow && prevCol < newCol) {
                        matriz[prevRow - 1][prevCol + 1] = '\\';
                    } else {
                        matriz[prevRow - 1][prevCol - 1] = '/';
                    }
                }

                // Actualizar la posición anterior
                prevRow = newRow;
                prevCol = newCol;
            }

            // Imprimir el resultado
            System.out.println("+".repeat(C * 2 + 1)); // Marco superior
            for (int i = 0; i < F; i++) {
                System.out.print("|");
                for (int j = 0; j < C; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("|"); // Marco lateral
            }
            System.out.println("+".repeat(C * 2 + 1)); // Marco inferior

            // Leer la siguiente línea de entrada
            F = scanner.nextInt(); // Número de filas
            C = scanner.nextInt(); // Número de columnas
        }

        scanner.close();
    }
}
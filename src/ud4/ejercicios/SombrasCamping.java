package ud4.ejercicios;

import java.util.Scanner;

public class SombrasCamping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer conjunto de datos
        int c = scanner.nextInt(); // Número de columnas
        int f = scanner.nextInt(); // Número de filas
        int a = scanner.nextInt(); // Número de árboles

        while (c != 0 || f != 0 || a != 0) { // Continuar mientras no sea 0 0 0
            // Crear una matriz para el camping
            boolean[][] sombra = new boolean[f][c];

            // Leer las posiciones de los árboles
            for (int i = 0; i < a; i++) {
                int col = scanner.nextInt() - 1; // Convertir a índice 0
                int row = scanner.nextInt() - 1; // Convertir a índice 0

                // Marcar la posición del árbol
                sombra[row][col] = true;

                // Marcar las parcelas adyacentes que recibirán sombra
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue; // Ignorar el árbol mismo
                        int newRow = row + dr;
                        int newCol = col + dc;

                        // Verificar si la nueva posición está dentro de los límites
                        if (newRow >= 0 && newRow < f && newCol >= 0 && newCol < c) {
                            sombra[newRow][newCol] = true; // Marcar como sombreada
                        }
                    }
                }
            }

            // Contar las parcelas que disfrutan de sombra
            int parcelasConSombra = 0;
            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    if (sombra[i][j]) {
                        parcelasConSombra++;
                    }
                }
            }

            // Imprimir el resultado
            System.out.println(parcelasConSombra);

            // Leer el siguiente conjunto de datos
            c = scanner.nextInt(); // Número de columnas
            f = scanner.nextInt(); // Número de filas
            a = scanner.nextInt(); // Número de árboles
        }

        scanner.close();
    }
}

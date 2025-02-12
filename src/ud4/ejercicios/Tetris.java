package ud4.ejercicios;

import java.util.Scanner;

public class Tetris {

    // Definición de las piezas y sus rotaciones
    private static final int[][][][] PIEZAS = {
            // Pieza 1: Barra
            {
                    {{1, 1, 1, 1}}, // 0 grados
                    {{1}, {1}, {1}, {1}}, // 90 grados
                    {{1, 1, 1, 1}}, // 180 grados
                    {{1}, {1}, {1}, {1}}  // 270 grados
            },
            // Pieza 2: J
            {
                    {{0, 0, 1},
                            {1, 1, 1}}, // 0 grados
                    {{1, 0},
                            {1, 0},
                            {1, 1}}, // 90 grados
                    {{1, 1, 1},
                            {0, 0, 1}}, // 180 grados
                    {{1, 1},
                            {0, 1},
                            {0, 1}}  // 270 grados
            },
            // Pieza 3: L
            {
                    {{1, 0, 0},
                            {1, 1, 1}}, // 0 grados
                    {{1, 1},
                            {1, 0},
                            {1, 0}}, // 90 grados
                    {{1, 1, 1},
                            {0, 0, 1}}, // 180 grados
                    {{0, 1},
                            {0, 1},
                            {1, 1}}  // 270 grados
            },
            // Pieza 4: Cuadrado
            {
                    {{1, 1},
                            {1, 1}}, // 0 grados
                    {{1, 1},
                            {1, 1}}, // 90 grados
                    {{1, 1},
                            {1, 1}}, // 180 grados
                    {{1, 1},
                            {1, 1}}  // 270 grados
            },
            // Pieza 5: S
            {
                    {{0, 1, 1},
                            {1, 1, 0}}, // 0 grados
                    {{1, 0},
                            {1, 1},
                            {0, 1}}, // 90 grados
                    {{0, 1, 1},
                            {1, 1, 0}}, // 180 grados
                    {{1, 0},
                            {1, 1},
                            {0, 1}}  // 270 grados
            },
            // Pieza 6: T
            {
                    {{0, 1, 0},
                            {1, 1, 1}}, // 0 grados
                    {{1, 0},
                            {1, 1},
                            {1, 0}}, // 90 grados
                    {{1, 1, 1},
                            {0, 1, 0}}, // 180 grados
                    {{0, 1},
                            {1, 1},
                            {0, 1}}  // 270 grados
            },
            // Pieza 7: Z
            {
                    {{1, 1, 0},
                            {0, 1, 1}}, // 0 grados
                    {{0, 1},
                            {1, 1},
                            {1, 0}}, // 90 grados
                    {{1, 1, 0},
                            {0, 1, 1}}, // 180 grados
                    {{0, 1},
                            {1, 1},
                            {1, 0}}  // 270 grados
            }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de columnas y piezas
        System.out.print("Ingrese el número de columnas y piezas: ");
        int C = scanner.nextInt(); // Número de columnas
        int N = scanner.nextInt(); // Número de piezas

        while (C != 0 && N != 0) { // Continuar mientras no se reciba 0 0
            int[] alturas = new int[C]; // Alturas de cada columna

            for (int i = 0; i < N; i++) {
                int I = scanner.nextInt(); // Identificador de la pieza
                int R = scanner.nextInt(); // Rotación
                int P = scanner.nextInt(); // Posición

                // Obtener la pieza y su rotación
                int[][] pieza = rotarPieza(I - 1, R);
                int ancho = pieza[0].length;
                int altura = pieza.length;

                // Determinar la altura de colocación
                int minAltura = Integer.MAX_VALUE;
                for (int j = 0; j < ancho; j++) {
                    minAltura = Math.min(minAltura, alturas[P - 1 + j]);
                }

                // Actualizar las alturas
                for (int j = 0; j < ancho; j++) {
                    alturas[P - 1 + j] = minAltura + altura;
                }
            }

            // Imprimir las alturas finales
            System.out.print("Alturas finales: ");
            for (int h : alturas) {
                System.out.print(h + " ");
            }
            System.out.println();

            // Leer nuevamente el número de columnas y piezas para la siguiente iteración
            System.out.print("Ingrese el número de columnas y piezas: ");
            C = scanner.nextInt();
            N = scanner.nextInt();
        }

        scanner.close();
    }

    // Método para rotar la pieza según el ángulo
    private static int[][] rotarPieza(int tipo, int rotacion) {
        return PIEZAS[tipo][rotacion / 90 % 4]; // Obtener la pieza rotada
    }
}
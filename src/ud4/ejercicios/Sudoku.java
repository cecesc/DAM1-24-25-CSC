package ud4.ejercicios;

import java.util.Scanner;

public class Sudoku {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de casos de prueba: ");
        int casos = scanner.nextInt(); // Leer el número de casos de prueba
        scanner.nextLine(); // Consumir la línea restante

        for (int caso = 0; caso < casos; caso++) {
            int[][] sudoku = new int[9][9];

            System.out.println("Ingrese el Sudoku (9 líneas de 9 números cada una):");
            // Leer el Sudoku
            for (int i = 0; i < 9; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(line[j]);
                }
            }

            // Verificar si el Sudoku es correcto
            if (isValidSudoku(sudoku)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    private static boolean isValidSudoku(int[][] sudoku) {
        // Verificar filas y columnas
        for (int i = 0; i < 9; i++) {
            boolean[] fila = new boolean[9];
            boolean[] columna = new boolean[9];
            for (int j = 0; j < 9; j++) {
                // Verificar fila
                int numFila = sudoku[i][j] - 1; // Convertir a índice 0
                if (numFila < 0 || numFila >= 9 || fila[numFila]) {
                    return false; // Duplicado en la fila o número fuera de rango
                }
                fila[numFila] = true;

                // Verificar columna
                int numColumna = sudoku[j][i] - 1; // Convertir a índice 0
                if (numColumna < 0 || numColumna >= 9 || columna[numColumna]) {
                    return false; // Duplicado en la columna o número fuera de rango
                }
                columna[numColumna] = true;
            }
        }

        // Verificar subcuadrículas de 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] subcuadricula = new boolean[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int numSubcuadricula = sudoku[i + k][j + l] - 1; // Convertir a índice 0
                        if (numSubcuadricula < 0 || numSubcuadricula >= 9 || subcuadricula[numSubcuadricula]) {
                            return false; // Duplicado en la subcuadrícula o número fuera de rango
                        }
                        subcuadricula[numSubcuadricula] = true;
                    }
                }
            }
        }

        return true; // Sudoku es válido
    }
}
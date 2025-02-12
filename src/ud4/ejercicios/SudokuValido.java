package ud4.ejercicios;

import java.util.Scanner;

public class SudokuValido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de casos de prueba: ");
        int casosPrueba = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        // Procesar cada caso de prueba
        for (int caso = 0; caso < casosPrueba; caso++) {
            // Leer el Sudoku
            char[][] sudoku = new char[9][9];
            int celdasRellenas = 0;

            System.out.println("Ingrese el Sudoku (9 líneas, use '-' para celdas vacías):");
            for (int i = 0; i < 9; i++) {
                String linea = scanner.nextLine().trim();
                sudoku[i] = linea.toCharArray();
                // Contar celdas rellenas
                for (char c : linea.toCharArray()) {
                    if (c != '-') {
                        celdasRellenas++;
                    }
                }
            }

            // Leer la línea en blanco entre casos de prueba
            if (caso < casosPrueba - 1) {
                scanner.nextLine();
            }

            // Verificar condiciones
            boolean esValido = celdasRellenas <= 32 && verificarSimetria(sudoku);

            // Imprimir resultado
            System.out.println(esValido ? "SI" : "NO");
        }

        scanner.close();
    }

    private static boolean verificarSimetria(char[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Comprobar la simetría rotacional
                if (sudoku[i][j] != '-' && sudoku[i][j] != sudoku[8 - i][8 - j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
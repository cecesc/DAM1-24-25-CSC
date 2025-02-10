package ud4.ejercicios;

import java.util.Scanner;

public class CubosRubik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer conjunto de datos
        int f = scanner.nextInt(); // Número de filas de cubos
        int c = scanner.nextInt(); // Número de columnas de cubos

        while (f != 0 || c != 0) { // Continuar mientras no sea 0 0
            // Crear una matriz para la figura original
            char[][][] figura = new char[f][c][9]; // Matriz para la figura original

            // Leer la configuración de la figura
            for (int i = 0; i < 3 * f; i++) {
                String linea = scanner.next();
                for (int j = 0; j < 3 * c; j++) {
                    int cuboFila = i / 3; // Fila del cubo
                    int cuboCol = j / 3; // Columna del cubo
                    int pixelFila = i % 3; // Fila del pixel dentro del cubo
                    int pixelCol = j % 3; // Columna del pixel dentro del cubo
                    figura[cuboFila][cuboCol][pixelFila * 3 + pixelCol] = linea.charAt(j);
                }
            }

            // Leer el número de cubos a colocar
            int numCubos = scanner.nextInt();
            String[] cubos = new String[numCubos];

            // Leer la configuración de cada cubo
            for (int i = 0; i < numCubos; i++) {
                StringBuilder cubo = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    cubo.append(scanner.next());
                }
                cubos[i] = cubo.toString();
            }

            // Buscar las posiciones de los cubos
            for (String cubo : cubos) {
                boolean encontrado = false;
                for (int i = 0; i < f; i++) {
                    for (int j = 0; j < c; j++) {
                        StringBuilder figuraCubo = new StringBuilder();
                        for (int k = 0; k < 3; k++) {
                            figuraCubo.append(figura[i][j][k]);
                        }
                        if (figuraCubo.toString().equals(cubo)) {
                            System.out.println((i + 1) + " " + (j + 1)); // Imprimir posición (1-indexed)
                            encontrado = true;
                            break; // Salir del bucle si se encuentra el cubo
                        }
                    }
                    if (encontrado) {
                        break; // Salir del bucle si se encuentra el cubo
                    }
                }
                if (!encontrado) {
                    System.out.println("NO SE USA");
                }
            }

            // Leer el siguiente conjunto de datos
            f = scanner.nextInt(); // Número de filas de cubos
            c = scanner.nextInt(); // Número de columnas de cubos
        }

        scanner.close();
    }
}
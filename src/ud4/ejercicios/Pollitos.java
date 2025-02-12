package ud4.ejercicios;

import java.util.Scanner;

public class Pollitos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de filas, columnas y pollitos
        System.out.print("Ingrese el número de filas: ");
        int f = scanner.nextInt(); // Número de filas
        System.out.print("Ingrese el número de columnas: ");
        int c = scanner.nextInt(); // Número de columnas
        System.out.print("Ingrese el número de pollitos: ");
        int n = scanner.nextInt(); // Número de pollitos

        // Crear una matriz para contar los granos
        int[][] granos = new int[f][c];

        // Procesar cada pollito
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la posición inicial del pollito " + (i + 1) + " (fila columna dirección pasos): ");
            int v = scanner.nextInt() - 1; // Convertir a índice 0
            int h = scanner.nextInt() - 1; // Convertir a índice 0
            char direccion = scanner.next().charAt(0); // Dirección inicial
            int pasos = scanner.nextInt(); // Pasos que puede dar

            // Determinar la dirección inicial
            int dirX = 0, dirY = 0;
            switch (direccion) {
                case 'N': dirX = -1; break;
                case 'S': dirX = 1; break;
                case 'E': dirY = 1; break;
                case 'W': dirY = -1; break;
                default:
                    System.out.println("Dirección no válida. Debe ser N, S, E o W.");
                    return; // Salir si la dirección es inválida
            }

            // Simular el movimiento en espiral
            int x = v, y = h;
            for (int j = 0; j < pasos; j++) {
                // Contar el grano en la posición actual
                if (isValid(x, y, f, c)) {
                    granos[x][y]++;
                } else {
                    break; // Si se sale del gallinero, detener el movimiento
                }

                // Mover en espiral
                if (j % 2 == 0) { // Cambiar dirección cada dos pasos
                    if (j % 4 == 0) { // N o S
                        x += dirX;
                    } else { // E o W
                        y += dirY;
                    }
                } else {
                    if (j % 4 == 1) { // E o W
                        y += dirY;
                    } else { // N o S
                        x += dirX;
                    }
                }
            }
        }

        // Imprimir el resultado
        System.out.println("Granos recogidos en el gallinero:");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(granos[i][j]);
                if (j < c - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    private static boolean isValid(int x, int y, int f, int c) {
        return x >= 0 && x < f && y >= 0 && y < c; // Verificar límites
    }
}
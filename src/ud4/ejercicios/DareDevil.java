package ud4.ejercicios;

import java.util.Scanner;

public class DareDevil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int F, C; // Declarar las variables fuera del bucle
        F = scanner.nextInt(); // Leer el número de filas
        C = scanner.nextInt(); // Leer el número de columnas

        while (F != 0 || C != 0) { // Continuar mientras no se reciba 0 0
            char[][] sala = new char[F][C];

            // Leer el mapa de la sala
            for (int i = 0; i < F; i++) {
                sala[i] = scanner.next().toCharArray();
            }

            int N = scanner.nextInt(); // Número de consultas

            // Procesar cada consulta
            for (int i = 0; i < N; i++) {
                int fila = scanner.nextInt() - 1; // Convertir a índice 0
                int columna = scanner.nextInt() - 1; // Convertir a índice 0
                String direccion = scanner.next();

                int distancia = encontrarVillano(sala, fila, columna, direccion);
                if (distancia == -1) {
                    System.out.println("NINGUNO");
                } else {
                    System.out.println(distancia);
                }
            }

            System.out.println("---"); // Separador al final de cada caso de prueba

            // Leer nuevamente el número de filas y columnas para la siguiente iteración
            F = scanner.nextInt();
            C = scanner.nextInt();
        }

        scanner.close();
    }

    private static int encontrarVillano(char[][] sala, int fila, int columna, String direccion) {
        int distancia = 0;

        switch (direccion) {
            case "IZQUIERDA":
                for (int j = columna - 1; j >= 0; j--) {
                    distancia++;
                    if (sala[fila][j] == 'X') {
                        return distancia;
                    }
                }
                break;
            case "DERECHA":
                for (int j = columna + 1; j < sala[0].length; j++) {
                    distancia++;
                    if (sala[fila][j] == 'X') {
                        return distancia;
                    }
                }
                break;
            case "ARRIBA":
                for (int i = fila - 1; i >= 0; i--) {
                    distancia++;
                    if (sala[i][columna] == 'X') {
                        return distancia;
                    }
                }
                break;
            case "ABAJO":
                for (int i = fila + 1; i < sala.length; i++) {
                    distancia++;
                    if (sala[i][columna] == 'X') {
                        return distancia;
                    }
                }
                break;
        }

        return -1; // Si no se encuentra ningún villano
    }
}
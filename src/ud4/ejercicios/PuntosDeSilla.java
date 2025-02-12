package ud4.ejercicios;

import java.util.Scanner;

public class PuntosDeSilla {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer caso de prueba
        System.out.print("Ingrese el número de filas y columnas (0 0 para terminar): ");
        int F = scanner.nextInt(); // Número de filas
        int C = scanner.nextInt(); // Número de columnas

        while (F != 0 && C != 0) { // Continuar mientras no se reciba 0 0
            int[][] matriz = new int[F][C];

            // Leer la matriz
            System.out.println("Ingrese los elementos de la matriz:");
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            boolean tienePuntoDeSilla = false;

            // Buscar puntos de silla
            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    int elemento = matriz[i][j];

                    // Verificar si es un punto de silla
                    boolean esMinimoEnFila = true;
                    boolean esMaximoEnColumna = true;
                    boolean esMaximoEnFila = true;
                    boolean esMinimoEnColumna = true;

                    // Verificar fila
                    for (int k = 0; k < C; k++) {
                        if (matriz[i][k] < elemento) {
                            esMinimoEnFila = false;
                        }
                        if (matriz[i][k] > elemento) {
                            esMaximoEnFila = false;
                        }
                    }

                    // Verificar columna
                    for (int k = 0; k < F; k++) {
                        if (matriz[k][j] < elemento) {
                            esMaximoEnColumna = false;
                        }
                        if (matriz[k][j] > elemento) {
                            esMinimoEnColumna = false;
                        }
                    }

                    // Si cumple alguna de las condiciones de punto de silla
                    if ((esMinimoEnFila && esMaximoEnColumna) || (esMaximoEnFila && esMinimoEnColumna)) {
                        tienePuntoDeSilla = true;
                        break; // No necesitamos seguir buscando
                    }
                }
                if (tienePuntoDeSilla) {
                    break; // No necesitamos seguir buscando
                }
            }

            // Imprimir resultado
            if (tienePuntoDeSilla) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente caso de prueba
            System.out.print("Ingrese el número de filas y columnas (0 0 para terminar): ");
            F = scanner.nextInt(); // Número de filas
            C = scanner.nextInt(); // Número de columnas
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
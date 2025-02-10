package ud4.ejercicios;

import java.util.Scanner;

public class CuadradoRubik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer conjunto de datos
        int n = scanner.nextInt(); // Leer el tamaño del cuadrado

        // Continuar procesando mientras n no sea 0
        while (n != 0) {
            // Crear una matriz para la configuración del cuadrado
            char[][] cuadrado = new char[n][n];

            // Leer la configuración inicial del cuadrado
            for (int i = 0; i < n; i++) {
                cuadrado[i] = scanner.next().toCharArray();
            }

            // Leer las operaciones
            scanner.nextLine(); // Consumir la línea restante
            String operaciones = scanner.nextLine();
            String[] ops = operaciones.split(" ");

            // Procesar cada operación
            for (String op : ops) {
                if (op.equals("x")) {
                    break; // Terminar si se recibe "x"
                }

                char tipo = op.charAt(0); // 'f' o 'c'
                int v = Integer.parseInt(op.substring(1)); // Valor de la operación

                if (tipo == 'f') {
                    // Movimiento en fila
                    int fila = v - 1; // Convertir a índice 0
                    if (v > 0) {
                        // Desplazamiento a la derecha
                        char temp = cuadrado[fila][n - 1];
                        for (int j = n - 1; j > 0; j--) {
                            cuadrado[fila][j] = cuadrado[fila][j - 1];
                        }
                        cuadrado[fila][0] = temp;
                    } else {
                        // Desplazamiento a la izquierda
                        char temp = cuadrado[fila][0];
                        for (int j = 0; j < n - 1; j++) {
                            cuadrado[fila][j] = cuadrado[fila][j + 1];
                        }
                        cuadrado[fila][n - 1] = temp;
                    }
                } else if (tipo == 'c') {
                    // Movimiento en columna
                    int columna = Math.abs(v) - 1; // Convertir a índice 0
                    if (v > 0) {
                        // Desplazamiento hacia abajo
                        char temp = cuadrado[n - 1][columna];
                        for (int j = n - 1; j > 0; j--) {
                            cuadrado[j][columna] = cuadrado[j - 1][columna];
                        }
                        cuadrado[0][columna] = temp;
                    } else {
                        // Desplazamiento hacia arriba
                        char temp = cuadrado[0][columna];
                        for (int j = 0; j < n - 1; j++) {
                            cuadrado[j][columna] = cuadrado[j + 1][columna];
                        }
                        cuadrado[n - 1][columna] = temp;
                    }
                }
            }

            // Imprimir la configuración final
            for (int i = 0; i < n; i++) {
                System.out.println(cuadrado[i]);
            }
            System.out.println("---"); // Línea de separación

            // Leer el siguiente conjunto de datos
            n = scanner.nextInt(); // Leer el tamaño del cuadrado
        }

        scanner.close();
    }
}
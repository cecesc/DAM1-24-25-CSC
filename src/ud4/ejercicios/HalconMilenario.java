package ud4.ejercicios;

import java.util.Scanner;

public class HalconMilenario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de filas y columnas
        int F = scanner.nextInt(); // Número de filas
        int C = scanner.nextInt(); // Número de columnas

        while (F != 0 && C != 0) {
            char[][] campo = new char[F][C];
            int startX = -1, startY = -1, endX = -1, endY = -1;

            // Leer el campo de asteroides
            for (int i = 0; i < F; i++) {
                String line = scanner.next();
                for (int j = 0; j < C; j++) {
                    campo[i][j] = line.charAt(j);
                    if (campo[i][j] == 'S') {
                        startX = i;
                        startY = j;
                    } else if (campo[i][j] == 'F') {
                        endX = i;
                        endY = j;
                    }
                }
            }

            // Verificar si hay un camino desde S a F
            boolean[][] visitado = new boolean[F][C];
            boolean hayCamino = busquedaEnProfundidad(campo, startX, startY, endX, endY, visitado);

            // Imprimir el resultado
            if (hayCamino) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente caso
            F = scanner.nextInt(); // Número de filas
            C = scanner.nextInt(); // Número de columnas
        }

        scanner.close();
    }

    private static boolean busquedaEnProfundidad(char[][] campo, int x, int y, int endX, int endY, boolean[][] visitado) {
        // Verificar límites
        if (x < 0 || x >= campo.length || y < 0 || y >= campo[0].length) {
            return false;
        }
        // Si ya hemos visitado esta celda
        if (visitado[x][y]) {
            return false;
        }
        // Marcar la celda como visitada
        visitado[x][y] = true;

        // Si hemos llegado a la celda de salida
        if (x == endX && y == endY) {
            return true;
        }

        // Explorar las celdas adyacentes (arriba, abajo, izquierda, derecha)
        return busquedaEnProfundidad(campo, x - 1, y, endX, endY, visitado) || // Arriba
                busquedaEnProfundidad(campo, x + 1, y, endX, endY, visitado) || // Abajo
                busquedaEnProfundidad(campo, x, y - 1, endX, endY, visitado) || // Izquierda
                busquedaEnProfundidad(campo, x, y + 1, endX, endY, visitado);   // Derecha
    }
}
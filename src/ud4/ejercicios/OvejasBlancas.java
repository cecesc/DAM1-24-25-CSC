package ud4.ejercicios;

import java.util.Scanner;

public class OvejasBlancas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el ancho y alto de la imagen
        System.out.println("Ingrese el ancho y alto de la imagen (0 0 para terminar):");
        int ancho = scanner.nextInt(); // Ancho de la imagen
        int alto = scanner.nextInt(); // Alto de la imagen

        if (ancho == 0 && alto == 0) {
            return; // Terminar si se recibe 0 0
        }

        char[][] imagen = new char[alto][ancho];

        // Leer la imagen
        System.out.println("Ingrese la imagen:");
        for (int i = 0; i < alto; i++) {
            imagen[i] = scanner.next().toCharArray();
        }

        // Verificar si hay alguna oveja blanca
        boolean hayOvejaBlanca = false;

        // Recorrer la imagen para encontrar las ovejas
        for (int i = 1; i < alto - 1; i++) {
            for (int j = 1; j < ancho - 1; j++) {
                // Si encontramos una parte de una oveja negra
                if (imagen[i][j] == 'X') {
                    // Comprobar si hay un blanco dentro de la silueta
                    if (isOvejaBlanca(imagen, i, j, ancho, alto)) {
                        hayOvejaBlanca = true;
                        break;
                    }
                }
            }
            if (hayOvejaBlanca) {
                break;
            }
        }

        // Imprimir el resultado
        if (hayOvejaBlanca) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        scanner.close(); // Cerrar el escáner al final
    }

    private static boolean isOvejaBlanca(char[][] imagen, int x, int y, int ancho, int alto) {
        // Usamos una cola para realizar una búsqueda en profundidad (DFS)
        boolean[][] visitado = new boolean[alto][ancho];
        return dfs(imagen, x, y, visitado);
    }

    private static boolean dfs(char[][] imagen, int x, int y, boolean[][] visitado) {
        // Si estamos fuera de los límites
        if (x < 0 || x >= imagen.length || y < 0 || y >= imagen[0].length) {
            return false;
        }
        // Si ya hemos visitado este píxel
        if (visitado[x][y]) {
            return false;
        }
        // Marcar este píxel como visitado
        visitado[x][y] = true;

        // Si encontramos un blanco, retornamos verdadero
        if (imagen[x][y] == '.') {
            return true;
        }

        // Si encontramos un negro, seguimos buscando en las 4 direcciones
        if (imagen[x][y] == 'X') {
            return dfs(imagen, x + 1, y, visitado) || // Abajo
                    dfs(imagen, x - 1, y, visitado) || // Arriba
                    dfs(imagen, x, y + 1, visitado) || // Derecha
                    dfs(imagen, x, y - 1, visitado);   // Izquierda
        }

        return false; // Si no es negro ni blanco
    }
}
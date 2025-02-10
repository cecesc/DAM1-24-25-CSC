package ud4.ejercicios;

import java.util.Scanner;

public class CuelloPilotos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el ancho y alto del circuito
        int tx = scanner.nextInt(); // Ancho del circuito
        int ty = scanner.nextInt(); // Alto del circuito

        while (tx != 0 && ty != 0) {
            char[][] circuito = new char[ty][tx];
            int startX = -1, startY = -1;

            // Leer el mapa del circuito
            for (int i = 0; i < ty; i++) {
                String line = scanner.next();
                circuito[i] = line.toCharArray();
                // Encontrar la posición de inicio 'O'
                if (line.contains("O")) {
                    startX = i;
                    startY = line.indexOf("O");
                }
            }

            // Contar las curvas
            int[] curvas = contarCurvas(circuito, startX, startY, ty, tx);
            System.out.println(curvas[0] + " " + curvas[1]);

            // Leer el siguiente caso
            tx = scanner.nextInt(); // Ancho del circuito
            ty = scanner.nextInt(); // Alto del circuito
        }

        scanner.close();
    }

    private static int[] contarCurvas(char[][] circuito, int startX, int startY, int ty, int tx) {
        int curvasIzquierda = 0;
        int curvasDerecha = 0;

        // Direcciones: 0 = arriba, 1 = derecha, 2 = abajo, 3 = izquierda
        int[][] direcciones = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dir = 1; // Comenzamos moviéndonos a la derecha
        int x = startX;
        int y = startY;

        // Recorrer el circuito
        while (true) {
            // Mover en la dirección actual
            x += direcciones[dir][0];
            y += direcciones[dir][1];

            // Verificar si hemos salido del circuito
            if (x < 0 || x >= ty || y < 0 || y >= tx || circuito[x][y] == '.') {
                // Si no hay circuito, cambiar de dirección
                dir = (dir + 1) % 4; // Girar a la derecha
                x -= direcciones[dir][0];
                y -= direcciones[dir][1];

                // Verificar si hay circuito en la nueva dirección
                if (circuito[x + direcciones[dir][0]][y + direcciones[dir][1]] == '#') {
                    // Contar curva a la derecha
                    curvasDerecha++;
                }
            } else if (circuito[x][y] == '#') {
                // Si encontramos una curva
                if (dir == 0) { // Arriba
                    if (circuito[x][y + 1] == '#') { // Derecha
                        curvasDerecha++;
                    } else { // Izquierda
                        curvasIzquierda++;
                    }
                } else if (dir == 1) { // Derecha
                    if (circuito[x + 1][y] == '#') { // Abajo
                        curvasDerecha++;
                    } else { // Arriba
                        curvasIzquierda++;
                    }
                } else if (dir == 2) { // Abajo
                    if (circuito[x][y - 1] == '#') { // Izquierda
                        curvasDerecha++;
                    } else { // Derecha
                        curvasIzquierda++;
                    }
                } else if (dir == 3) { // Izquierda
                    if (circuito[x - 1][y] == '#') { // Arriba
                        curvasDerecha++;
                    } else { // Abajo
                        curvasIzquierda++;
                    }
                }
            }

            // Verificar si hemos vuelto al inicio
            if (x == startX && y == startY) {
                break; // Salir del bucle si hemos vuelto al inicio
            }
        }

        return new int[]{curvasIzquierda, curvasDerecha};
    }
}
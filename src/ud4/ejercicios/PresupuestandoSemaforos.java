package ud4.ejercicios;

import java.util.Scanner;

public class PresupuestandoSemaforos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el ancho y alto del pueblo
        int ancho = scanner.nextInt(); // Ancho del pueblo
        int alto = scanner.nextInt(); // Alto del pueblo

        while (ancho != 0 && alto != 0) {
            char[][] pueblo = new char[alto][ancho];

            // Leer el plano del pueblo
            for (int i = 0; i < alto; i++) {
                pueblo[i] = scanner.next().toCharArray();
            }

            // Contar el número de semáforos necesarios
            int semaforos = contarSemaforos(pueblo, ancho, alto);
            System.out.println(semaforos);

            // Leer el siguiente caso
            ancho = scanner.nextInt(); // Ancho del pueblo
            alto = scanner.nextInt(); // Alto del pueblo
        }

        scanner.close();
    }

    private static int contarSemaforos(char[][] pueblo, int ancho, int alto) {
        int semaforos = 0;

        // Recorrer cada celda del pueblo
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                // Si encontramos una calle
                if (pueblo[i][j] == '#') {
                    // Contar las calles adyacentes
                    int count = 0;
                    if (i > 0 && pueblo[i - 1][j] == '#') count++; // Arriba
                    if (i < alto - 1 && pueblo[i + 1][j] == '#') count++; // Abajo
                    if (j > 0 && pueblo[i][j - 1] == '#') count++; // Izquierda
                    if (j < ancho - 1 && pueblo[i][j + 1] == '#') count++; // Derecha

                    // Si hay más de una calle adyacente, es una intersección
                    if (count > 1) {
                        semaforos++;
                    }
                }
            }
        }

        return semaforos;
    }
}
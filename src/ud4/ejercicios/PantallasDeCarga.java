package ud4.ejercicios;

import java.util.Scanner;

public class PantallasDeCarga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer caso de prueba
        int ancho = scanner.nextInt(); // Ancho de la imagen
        int alto = scanner.nextInt(); // Alto de la imagen

        while (ancho != 0 && alto != 0) { // Continuar mientras no se reciba 0 0
            char[][] imagen = new char[alto][ancho];

            // Leer la imagen
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    imagen[i][j] = scanner.next().charAt(0);
                }
            }

            boolean esRepresentable = true;

            // Verificar bloques de 8x8
            for (int i = 0; i < alto; i += 8) {
                for (int j = 0; j < ancho; j += 8) {
                    // Contar colores en el bloque de 8x8
                    boolean[] colores = new boolean[15]; // Para las letras A-O (15 colores)
                    int count = 0;

                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            char pixel = imagen[i + k][j + l];
                            int colorIndex = pixel - 'A'; // Convertir letra a índice (0-14)
                            if (!colores[colorIndex]) {
                                colores[colorIndex] = true; // Marcar color como presente
                                count++;
                            }
                        }
                    }

                    // Verificar si hay más de 2 colores
                    if (count > 2) {
                        esRepresentable = false;
                        break;
                    }
                }
                if (!esRepresentable) {
                    break;
                }
            }

            // Imprimir resultado
            if (esRepresentable) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente caso de prueba
            ancho = scanner.nextInt(); // Ancho de la imagen
            alto = scanner.nextInt(); // Alto de la imagen
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class BocadillosHormigaReina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de cortezas
        int n = scanner.nextInt();

        while (n != 0) {
            long[] cortezas = new long[n]; // Arreglo para los tamaños de las cortezas

            // Leer los tamaños de las cortezas
            for (int i = 0; i < n; i++) {
                cortezas[i] = scanner.nextLong();
            }

            long sumaTotal = 0;
            for (long c : cortezas) {
                sumaTotal += c; // Calcular la suma total
            }

            long sumaDerecha = 0; // Suma de los cachos a la derecha
            boolean encontrado = false; // Bandera para indicar si se encontró una tapa
            long mejorTapa = 0; // Mejor tapa encontrada
            int mejorPosicion = -1; // Posición de la mejor tapa

            // Recorrer los cachos
            for (int i = 0; i < n; i++) {
                // La tapa es el cacho actual
                long tapa = cortezas[i];

                // La suma a la derecha es la suma total menos la tapa
                sumaDerecha = sumaTotal - tapa;

                // Verificar si la tapa es igual a la suma a la derecha
                if (tapa == sumaDerecha) {
                    // Si encontramos una tapa mejor (más grande), actualizamos
                    if (tapa > mejorTapa) {
                        mejorTapa = tapa;
                        mejorPosicion = i + 1; // Guardar la posición (1-indexed)
                        encontrado = true; // Marcamos que encontramos una tapa
                    }
                }
            }

            // Imprimir el resultado
            if (encontrado) {
                System.out.println("SI " + mejorPosicion);
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente número de cortezas
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
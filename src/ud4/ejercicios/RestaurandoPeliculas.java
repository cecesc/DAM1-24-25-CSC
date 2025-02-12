package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class RestaurandoPeliculas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número total de fotogramas y el número de copias
        System.out.print("Ingrese el número total de fotogramas y el número de copias (0 0 para terminar): ");
        long totalFotogramas = scanner.nextLong();
        int numCopias = scanner.nextInt();

        // Terminar si se encuentra con dos ceros
        if (totalFotogramas == 0 && numCopias == 0) {
            scanner.close();
            return;
        }

        // Crear un arreglo para marcar los fotogramas cubiertos
        boolean[] fotogramasCubiertos = new boolean[(int) totalFotogramas + 1];

        // Leer las copias y sus fragmentos
        for (int i = 0; i < numCopias; i++) {
            System.out.print("Ingrese el número de secuencias de fotogramas aprovechables para la copia " + (i + 1) + ": ");
            int numFragmentos = scanner.nextInt();

            for (int j = 0; j < numFragmentos; j++) {
                System.out.print("Ingrese el fragmento (inicio,fin): ");
                String fragmento = scanner.next();
                String[] partes = fragmento.split(",");
                int inicio = Integer.parseInt(partes[0]);
                int fin = Integer.parseInt(partes[1]);

                // Marcar los fotogramas cubiertos
                for (int k = inicio; k <= fin; k++) {
                    fotogramasCubiertos[k] = true;
                }
            }
        }

        // Verificar si todos los fotogramas están cubiertos
        boolean completo = true;
        for (int i = 1; i <= totalFotogramas; i++) {
            if (!fotogramasCubiertos[i]) {
                completo = false;
                break;
            }
        }

        // Imprimir el resultado
        if (completo) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
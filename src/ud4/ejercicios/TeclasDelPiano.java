package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class TeclasDelPiano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mapeo de notas a índices
        String[] notas = {
                "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"
        };

        // Leer el número de notas
        int n = scanner.nextInt();

        while (n != 0) {
            // Arreglo para contar las pulsaciones de cada tecla
            int[] pulsaciones = new int[7 * 12]; // 7 octavas * 12 notas

            scanner.nextLine(); // Consumir el salto de línea
            String[] notasCancion = scanner.nextLine().split(" "); // Leer las notas

            for (String nota : notasCancion) {
                // Extraer la nota, alteración y octava
                String nombreNota = nota.substring(0, nota.length() - 2);
                char alteracion = nota.charAt(nota.length() - 2);
                int octava = Character.getNumericValue(nota.charAt(nota.length() - 1));

                // Calcular el índice en el arreglo de pulsaciones
                int indice = (octava - 1) * 12; // Base de la octava
                for (int i = 0; i < notas.length; i++) {
                    if (notas[i].equals(nombreNota)) {
                        indice += i; // Sumar el índice de la nota
                        break;
                    }
                }

                // Ajustar el índice según la alteración
                if (alteracion == '#') {
                    indice++; // Sostenido
                } else if (alteracion == 'b') {
                    indice--; // Bemol
                }

                // Incrementar el contador de pulsaciones
                pulsaciones[indice]++;
            }

            // Encontrar el rango de pulsaciones a imprimir
            int inicio = 0;
            while (inicio < pulsaciones.length && pulsaciones[inicio] == 0) {
                inicio++;
            }
            int fin = pulsaciones.length - 1;
            while (fin >= 0 && pulsaciones[fin] == 0) {
                fin--;
            }

            // Imprimir el resultado
            for (int i = inicio; i <= fin; i++) {
                System.out.print(pulsaciones[i]);
                if (i < fin) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            // Leer el siguiente número de notas
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class TeclasDelPiano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] notas = {"Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si"};

        while (true) {
            System.out.print("Ingrese el número de notas (0 para terminar): ");
            int n = scanner.nextInt();
            if (n == 0) break;

            int[] pulsaciones = new int[7 * 12]; // 7 octavas * 12 notas
            scanner.nextLine(); // Consumir el salto de línea

            System.out.println("Ingrese las notas (ejemplo: Do#4):");
            String[] notasCancion = scanner.nextLine().split(" ");

            for (String nota : notasCancion) {
                if (nota.length() < 3) {
                    System.out.println("Nota inválida: " + nota);
                    continue; // Saltar notas inválidas
                }

                String nombreNota = nota.substring(0, nota.length() - 2);
                char alteracion = nota.charAt(nota.length() - 2);
                int octava = Character.getNumericValue(nota.charAt(nota.length() - 1));

                int indice = (octava - 1) * 12; // Base de la octava
                for (int i = 0; i < notas.length; i++) {
                    if (notas[i].equals(nombreNota)) {
                        indice += i; // Sumar el índice de la nota
                        break;
                    }
                }

                // Ajustar el índice según la alteración
                if (alteracion == '#') {
                    indice++;
                } else if (alteracion == 'b') {
                    indice--;
                }

                // Incrementar el contador de pulsaciones
                if (indice >= 0 && indice < pulsaciones.length) {
                    pulsaciones[indice]++;
                } else {
                    System.out.println("Índice fuera de rango para la nota: " + nota);
                }
            }

            // Imprimir el resultado
            for (int i = 0; i < pulsaciones.length; i++) {
                if (pulsaciones[i] > 0) {
                    System.out.print(pulsaciones[i] + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
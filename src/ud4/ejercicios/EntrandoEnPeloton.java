package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class EntrandoEnPeloton {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de corredores
        System.out.print("Ingrese el número de corredores: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        while (n > 0) {
            String[] tiempos = new String[n];
            int[] tiemposEnSegundos = new int[n];
            int[] posiciones = new int[n];

            // Leer los tiempos de los corredores
            for (int i = 0; i < n; i++) {
                tiempos[i] = scanner.nextLine();
                tiemposEnSegundos[i] = convertirATiempoEnSegundos(tiempos[i]);
            }

            // Crear un arreglo de índices para mantener el orden original
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }

            // Ordenar los índices según los tiempos en segundos
            Arrays.sort(indices, (a, b) -> Integer.compare(tiemposEnSegundos[a], tiemposEnSegundos[b]));

            // Asignar posiciones
            int posicionActual = 1; // Posición inicial
            posiciones[indices[0]] = posicionActual; // Asignar la primera posición

            for (int i = 1; i < n; i++) {
                // Si la diferencia de tiempo es mayor a 1 segundo, se incrementa la posición
                if (tiemposEnSegundos[indices[i]] - tiemposEnSegundos[indices[i - 1]] > 1) {
                    posicionActual = i + 1; // Nueva posición
                }
                posiciones[indices[i]] = posicionActual; // Asignar la posición
            }

            // Imprimir las posiciones en el orden original
            for (int i = 0; i < n; i++) {
                System.out.println(posiciones[i]);
            }

            // Leer el siguiente número de corredores
            System.out.print("Ingrese el número de corredores: ");
            n = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
        }

        scanner.close();
    }

    // Método para convertir el tiempo en formato HH:MM:SS a segundos
    private static int convertirATiempoEnSegundos(String tiempo) {
        String[] partes = tiempo.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        int segundos = Integer.parseInt(partes[2]);
        return horas * 3600 + minutos * 60 + segundos;
    }
}
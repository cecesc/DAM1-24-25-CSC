package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class RepartiendoRegalos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el portal de aterrizaje y el número de portales
        System.out.print("Ingrese el portal de aterrizaje y el número de portales: ");
        int p = scanner.nextInt();
        int n = scanner.nextInt();

        // Leer los portales donde hay que dejar regalos
        System.out.println("Ingrese los números de los portales (separados por espacio):");
        int[] portales = new int[n];
        for (int i = 0; i < n; i++) {
            portales[i] = scanner.nextInt();
        }

        // Ordenar los portales para facilitar la búsqueda
        Arrays.sort(portales);

        // Arreglo para almacenar el orden de visita
        int[] ordenVisita = new int[n];
        int index = 0; // Índice para el arreglo de orden de visita

        // Si el portal de aterrizaje está en la lista de portales, agregarlo
        if (Arrays.binarySearch(portales, p) >= 0) {
            ordenVisita[index++] = p; // Agregar el portal de aterrizaje
        }

        // Repartir regalos
        boolean[] visitado = new boolean[n];
        int actual = p;

        for (int i = 0; i < n; i++) {
            int siguientePortal = -1;
            int minDistancia = Integer.MAX_VALUE;

            // Encontrar el siguiente portal más cercano
            for (int j = 0; j < n; j++) {
                if (!visitado[j]) {
                    int distancia = Math.abs(portales[j] - actual);
                    if (distancia < minDistancia || (distancia == minDistancia && portales[j] > siguientePortal)) {
                        minDistancia = distancia;
                        siguientePortal = portales[j];
                    }
                }
            }

            // Marcar el portal como visitado
            visitado[Arrays.binarySearch(portales, siguientePortal)] = true;
            ordenVisita[index++] = siguientePortal; // Agregar el siguiente portal al orden de visita
            actual = siguientePortal; // Actualizar la posición actual
        }

        // Imprimir el resultado
        System.out.print("Orden de visita: ");
        for (int i = 0; i < index; i++) {
            System.out.print(ordenVisita[i] + (i < index - 1 ? " " : ""));
        }
        System.out.println(); // Nueva línea al final

        scanner.close();
    }
}
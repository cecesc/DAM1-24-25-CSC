package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class DetectandoCopiones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer N y K
        System.out.print("Ingrese el número de exámenes (N) y el número de exámenes que puede recordar (K): ");
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] respuestas = new int[N];

        // Leer las respuestas de los exámenes
        System.out.println("Ingrese las respuestas de los exámenes (separadas por espacio):");
        for (int i = 0; i < N; i++) {
            respuestas[i] = scanner.nextInt();
        }

        // Contar el número total de copias
        int[] conteoRespuestas = new int[100001]; // Para respuestas entre 1 y 100000
        for (int respuesta : respuestas) {
            conteoRespuestas[respuesta]++;
        }

        // Calcular el número de exámenes copiados
        int totalCopias = 0;
        for (int count : conteoRespuestas) {
            if (count > 1) {
                totalCopias += count - 1; // Si hay 'count' respuestas iguales, hay 'count - 1' copias
            }
        }

        // Detectar copias recordadas por el profesor
        int[] recordados = new int[K]; // Para almacenar las últimas K respuestas
        int copiasDetectadas = 0;
        int index = 0; // Índice para el arreglo de recordados

        for (int i = 0; i < N; i++) {
            // Verificar si la respuesta actual ya está en las últimas K respuestas
            for (int j = 0; j < index; j++) {
                if (recordados[j] == respuestas[i]) {
                    copiasDetectadas++;
                    break;
                }
            }

            // Agregar la respuesta actual a las últimas K respuestas
            recordados[index] = respuestas[i];
            index++;

            // Mantener solo los últimos K exámenes en la memoria
            if (index > K) {
                // Desplazar las respuestas hacia la izquierda
                System.arraycopy(recordados, 1, recordados, 0, K - 1);
                index = K - 1; // Ajustar el índice
            }
        }

        // Imprimir el resultado
        System.out.println(totalCopias + " " + copiasDetectadas);

        scanner.close();
    }
}
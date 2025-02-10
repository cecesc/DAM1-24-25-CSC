package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class Sobres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de sobres y el número de sobres a seleccionar
        int n = scanner.nextInt(); // Número de sobres
        while (n != 0) {
            int k = scanner.nextInt(); // Número de sobres a seleccionar
            int[] sobres = new int[n]; // Arreglo para los sobres

            // Leer el dinero en cada sobre
            for (int i = 0; i < n; i++) {
                sobres[i] = scanner.nextInt();
            }

            // Arreglo para almacenar los resultados
            int[] resultados = new int[n - k + 1];

            // Calcular el máximo en cada ventana de tamaño k
            for (int j = 0; j <= n - k; j++) {
                int max = sobres[j]; // Inicializar el máximo
                for (int l = 1; l < k; l++) {
                    if (sobres[j + l] > max) {
                        max = sobres[j + l]; // Actualizar el máximo
                    }
                }
                resultados[j] = max; // Guardar el resultado
            }

            // Imprimir los resultados
            System.out.println(Arrays.toString(resultados).replaceAll("[\\[\\],]", "").replaceAll(" ", " "));

            // Leer el siguiente número de sobres
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class Conjuritis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de hechizos
        int N = scanner.nextInt();

        while (N > 0) {
            int[] daños = new int[N];

            // Leer los daños a priori
            for (int i = 0; i < N; i++) {
                daños[i] = scanner.nextInt();
            }

            // Leer el daño total causado
            int dañoTotalCausado = scanner.nextInt();

            // Calcular la suma de los dos conjuros que fallaron
            int sumaFallidos = 0;
            for (int daño : daños) {
                sumaFallidos += daño;
            }
            sumaFallidos -= dañoTotalCausado;

            // Buscar los dos conjuros que suman sumaFallidos
            int left = 0;
            int right = N - 1;
            int conjuro1 = 0;
            int conjuro2 = 0;

            while (left < right) {
                int sumaActual = daños[left] + daños[right];
                if (sumaActual == sumaFallidos) {
                    conjuro1 = daños[left];
                    conjuro2 = daños[right];
                    break;
                } else if (sumaActual < sumaFallidos) {
                    left++;
                } else {
                    right--;
                }
            }

            // Imprimir los resultados en orden ascendente
            System.out.println(conjuro1 + " " + conjuro2);

            // Leer el siguiente número de hechizos
            N = scanner.nextInt();
        }

        scanner.close();
    }
}
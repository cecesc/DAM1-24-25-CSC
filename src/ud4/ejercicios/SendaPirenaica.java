package ud4.ejercicios;

import java.util.Scanner;

public class SendaPirenaica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de etapas
        int N = scanner.nextInt();

        while (N > 0) {
            int[] distancias = new int[N];

            // Leer las distancias de cada etapa
            System.out.println("Ingrese las distancias de cada etapa:");
            for (int i = 0; i < N; i++) {
                distancias[i] = scanner.nextInt();
            }

            // Calcular las distancias restantes
            int[] distanciasRestantes = new int[N];
            int sumaTotal = 0;

            // Calcular la suma total de distancias
            for (int i = 0; i < N; i++) {
                sumaTotal += distancias[i];
            }

            // Calcular las distancias restantes para cada etapa
            for (int i = 0; i < N; i++) {
                sumaTotal -= distancias[i];
                distanciasRestantes[i] = sumaTotal;
            }

            // Imprimir las distancias restantes
            for (int i = 0; i < N; i++) {
                System.out.print(distanciasRestantes[i]);
                if (i < N - 1) {
                    System.out.print(" "); // Espacio entre números
                }
            }
            System.out.println(); // Nueva línea al final

            // Leer el siguiente número de etapas
            N = scanner.nextInt();
        }

        scanner.close();
    }
}
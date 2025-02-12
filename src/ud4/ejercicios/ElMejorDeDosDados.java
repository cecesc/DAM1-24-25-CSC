package ud4.ejercicios;

import java.util.Scanner;

public class ElMejorDeDosDados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de caras de los dados
        System.out.print("Ingrese el número de caras de los dados (0 para terminar): ");
        int n = scanner.nextInt();

        while (n > 0) {
            // Leer los valores de las caras del primer dado
            int[] dado1 = new int[n];
            System.out.println("Ingrese los valores del primer dado:");
            for (int i = 0; i < n; i++) {
                dado1[i] = scanner.nextInt();
            }

            // Leer los valores de las caras del segundo dado
            int[] dado2 = new int[n];
            System.out.println("Ingrese los valores del segundo dado:");
            for (int i = 0; i < n; i++) {
                dado2[i] = scanner.nextInt();
            }

            // Contar las victorias
            int victoriasDado1 = 0;
            int victoriasDado2 = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dado1[i] > dado2[j]) {
                        victoriasDado1++;
                    } else if (dado1[i] < dado2[j]) {
                        victoriasDado2++;
                    }
                }
            }

            // Determinar el resultado
            if (victoriasDado1 > victoriasDado2) {
                System.out.println("PRIMERO");
            } else if (victoriasDado2 > victoriasDado1) {
                System.out.println("SEGUNDO");
            } else {
                System.out.println("NO HAY DIFERENCIA");
            }

            // Leer el siguiente número de caras de los dados
            System.out.print("Ingrese el número de caras de los dados (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
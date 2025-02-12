package ud4.ejercicios;

import java.util.Scanner;

public class Pipos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el año
        System.out.print("Ingrese el año que está a punto de comenzar (0 para terminar): ");
        int año = scanner.nextInt();

        while (año != 0) {
            // Contar los dígitos del año
            int[] conteoDigitos = new int[10];
            String añoStr = String.valueOf(año);
            for (char c : añoStr.toCharArray()) {
                conteoDigitos[c - '0']++;
            }

            // Leer la cantidad de uvas
            int[] uvas = new int[10];
            System.out.println("Ingrese la cantidad de uvas para cada número de pipos (0 a 9):");
            for (int i = 0; i < 10; i++) {
                uvas[i] = scanner.nextInt();
            }

            // Calcular cuántas personas pueden recibir las uvas
            int maxPersonas = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                if (conteoDigitos[i] > 0) {
                    maxPersonas = Math.min(maxPersonas, uvas[i] / conteoDigitos[i]);
                }
            }

            // Imprimir el resultado
            System.out.println("Número máximo de personas que pueden recibir las uvas: " + maxPersonas);

            // Leer el siguiente año
            System.out.print("Ingrese el año que está a punto de comenzar (0 para terminar): ");
            año = scanner.nextInt();
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class LosNinosPrimero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de personas que abandonan el circo
        System.out.print("Ingrese el número de personas que abandonan el circo (0 para terminar): ");
        int n = scanner.nextInt();

        while (n != 0) {
            // Leer las alturas
            System.out.println("Ingrese las alturas de las personas (separadas por espacio):");
            int[] alturas = new int[n];
            for (int i = 0; i < n; i++) {
                alturas[i] = scanner.nextInt();
            }

            // Encontrar la altura máxima
            int maxAltura = Arrays.stream(alturas).max().orElse(0);

            // Contar cuántas personas son más bajas que la altura máxima
            int contadorNinos = 0;
            for (int altura : alturas) {
                if (altura < maxAltura) {
                    contadorNinos++;
                }
            }

            // Imprimir el resultado
            System.out.println("El número mínimo de niños que había en el circo es: " + contadorNinos);

            // Leer nuevamente el número de personas
            System.out.print("Ingrese el número de personas que abandonan el circo (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
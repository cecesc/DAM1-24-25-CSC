package ud4.ejercicios;

import java.util.Scanner;

public class CalculoMediana {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int n = scanner.nextInt();

        while (n != 0) {
            int[] valores = new int[n];

            // Leer los valores
            for (int i = 0; i < n; i++) {
                valores[i] = scanner.nextInt();
            }

            // Calcular la mediana
            double mediana;
            if (n % 2 == 1) {
                // Número impar de elementos
                mediana = valores[n / 2];
            } else {
                // Número par de elementos
                mediana = (valores[n / 2 - 1] + valores[n / 2]) / 2.0;
            }

            // Imprimir el doble de la mediana
            System.out.println((int)(mediana * 2));

            // Leer el siguiente número de casos de prueba
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
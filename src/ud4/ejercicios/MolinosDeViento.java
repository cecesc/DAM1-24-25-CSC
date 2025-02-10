package ud4.ejercicios;

import java.util.Scanner;

public class MolinosDeViento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de molinos
        int n = scanner.nextInt();

        while (n != 0) {
            long[] energia = new long[n];
            for (int i = 0; i < n; i++) {
                energia[i] = scanner.nextLong(); // Leer la energía producida por cada molino
            }

            // Crear un arreglo de suma acumulativa
            long[] sumaAcumulativa = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                sumaAcumulativa[i] = sumaAcumulativa[i - 1] + energia[i - 1];
            }

            int consultas = scanner.nextInt(); // Leer el número de consultas
            for (int i = 0; i < consultas; i++) {
                int inicio = scanner.nextInt(); // Molino inicial
                int fin = scanner.nextInt(); // Molino final
                // Calcular la energía total en el intervalo [inicio, fin]
                long totalEnergia = sumaAcumulativa[fin] - sumaAcumulativa[inicio - 1];
                System.out.println(totalEnergia);
            }

            // Leer el siguiente número de molinos
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
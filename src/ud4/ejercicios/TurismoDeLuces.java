package ud4.ejercicios;

import java.util.Scanner;

public class TurismoDeLuces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer N y K
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // Leer los grados de espectacularidad
        long[] espectacularidad = new long[N];
        for (int i = 0; i < N; i++) {
            espectacularidad[i] = scanner.nextLong();
        }

        long maxAsombro = Long.MIN_VALUE;

        // Calcular el grado de asombro para las K calles consecutivas
        for (int i = 0; i <= N - K; i++) {
            long asombro = 0;

            // Calcular el asombro en la dirección normal
            for (int j = i; j < i + K - 1; j++) {
                asombro += Math.abs(espectacularidad[j + 1] - espectacularidad[j]);
            }
            maxAsombro = Math.max(maxAsombro, asombro);

            // Calcular el asombro en la dirección inversa
            asombro = 0;
            for (int j = i + K - 1; j > i; j--) {
                asombro += Math.abs(espectacularidad[j] - espectacularidad[j - 1]);
            }
            maxAsombro = Math.max(maxAsombro, asombro);
        }

        // Imprimir el resultado
        System.out.println(maxAsombro);

        scanner.close();
    }
}
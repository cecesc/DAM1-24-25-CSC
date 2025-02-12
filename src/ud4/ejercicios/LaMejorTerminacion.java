package ud4.ejercicios;

import java.util.Scanner;

public class LaMejorTerminacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de sorteos
        System.out.print("Ingrese el número de sorteos: ");
        int n = scanner.nextInt();

        while (n > 0) {
            // Leer los números premiados
            System.out.println("Ingrese los números premiados (separados por espacio):");
            int[] conteo = new int[10]; // Array para contar las terminaciones (0-9)

            for (int i = 0; i < n; i++) {
                int numero = scanner.nextInt();
                int terminacion = numero % 10; // Obtener la terminación
                conteo[terminacion]++; // Incrementar el contador para esa terminación
            }

            // Determinar la terminación más frecuente
            int maxCount = 0;
            int maxDigit = -1;
            boolean hayEmpate = false;

            for (int i = 0; i < 10; i++) {
                if (conteo[i] > maxCount) {
                    maxCount = conteo[i];
                    maxDigit = i;
                    hayEmpate = false; // Resetear el empate
                } else if (conteo[i] == maxCount) {
                    hayEmpate = true; // Hay un empate
                }
            }

            // Imprimir el resultado
            if (hayEmpate) {
                System.out.println("VARIAS");
            } else {
                System.out.println("La terminación más premiada es: " + maxDigit);
            }

            // Leer el siguiente número de sorteos
            System.out.print("Ingrese el número de sorteos: ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
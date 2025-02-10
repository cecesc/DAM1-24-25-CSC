package ud4.ejercicios;

import java.util.Scanner;

public class TeoremaPuntoFijo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Leer el número de moléculas
        while (n != 0) {
            int[] movimiento = new int[n]; // Arreglo para el movimiento de las moléculas
            for (int i = 0; i < n; i++) {
                movimiento[i] = scanner.nextInt() - 1; // Leer el movimiento y ajustar a índice 0
            }

            boolean[] visitado = new boolean[n]; // Arreglo para marcar moléculas visitadas
            int mcm = 1; // Mínimo común múltiplo inicial

            // Encontrar ciclos
            for (int i = 0; i < n; i++) {
                if (!visitado[i]) {
                    int cicloSize = 0;
                    int current = i;

                    // Seguir el ciclo
                    do {
                        visitado[current] = true;
                        current = movimiento[current];
                        cicloSize++;
                    } while (current != i);

                    // Calcular el MCM del tamaño del ciclo
                    mcm = lcm(mcm, cicloSize);
                }
            }

            // Imprimir el resultado
            System.out.println(mcm);

            // Leer el siguiente número de moléculas
            n = scanner.nextInt();
        }

        scanner.close();
    }

    // Función para calcular el MCM
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Función para calcular el GCD (Máximo común divisor)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
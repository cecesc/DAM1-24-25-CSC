package ud4.ejercicios;

import java.util.Scanner;

public class MejorPeorDia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de días
        int N = scanner.nextInt();
        int[] valoraciones = new int[N];

        // Leer las valoraciones de los días
        for (int i = 0; i < N; i++) {
            valoraciones[i] = scanner.nextInt();
        }

        // Array para almacenar el resultado
        int[] resultado = new int[N];

        // Variable para almacenar el mejor día que queda por vivir
        int mejorDia = 0;

        // Recorrer las valoraciones de atrás hacia adelante
        for (int i = N - 1; i >= 0; i--) {
            // Actualizar el mejor día que queda por vivir
            if (valoraciones[i] > mejorDia) {
                mejorDia = valoraciones[i];
            }
            // Calcular la diferencia
            resultado[i] = mejorDia - valoraciones[i];
        }

        // Imprimir el resultado
        for (int i = 0; i < N; i++) {
            System.out.print(resultado[i]);
            if (i < N - 1) {
                System.out.print(" "); // Espacio entre números
            }
        }
        System.out.println(); // Nueva línea al final

        scanner.close();
    }
}
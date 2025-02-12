package ud4.ejercicios;

import java.util.Scanner;

public class HoustonNecesitoUnaVerificacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de grupos
        int n = scanner.nextInt();

        // Leer el vector A
        int[] vectorA = new int[10000000]; // Asumimos el tamaño máximo
        int indexA = 0;
        for (int i = 0; i < n; i++) {
            int repeticiones = scanner.nextInt();
            int valor = scanner.nextInt();
            for (int j = 0; j < repeticiones; j++) {
                vectorA[indexA++] = valor;
            }
        }

        // Leer el vector B
        int[] vectorB = new int[10000000]; // Asumimos el tamaño máximo
        int indexB = 0;
        for (int i = 0; i < n; i++) {
            int repeticiones = scanner.nextInt();
            int valor = scanner.nextInt();
            for (int j = 0; j < repeticiones; j++) {
                vectorB[indexB++] = valor;
            }
        }

        // Calcular el producto escalar
        long productoEscalar = 0;
        for (int i = 0; i < indexA; i++) {
            productoEscalar += (long) vectorA[i] * vectorB[i];
        }

        // Imprimir el resultado
        System.out.println(productoEscalar);

        scanner.close();
    }
}
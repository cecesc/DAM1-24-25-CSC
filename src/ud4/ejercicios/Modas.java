package ud4.ejercicios;

import java.util.Scanner;

public class Modas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer número que indica el tamaño del conjunto
        int n = scanner.nextInt();

        while (n != 0) {
            int[] conteo = new int[10001]; // Suponiendo que los números están en el rango de 0 a 10000
            int maxOcurrencias = 0;
            int moda = 0;

            // Leer los valores y contar las ocurrencias
            for (int i = 0; i < n; i++) {
                int valor = scanner.nextInt();
                conteo[valor]++;

                // Verificar si este valor tiene más ocurrencias
                if (conteo[valor] > maxOcurrencias) {
                    maxOcurrencias = conteo[valor];
                    moda = valor;
                }
            }

            // Imprimir la moda
            System.out.println(moda);

            // Leer el siguiente número que indica el tamaño del siguiente conjunto
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
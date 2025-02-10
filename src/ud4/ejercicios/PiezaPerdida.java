package ud4.ejercicios;

import java.util.Scanner;

public class PiezaPerdida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de piezas
        int n = scanner.nextInt();

        while (n != 0) {
            // Calcular la suma esperada de las piezas
            int sumaEsperada = n * (n + 1) / 2;
            int sumaActual = 0;

            // Leer los números de las piezas y calcular la suma actual
            for (int i = 0; i < n - 1; i++) {
                sumaActual += scanner.nextInt();
            }

            // La pieza que falta es la diferencia entre la suma esperada y la suma actual
            int piezaFaltante = sumaEsperada - sumaActual;

            // Imprimir el resultado
            System.out.println(piezaFaltante);

            // Leer el siguiente número de piezas
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class MatrizIdentidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt(); // Leer el número de filas
            if (n == 0) break; // Terminar si n es 0

            boolean isIdentity = true; // Suponemos que es identidad
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double value = scanner.nextDouble(); // Leer el valor de la matriz
                    // Verificar condiciones para ser matriz identidad
                    if (i == j) {
                        if (value != 1) {
                            isIdentity = false; // Diagonal principal debe ser 1
                        }
                    } else {
                        if (value != 0) {
                            isIdentity = false; // Fuera de la diagonal debe ser 0
                        }
                    }
                }
            }

            // Imprimir el resultado
            if (isIdentity) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

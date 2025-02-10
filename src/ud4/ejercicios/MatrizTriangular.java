package ud4.ejercicios;
import java.util.Scanner;

public class MatrizTriangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n; // Variable para el número de filas
        n = sc.nextInt(); // Leer el número de filas

        while (n != 0) { // Continuar mientras n no sea 0
            int[][] matriz = new int[n][n];
            // Leer la matriz
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = sc.nextInt();
                }
            }

            // Verificar si es triangular
            boolean esTriangularSuperior = true;
            boolean esTriangularInferior = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < j && matriz[i][j] != 0) {
                        esTriangularSuperior = false; // Elemento por encima de la diagonal no es cero
                    }
                    if (i > j && matriz[i][j] != 0) {
                        esTriangularInferior = false; // Elemento por debajo de la diagonal no es cero
                    }
                }
            }

            // Imprimir el resultado
            if (esTriangularSuperior || esTriangularInferior) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            n = sc.nextInt(); // Leer el siguiente número de filas
        }

        sc.close();
    }
}


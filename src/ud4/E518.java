import java.util.Scanner;

public class EP0518 {
    public static boolean esMatrizMagica(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz.length != matriz[0].length) {
            return false; // No es cuadrada o es nula/vacía
        }

        int n = matriz.length;
        int sumaEsperada = 0;
        for (int j = 0; j < n; j++) {
            sumaEsperada += matriz[0][j]; // Suma de la primera fila
        }

        // Verificar filas
        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != sumaEsperada) {
                return false;
            }
        }

        // Verificar columnas
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                suma Columna += matriz[i][j];
            }
            if (sumaColumna != sumaEsperada) {
                return false;
            }
        }

        // Verificar diagonales
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }

        return sumaDiagonalPrincipal == sumaEsperada && sumaDiagonalSecundaria == sumaEsperada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        System.out.println("Introduce los elementos de la matriz 4x4:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        if (esMatrizMagica(matriz)) {
            System.out.println("La matriz es mágica.");
        } else {
            System.out.println("La matriz no es mágica.");
        }
    }
}
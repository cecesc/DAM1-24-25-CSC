public class EjArrays18 {
    public static boolean esOrtogonal(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz.length != matriz[0].length) {
            return false; // No es cuadrada o es nula/vacía
        }

        int n = matriz.length;
        int[][] transpuesta = traspuesta(matriz);
        int[][] producto = multiplicar(matriz, transpuesta);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && producto[i][j] != 1) {
                    return false; // Elemento diagonal no es 1
                } else if (i != j && producto[i][j] != 0) {
                    return false; // Elemento fuera de la diagonal no es 0
                }
            }
        }
        return true; // Es ortogonal
    }

    private static int[][] traspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    private static int[][] multiplicar(int[][] t1, int[][] t2) {
        int filasT1 = t1.length;
        int columnasT2 = t2[0].length;
        int[][] producto = new int[filasT1][columnasT2];

        for (int i = 0; i < filasT1; i++) {
            for (int j = 0; j < columnasT2; j++) {
                for (int k = 0; k < t1[0].length; k++) {
                    producto[i][j] += t1[i][k] * t2[k][j];
                }
            }
        }
        return producto;
    }
}
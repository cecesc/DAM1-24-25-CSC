public class CuadradosDiabolicos {
    public static boolean esCuadradoEsoterico(int[][] t) {
        if (t == null || t.length == 0 || t.length != t[0].length) {
            return false; // No es cuadrada o es nula/vacía
        }

        int n = t.length;
        int sumaDiagonal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonal += t[i][i];
        }

        for (int i = 0; i < n; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += t[i][j];
                sumaColumna += t[j][i];
            }
            if (sumaFila != sumaDiagonal || sumaColumna != sumaDiagonal) {
                return false; // Sumas de filas o columnas no coinciden
            }
        }

        return true; // Es un cuadrado esotérico
    }
}
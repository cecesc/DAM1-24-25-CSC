public class EjArrays14 {
    public static int[][] traspuesta(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            return null; // Manejo de matriz nula o vacía
        }

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
}
package ud4.arraysejercicios;
public class EjArrays15 {
    public static int[][] sumaMatrices(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null || m1.length == 0 || m2.length == 0 || m1.length != m2.length || m1[0].length != m2[0].length) {
            return null; // Manejo de matrices nulas o de tamaños diferentes
        }

        int filas = m1.length;
        int columnas = m1[0].length;
        int[][] suma = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return suma;
    }
}
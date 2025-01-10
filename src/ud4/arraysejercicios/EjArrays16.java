package ud4.arraysejercicios;
public class EjArrays16 {
    public static int[][] multiplicar(int[][] t1, int[][] t2) {
        if (t1 == null || t2 == null || t1.length == 0 || t2.length == 0 || t1[0].length != t2.length) {
            return null; // Manejo de matrices nulas o incompatibles
        }

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
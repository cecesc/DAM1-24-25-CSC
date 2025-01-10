public class EjArrays13 {
    public static boolean esDiagonal(int[][] t) {
        if (t == null || t.length == 0 || t.length != t[0].length) {
            return false; // No es cuadrada o es nula/vacía
        }

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i != j && t[i][j] != 0) {
                    return false; // Elemento fuera de la diagonal no es cero
                }
            }
        }
        return true; // Es diagonal
    }

    // Métodos de prueba
    public static void main(String[] args) {
        // Pruebas
        int[][] matrizDiagonal = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        System.out.println(esDiagonal(matrizDiagonal)); // true

        int[][] matrizNoDiagonal = {{1, 0, 0}, {0, 2, 0}, {0, 1, 3}};
        System.out.println(esDiagonal(matrizNoDiagonal)); // false

        int[][] matrizNoCuadrada = {{1, 0, 0}, {0, 2, 0}};
        System.out.println(esDiagonal(matrizNoCuadrada)); // false

        int[][] matrizVacia = {};
        System.out.println(esDiagonal(matrizVacia)); // false

        int[][] matrizNull = null;
        System.out.println(esDiagonal(matrizNull)); // false
    }
}
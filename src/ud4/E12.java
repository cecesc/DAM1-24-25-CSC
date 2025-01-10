public class EjArrays12 {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        if (esMatrizIdentidad(matriz)) {
            System.out.println("La matriz es una matriz identidad.");
        } else {
            System.out.println("La matriz no es una matriz identidad.");
        }
    }

    private static boolean esMatrizIdentidad(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && matriz[i][j] != 1) {
                    return false;
                } else if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
package ud2.practicas;

public class Dado {
    public static void main(String[] args) {
        final int NUM_LANZAMIENTOS = 1000;
        int cara1 = 0, cara2 = 0, cara3 = 0, cara4 = 0, cara5 = 0, cara6 = 0;

        for (int i = 0; i < NUM_LANZAMIENTOS; i++) {
            int valor = (int) (Math.random() * 7);
            switch (valor) {
                case 1 -> cara1++;
                case 2 -> cara2++;
                case 3 -> cara3++;
                case 4 -> cara4++;
                case 5 -> cara5++;
                case 6 -> cara6++;

            }
        }

        System.out.println("LANZADO UN DADO " + NUM_LANZAMIENTOS + " VECES");

        System.out.println("RESULTADOS");
        System.out.printf("Ha salido 1: %d veces ( %.2f ) \n", cara1, (double) (100 * cara1 / NUM_LANZAMIENTOS));
        System.out.printf("Ha salido 2: %d veces ( %.2f ) \n", cara2, (double) (100 * cara2 / NUM_LANZAMIENTOS));
        System.out.printf("Ha salido 3: %d veces ( %.2f ) \n", cara3, (double) (100 * cara3 / NUM_LANZAMIENTOS));
        System.out.printf("Ha salido 4: %d veces ( %.2f ) \n", cara4, (double) (100 * cara4 / NUM_LANZAMIENTOS));
        System.out.printf("Ha salido 5: %d veces ( %.2f ) \n", cara5, (double) (100 * cara5 / NUM_LANZAMIENTOS));
        System.out.printf("Ha salido 6: %d veces ( %.2f ) \n", cara6, (double) (100 * cara6 / NUM_LANZAMIENTOS));
    }
}

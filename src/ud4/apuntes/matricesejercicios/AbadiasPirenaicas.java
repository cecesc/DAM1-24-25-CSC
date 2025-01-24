package ud4.apuntes.matricesejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class AbadiasPirenaicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_MONT = 1000;
        int[] altitudes = new int[0];

        System.out.println("Introduce la altura de cada montaña de oeste a este (-1 para terminar):");
        int altitud = sc.nextInt();
        while (altitud >= 0 && altitudes.length < MAX_MONT) {
            altitudes = Arrays.copyOf(altitudes, altitudes.length + 1);
            altitudes[altitudes.length - 1] = altitud;

        }
        System.out.println("Cordillera: " + Arrays.toString(altitudes));

        if (altitudes.length > 0) {
            int[] abadias = getMontanaAbadias(altitudes);
            System.out.println(" Se pueden construir " + abadias.length + " Abadías en las cordilleras "
                    + Arrays.toString(abadias));
        } else {
            System.out.println("No hay montañas");
        }

        sc.close();

    }

    static int[] getMontanaAbadias(int[] t) {
        int[] abadias = new int[0];
        int maxAltitud = -1;
        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] > maxAltitud) {
                maxAltitud = t[i];
                abadias = Arrays.copyOf(abadias, abadias.length + 1);
                abadias[abadias.length - 1] = i + 1;

            }
        }

        Arrays.sort(abadias);
        return abadias;
    }

}

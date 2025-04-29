package ud6.ejercicios;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Cubifinito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        while ((num = sc.nextInt()) != 0) {
            Set<Integer> vistos = new HashSet<>();
            List<Integer> secuencia = new ArrayList<>();

            int actual = num;
            boolean esCubifinito = false;

            while (!vistos.contains(actual)) {
                secuencia.add(actual);
                vistos.add(actual);

                if (actual == 1) {
                    esCubifinito = true;
                    break;
                }

                actual = sumaCubosDigitos(actual);
            }

            // Mostrar la secuencia
            for (int i = 0; i < secuencia.size(); i++) {
                if (i > 0) System.out.print(" - ");
                System.out.print(secuencia.get(i));
            }

            if (!esCubifinito) {
                System.out.print(" - " + actual); // repetición detectada
            }

            System.out.println(" -> " + (esCubifinito ? "cubifinito." : "no cubifinito."));
        }

        sc.close();
    }

    private static int sumaCubosDigitos(int num) {
        int suma = 0;
        while (num > 0) {
            int digito = num % 10;
            suma += digito * digito * digito;
            num /= 10;
        }
        return suma;
    }
}

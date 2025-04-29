package ud6.ejercicios;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Potitos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = Integer.parseInt(sc.nextLine());

        while (casos != 0) {
            Set<String> leGustan = new HashSet<>();
            Set<String> noLeGustan = new HashSet<>();

            for (int i = 0; i < casos; i++) {
                String linea = sc.nextLine();
                String[] partes = linea.split(" ");
                boolean comido = partes[0].equals("SI:");

                for (int j = 1; j < partes.length && !partes[j].equals("FIN"); j++) {
                    if (comido) {
                        leGustan.add(partes[j]);
                    } else {
                        noLeGustan.add(partes[j]);
                    }
                }
            }

            noLeGustan.removeAll(leGustan);

            List<String> resultado = new ArrayList<>(noLeGustan);
            Collections.sort(resultado);
            System.out.println(String.join(" ", resultado));

            // Leemos el siguiente caso
            casos = Integer.parseInt(sc.nextLine());
        }

        sc.close();
    }
}

package ud4.arraysejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EP0519 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> dorsales = new ArrayList<>();
        int dorsal;

        System.out.println("Introduce los dorsales de los corredores (introduce -1 para finalizar):");
        while (true) {
            dorsal = scanner.nextInt();
            if (dorsal == -1) break;
            dorsales.add(dorsal);
        }

        // Procesar dorsales de menores de edad
        System.out.println("Introduce los dorsales de los corredores menores de edad:");
        while (true) {
            dorsal = scanner.nextInt();
            if (dorsal == -1) break;
            if (dorsales.contains(dorsal)) {
                int index = dorsales.indexOf(dorsal);
                if (index > 0) {
                    Collections.swap(dorsales, index, index - 1); // Avanzar un puesto
                }
            }
        }

        // Procesar dorsales de corredores expulsados
        System.out.println("Introduce los dorsales de los corredores expulsados por antidopaje:");
        while (true) {
            dorsal = scanner.nextInt();
            if (dorsal == -1) break;
            dorsales.remove(Integer.valueOf(dorsal)); // Eliminar corredor
        }

        // Procesar dorsales de corredores que no pagaron
        System.out.println("Introduce los dorsales de los corredores que no pagaron:");
        ArrayList<Integer> noPagados = new ArrayList<>();
        while (true) {
            dorsal = scanner.nextInt();
            if (dorsal == -1) break;
            noPagados.add(dorsal);
        }
        dorsales.addAll(noPagados); // Añadir al final

        // Mostrar dorsales de los tres primeros
        System.out.println("Dorsales de los tres primeros corredores:");
        for (int i = 0; i < Math.min(3, dorsales.size()); i++) {
            System.out.println("Dorsal: " + dorsales.get(i));
        }
    }
}
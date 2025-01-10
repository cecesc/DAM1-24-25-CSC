package ud4.arraysejercicios;

import java.util.ArrayList;
import java.util.Collections;

public class EP0514 {
    public static void main(String[] args) {
        ArrayList<Double> sueldos = new ArrayList<>();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double sueldo;

        System.out.println("Introduce los sueldos (introduce -1 para finalizar):");
        while (true) {
            sueldo = sc.nextDouble();
            if (sueldo == -1) break;
            sueldos.add(sueldo);
        }

        if (sueldos.isEmpty()) {
            System.out.println("No se han introducido sueldos.");
            return;
        }

        Collections.sort(sueldos, Collections.reverseOrder());
        double max = Collections.max(sueldos);
        double min = Collections.min(sueldos);
        double media = sueldos.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        System.out.println("Sueldos ordenados de forma decreciente: " + sueldos);
        System.out.println("Sueldo máximo: " + max);
        System.out.println("Sueldo mínimo: " + min);
        System.out.println("Media de los sueldos: " + media);

        sc.close();
    }
}
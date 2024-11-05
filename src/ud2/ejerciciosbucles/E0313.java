// Dadas 6 notas, escribir la cantidad de alumnos aprobados, condicionados (nota igual a 4) y suspensos.
package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aprobados = 0;
        int condicionados = 0;
        int suspensos = 0;

        for (int i = 0; i < 6; i++) {
            System.out.print("Introduce la nota del alumno " + ( i + 1) + ": ");
            int nota = sc.nextInt();

            if (nota >= 5) {
                aprobados++;
            } else if (nota == 4) {
                condicionados++;
            } else {
                suspensos++;
            }
        }

        System.out.println("Aprobados: " + aprobados);
        System.out.println("Condicionados: " + condicionados);
        System.out.println("Suspensos: " + suspensos);

        sc.close();
    }
}
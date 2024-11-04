package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean haySuspenso = false;

        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce la calificación del alumno " + (i + 1) + ": ");
            int calificacion = sc.nextInt();

            if (calificacion < 5) {
                haySuspenso = true;
            }
        }

        if (haySuspenso) {
            System.out.println("Hay al menos un suspenso.");
        } else {
            System.out.println("Todos los alumnos están aprobados.");
        }

        sc.close();
    }
}
package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class FaseFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de equipos
        System.out.print("Ingrese el número de equipos (0 para terminar): ");
        int N = scanner.nextInt();

        // Terminar si se encuentra un torneo sin equipos
        if (N == 0) {
            scanner.close();
            return;
        }

        // Leer los nombres de los equipos
        String[] equipos = new String[N];
        System.out.println("Ingrese los nombres de los equipos:");
        for (int i = 0; i < N; i++) {
            equipos[i] = scanner.next();
        }

        // Procesar los resultados de los partidos
        while (N > 1) {
            String[] equiposSiguientes = new String[N / 2];
            System.out.println("Ingrese los resultados de los partidos (goles del equipo 1 y 2):");
            for (int i = 0; i < N / 2; i++) {
                String equipo1 = equipos[2 * i];
                String equipo2 = equipos[2 * i + 1];
                int goles1 = scanner.nextInt();
                int goles2 = scanner.nextInt();

                // Determinar el ganador
                if (goles1 > goles2) {
                    equiposSiguientes[i] = equipo1;
                } else {
                    equiposSiguientes[i] = equipo2;
                }
            }
            equipos = equiposSiguientes; // Actualizar la lista de equipos
            N /= 2; // Reducir el número de equipos
        }

        // El último equipo en la lista es el ganador
        System.out.println("El equipo ganador es: " + equipos[0]);

        scanner.close();
    }
}
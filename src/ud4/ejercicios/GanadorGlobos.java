package ud4.ejercicios;

import java.util.Scanner;

public class GanadorGlobos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de equipos y globos
        System.out.println("Ingrese el número de equipos y globos (0 0 para terminar):");
        int numEquipos = scanner.nextInt();
        int numGlobos = scanner.nextInt();

        while (numEquipos != 0 || numGlobos != 0) {
            int[] globosPorEquipo = new int[numEquipos + 1]; // Índices de 1 a numEquipos

            // Leer los globos entregados
            System.out.println("Ingrese los globos entregados (equipo y color):");
            for (int i = 0; i < numGlobos; i++) {
                int equipo = scanner.nextInt();
                String color = scanner.next(); // Leer el color, pero no lo necesitamos
                globosPorEquipo[equipo]++;
            }

            // Determinar el ganador
            int maxGlobos = 0;
            int ganador = -1;
            boolean empate = false;

            for (int i = 1; i <= numEquipos; i++) {
                if (globosPorEquipo[i] > maxGlobos) {
                    maxGlobos = globosPorEquipo[i];
                    ganador = i;
                    empate = false; // Resetear empate
                } else if (globosPorEquipo[i] == maxGlobos) {
                    empate = true; // Hay un empate
                }
            }

            // Imprimir el resultado
            if (empate) {
                System.out.println("EMPATE");
            } else {
                System.out.println("El ganador es el equipo: " + ganador);
            }

        }

        scanner.close(); // Cerrar el escáner al final
    }
}
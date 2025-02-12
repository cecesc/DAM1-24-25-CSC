package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class AmigoInvisible {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de participantes
        System.out.print("Ingrese el número de participantes (0 para terminar): ");
        int p = scanner.nextInt();

        // Procesar hasta que se ingrese 0
        while (p > 0) {
            // Leer el número de asignaciones conocidas
            System.out.print("Ingrese el número de asignaciones conocidas: ");
            int a = scanner.nextInt();
            int[] regalos = new int[p + 1]; // Array para las asignaciones (1 a p)
            boolean[] conocido = new boolean[p + 1]; // Para saber si se conoce la asignación

            // Inicializar el array de regalos
            Arrays.fill(regalos, -1); // -1 significa que no se conoce la asignación

            // Leer las asignaciones conocidas
            System.out.println("Ingrese las asignaciones conocidas (de a):");
            for (int i = 0; i < a; i++) {
                int de = scanner.nextInt();
                int aQuien = scanner.nextInt();
                regalos[de] = aQuien; // Asignar el regalo
                conocido[de] = true; // Marcar que se conoce la asignación
            }

            // Propagar las asignaciones
            boolean cambios;
            do {
                cambios = false;
                for (int i = 1; i <= p; i++) {
                    if (conocido[i] && regalos[i] != -1) {
                        int aQuien = regalos[i];
                        for (int j = 1; j <= p; j++) {
                            if (regalos[j] == -1 && j != i && j != aQuien) {
                                regalos[j] = aQuien; // Asignar el regalo
                                conocido[j] = true; // Marcar que se conoce la asignación
                                cambios = true; // Se ha hecho un cambio
                            }
                        }
                    }
                }
            } while (cambios);

            // Verificar si todos tienen una asignación única
            boolean posible = true;
            for (int i = 1; i <= p; i++) {
                if (regalos[i] == -1) {
                    posible = false; // Si hay alguien sin asignación
                    break;
                }
            }

            // Imprimir el resultado
            if (posible) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }

            // Leer el siguiente número de participantes
            System.out.print("Ingrese el número de participantes (0 para terminar): ");
            p = scanner.nextInt();
        }

        scanner.close();
    }
}
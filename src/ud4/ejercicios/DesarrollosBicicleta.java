package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class DesarrollosBicicleta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de platos y coronas
        System.out.println("Ingrese el número de platos y coronas (0 0 para terminar):");
        int P = scanner.nextInt(); // Número de platos
        int C = scanner.nextInt(); // Número de coronas

        while (P != 0 && C != 0) {
            int[] platos = new int[P]; // Arreglo para los platos
            System.out.println("Ingrese los dientes de cada plato:");
            for (int i = 0; i < P; i++) {
                platos[i] = scanner.nextInt(); // Leer los dientes de cada plato
            }

            int[] coronas = new int[C]; // Arreglo para las coronas
            System.out.println("Ingrese los dientes de cada corona:");
            for (int i = 0; i < C; i++) {
                coronas[i] = scanner.nextInt(); // Leer los dientes de cada corona
            }

            // Crear un arreglo para almacenar los desarrollos
            String[] desarrollos = new String[P * C];
            int contadorDesarrollos = 0; // Cambiar el nombre de la variable

            // Calcular todas las combinaciones
            for (int plato : platos) {
                for (int corona : coronas) {
                    desarrollos[contadorDesarrollos++] = plato + "-" + corona; // Usar contadorDesarrollos
                }
            }

            // Ordenar los desarrollos
            Arrays.sort(desarrollos, (a, b) -> {
                String[] partesA = a.split("-");
                String[] partesB = b.split("-");
                double desarrolloA = (double) Integer.parseInt(partesA[0]) / Integer.parseInt(partesA[1]);
                double desarrolloB = (double) Integer.parseInt(partesB[0]) / Integer.parseInt(partesB[1]);
                return Double.compare(desarrolloA, desarrolloB);
            });

            // Imprimir los desarrollos ordenados
            System.out.println("Desarrollos ordenados:");
            System.out.println(String.join(" ", desarrollos));

            // Leer el siguiente número de platos y coronas
            System.out.println("Ingrese el número de platos y coronas (0 0 para terminar):");
            P = scanner.nextInt();
            C = scanner.nextInt();
        }

        scanner.close();
    }
}
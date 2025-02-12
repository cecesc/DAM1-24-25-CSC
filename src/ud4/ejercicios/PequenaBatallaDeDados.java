package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class PequenaBatallaDeDados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la primera línea de la batalla
        System.out.print("Ingrese el número de tropas de defensa, tropas de ataque, máximo dados defensa, máximo dados ataque y número de oleadas: ");
        int td = scanner.nextInt(); // tropas de defensa
        int ta = scanner.nextInt(); // tropas de ataque
        int dd = scanner.nextInt(); // máximo dados defensa
        int da = scanner.nextInt(); // máximo dados ataque
        int no = scanner.nextInt(); // número de oleadas

        // Procesar hasta que se encuentre un caso con 0 tropas
        while (td > 0 && ta > 0) {
            // Leer las tiradas de dados
            int[][] tiradas = new int[no][];
            for (int i = 0; i < no; i++) {
                tiradas[i] = new int[dd + da]; // espacio para los dados de defensa y ataque
                System.out.println("Ingrese los dados de defensa y ataque para la oleada " + (i + 1) + ":");
                for (int j = 0; j < dd; j++) {
                    tiradas[i][j] = scanner.nextInt(); // dados de defensa
                }
                for (int j = 0; j < da; j++) {
                    tiradas[i][dd + j] = scanner.nextInt(); // dados de ataque
                }
            }

            // Simular las oleadas
            for (int i = 0; i < no; i++) {
                // Determinar cuántos dados se lanzan
                int dadosDefensa = Math.min(td, dd);
                int dadosAtaque = Math.min(ta, da);

                // Ordenar los dados
                int[] defensaDados = Arrays.copyOf(tiradas[i], dadosDefensa);
                int[] ataqueDados = Arrays.copyOfRange(tiradas[i], dd, dd + dadosAtaque);
                Arrays.sort(defensaDados);
                Arrays.sort(ataqueDados);

                // Comparar dados
                for (int j = 0; j < Math.min(dadosDefensa, dadosAtaque); j++) {
                    if (ataqueDados[dadosAtaque - 1 - j] <= defensaDados[dadosDefensa - 1 - j]) {
                        ta--; // El atacante pierde una tropa
                    } else {
                        td--; // El defensor pierde una tropa
                    }
                }
            }

            // Imprimir el resultado final
            System.out.println("Tropas defensoras restantes: " + td + ", Tropas atacantes restantes: " + ta);

            // Leer la siguiente batalla
            System.out.print("Ingrese el número de tropas de defensa, tropas de ataque, máximo dados defensa, máximo dados ataque y número de oleadas (0 para terminar): ");
            td = scanner.nextInt(); // tropas de defensa
            ta = scanner.nextInt(); // tropas de ataque
            dd = scanner.nextInt(); // máximo dados defensa
            da = scanner.nextInt(); // máximo dados ataque
            no = scanner.nextInt(); // número de oleadas
        }

        scanner.close();
    }
}
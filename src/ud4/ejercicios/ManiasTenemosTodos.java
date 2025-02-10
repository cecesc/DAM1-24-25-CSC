package ud4.ejercicios;

import java.util.Scanner;

public class ManiasTenemosTodos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int casos = scanner.nextInt(); // Leer el número de casos de prueba
        scanner.nextLine(); // Consumir el salto de línea

        // Días de la semana en el orden correspondiente
        char[] dias = {'L', 'M', 'X', 'J', 'V', 'S', 'D'};

        for (int i = 0; i < casos; i++) {
            int semanas = scanner.nextInt(); // Leer la cantidad de semanas
            scanner.nextLine(); // Consumir el salto de línea

            // Inicializar un arreglo para llevar el control de las pastillas
            boolean[] pastillas = new boolean[7]; // false = no se tomó, true = se tomó

            // Leer el estado de las pastillas para cada semana
            for (int j = 0; j < semanas; j++) {
                String estado = scanner.nextLine();
                for (int k = 0; k < 7; k++) {
                    if (estado.charAt(k) == '-') {
                        pastillas[k] = true; // Se tomó la pastilla
                    }
                }
            }

            // Determinar el primer día de la semana que no tiene pastilla
            int diaCompra = -1;
            for (int k = 0; k < 7; k++) {
                if (!pastillas[k]) {
                    diaCompra = k;
                    break; // Encontramos el primer día sin pastilla
                }
            }

            // Imprimir el resultado
            if (diaCompra != -1) {
                System.out.println(dias[diaCompra] + " " + (semanas + 1));
            }
        }

        scanner.close();
    }
}
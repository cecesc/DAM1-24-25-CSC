package ud4.ejercicios;

import java.util.Scanner;

public class ManiasTenemosTodos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de semanas:");
        int semanas = scanner.nextInt(); // Leer la cantidad de semanas
        scanner.nextLine(); // Consumir el salto de línea

        // Días de la semana en el orden correspondiente
        char[] dias = {'L', 'M', 'X', 'J', 'V', 'S', 'D'};

        // Inicializar un arreglo para llevar el control de las pastillas
        boolean[] pastillas = new boolean[7]; // false = no se tomó, true = se tomó

        // Leer el estado de las pastillas para cada semana
        System.out.println("Ingrese el estado de las pastillas para cada semana (7 caracteres por línea):");
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
        } else {
            System.out.println("Todos los días tienen pastillas.");
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
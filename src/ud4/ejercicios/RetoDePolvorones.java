package ud4.ejercicios;


import java.util.Scanner;

public class RetoDePolvorones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el límite máximo de polvorones y el número de tipos
        System.out.print("Ingrese el límite máximo de polvorones y el número de tipos (0 0 para terminar): ");
        int limiteMaximo = scanner.nextInt();
        int p = scanner.nextInt();

        // Terminar si se encuentra con dos ceros
        if (limiteMaximo == 0 && p == 0) {
            scanner.close();
            return;
        }

        // Leer las capacidades de cada tipo de polvorón
        int[] capacidades = new int[p];
        System.out.println("Ingrese las capacidades de cada tipo de polvorón:");
        for (int i = 0; i < p; i++) {
            capacidades[i] = scanner.nextInt();
        }

        // Leer la cantidad de polvorones en la bandeja
        int[] polvoronesEnBandeja = new int[p];
        System.out.println("Ingrese la cantidad de polvorones en la bandeja:");
        for (int i = 0; i < p; i++) {
            polvoronesEnBandeja[i] = scanner.nextInt();
        }

        // Verificar si puede comer todos los polvorones
        boolean puedeComer = true;
        int totalPolvorones = 0;

        for (int i = 0; i < p; i++) {
            if (polvoronesEnBandeja[i] > capacidades[i]) {
                puedeComer = false; // No puede comer más de su capacidad
                break;
            }
            totalPolvorones += polvoronesEnBandeja[i];
        }

        // Verificar el límite máximo
        if (puedeComer && totalPolvorones <= limiteMaximo) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
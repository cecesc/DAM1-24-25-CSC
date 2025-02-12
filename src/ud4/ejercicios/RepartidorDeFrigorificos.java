package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class RepartidorDeFrigorificos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de calles y frigoríficos
        System.out.print("Ingrese el número de calles (C), el número de calles (F) y el número de frigoríficos (N): ");
        int C = scanner.nextInt();
        int F = scanner.nextInt();
        int N = scanner.nextInt();

        // Terminar si se encuentra con ceros
        if (C == 0 && F == 0 && N == 0) {
            scanner.close();
            return;
        }

        // Arreglos para almacenar las posiciones de entrega
        int[] xPos = new int[N];
        int[] yPos = new int[N];

        // Leer las posiciones de entrega
        System.out.println("Ingrese las posiciones de entrega (x y):");
        for (int i = 0; i < N; i++) {
            xPos[i] = scanner.nextInt();
            yPos[i] = scanner.nextInt();
        }

        // Ordenar las posiciones para encontrar la mediana
        Arrays.sort(xPos);
        Arrays.sort(yPos);

        // Calcular la mediana
        int medianaX = xPos[N / 2];
        int medianaY = yPos[N / 2];

        // Imprimir la posición óptima
        System.out.println("La posición óptima del local del repartidor es: " + medianaX + " " + medianaY);

        scanner.close();
    }
}
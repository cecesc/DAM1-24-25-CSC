package ud4.ejercicios;

import java.util.Scanner;

public class ProximoTrenCorto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la longitud del tren y del andén
        System.out.print("Ingrese la longitud del tren y del andén (0 0 para terminar): ");
        int T = scanner.nextInt();
        int E = scanner.nextInt();

        // Terminar si se encuentra con dos ceros
        if (T == 0 && E == 0) {
            scanner.close();
            return;
        }

        // Leer la cantidad de pasajeros en cada posición del andén
        int[] pasajeros = new int[E];
        System.out.println("Ingrese la cantidad de pasajeros en cada posición del andén:");
        for (int i = 0; i < E; i++) {
            pasajeros[i] = scanner.nextInt();
        }

        // Calcular la distancia total para cada posición de parada del tren
        long minDistancia = Long.MAX_VALUE;

        for (int i = 0; i <= E - T; i++) {
            long distanciaTotal = 0;

            // Calcular la distancia total para la posición de parada i
            for (int j = 0; j < T; j++) {
                int posicionPasajero = i + j;
                distanciaTotal += pasajeros[posicionPasajero] * j;
            }

            // Actualizar la mínima distancia
            if (distanciaTotal < minDistancia) {
                minDistancia = distanciaTotal;
            }
        }

        // Imprimir el resultado
        System.out.println("La menor longitud total acumulada es: " + minDistancia);

        scanner.close();
    }
}
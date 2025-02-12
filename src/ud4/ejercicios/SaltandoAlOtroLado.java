package ud4.ejercicios;

import java.util.Scanner;

public class SaltandoAlOtroLado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de posiciones
        int N = scanner.nextInt();
        int[] posiciones = new int[N];

        // Leer las posiciones de las piedras y la orilla
        for (int i = 0; i < N; i++) {
            posiciones[i] = scanner.nextInt();
        }

        // Búsqueda binaria para encontrar la mínima capacidad de salto
        int left = 1; // La capacidad mínima de salto no puede ser menor que 1
        int right = 1000000000; // Capacidad máxima posible
        int resultado = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (puedeCruzar(posiciones, mid)) {
                resultado = mid; // Guardar el resultado
                right = mid - 1; // Buscar una capacidad menor
            } else {
                left = mid + 1; // Aumentar la capacidad
            }
        }

        // Imprimir el resultado
        System.out.println(resultado);
        scanner.close();
    }

    // Función para verificar si se puede cruzar con una capacidad de salto inicial
    private static boolean puedeCruzar(int[] posiciones, int capacidad) {
        int actual = capacidad;

        // Comenzar desde la orilla inicial (posición 0)
        int anterior = 0;

        for (int i = 0; i < posiciones.length; i++) {
            int distancia = posiciones[i] - anterior;

            // Verificar si el salto es posible
            if (distancia > actual) {
                return false; // No se puede saltar
            }

            // Si la distancia es igual a la capacidad actual, decrementar
            if (distancia == actual) {
                actual--;
            }

            // Actualizar la posición anterior
            anterior = posiciones[i];
        }

        return true; // Se puede cruzar
    }
}
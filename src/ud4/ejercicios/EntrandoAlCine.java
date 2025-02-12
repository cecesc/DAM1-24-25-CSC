package ud4.ejercicios;

import java.util.Scanner;

public class EntrandoAlCine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de vecinos en la fila:");
        int numVecinos = scanner.nextInt(); // Leer el número de vecinos en la fila
        int[] butacas = new int[numVecinos]; // Arreglo para las butacas

        // Leer los números de las butacas
        System.out.println("Ingrese los números de las butacas:");
        for (int j = 0; j < numVecinos; j++) {
            butacas[j] = scanner.nextInt();
        }

        // Verificar si todos los que van a butacas impares están al final
        boolean puedeAbrirPuerta = true;
        int countPares = 0; // Contador de vecinos que van a butacas pares

        // Recorrer la fila
        for (int j = 0; j < numVecinos; j++) {
            if (butacas[j] % 2 == 0) { // Butaca par
                countPares++;
            } else { // Butaca impar
                // Si encontramos una butaca impar antes de que se acaben las pares
                if (countPares > 0) {
                    puedeAbrirPuerta = false;
                    break;
                }
            }
        }

        // Imprimir el resultado
        if (puedeAbrirPuerta) {
            System.out.println("SI " + countPares);
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class LoteriaPeñaAtletica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de décimos:");
        int numDecimos = scanner.nextInt(); // Leer el número de décimos
        int[] decimos = new int[numDecimos]; // Crear un arreglo para los décimos

        // Leer los décimos y almacenarlos en el arreglo
        System.out.println("Ingrese los números de los décimos:");
        for (int j = 0; j < numDecimos; j++) {
            decimos[j] = scanner.nextInt(); // Leer el número del décimo
        }

        int countPares = 0; // Contador de décimos pares

        // Contar los décimos pares
        for (int j = 0; j < numDecimos; j++) {
            if (decimos[j] % 2 == 0) { // Verificar si es par
                countPares++;
            }
        }

        // Imprimir el resultado
        System.out.println("Número de décimos pares: " + countPares);

        scanner.close(); // Cerrar el escáner al final
    }
}
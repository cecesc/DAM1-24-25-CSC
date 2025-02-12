package ud4.ejercicios;

import java.util.Scanner;

public class AprendiendoAMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la longitud de la secuencia
        System.out.println("Ingrese la longitud de la secuencia:");
        int n = scanner.nextInt(); // Leer la longitud de la secuencia

        if (n == 0) {
            System.out.println("SIGUE BUSCANDO");
            scanner.close();
            return; // Si no hay números, terminar el programa
        }

        int[] numeros = new int[n]; // Arreglo para los números
        System.out.println("Ingrese los números de la secuencia:");
        for (int j = 0; j < n; j++) {
            numeros[j] = scanner.nextInt(); // Leer los números
        }

        // Variables para encontrar el segmento más largo
        int maxLength = 0;
        int currentLength = 0;

        // Recorrer la secuencia
        for (int j = 0; j < n; j++) {
            if (numeros[j] != 0) { // Si el número no es cero
                currentLength++; // Incrementar la longitud del segmento actual
            } else { // Si encontramos un cero
                if (currentLength > maxLength) {
                    maxLength = currentLength; // Actualizar la longitud máxima
                }
                currentLength = 0; // Reiniciar el contador
            }
        }

        // Verificar al final de la secuencia
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        // Imprimir el resultado
        if (maxLength > 0) {
            System.out.println(maxLength);
        } else {
            System.out.println("SIGUE BUSCANDO");
        }

        scanner.close();
    }
}
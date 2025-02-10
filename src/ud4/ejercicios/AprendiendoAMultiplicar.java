package ud4.ejercicios;

import java.util.Scanner;

public class AprendiendoAMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSecuencias = scanner.nextInt(); // Leer el número de secuencias
        for (int i = 0; i < numSecuencias; i++) {
            int n = scanner.nextInt(); // Leer la longitud de la secuencia
            if (n == 0) {
                System.out.println("SIGUE BUSCANDO");
                continue; // Si no hay números, continuar con la siguiente secuencia
            }

            int[] numeros = new int[n]; // Arreglo para los números
            for (int j = 0; j < n; j++) {
                numeros[j] = scanner.nextInt(); // Leer los números
            }

            // Variables para encontrar el segmento más largo
            int maxLength = 0;
            int startIndex = -1;
            int currentLength = 0;
            int currentStart = 0;

            // Recorrer la secuencia
            for (int j = 0; j < n; j++) {
                if (numeros[j] != 0) { // Si el número no es cero
                    currentLength++;
                } else { // Si encontramos un cero
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        startIndex = currentStart;
                    }
                    currentLength = 0; // Reiniciar el contador
                    currentStart = j + 1; // Actualizar el inicio del nuevo segmento
                }
            }

            // Verificar al final de la secuencia
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = currentStart;
            }

            // Imprimir el resultado
            if (maxLength > 0) {
                System.out.println(maxLength + " " + startIndex);
            } else {
                System.out.println("SIGUE BUSCANDO");
            }
        }

        scanner.close();
    }
}
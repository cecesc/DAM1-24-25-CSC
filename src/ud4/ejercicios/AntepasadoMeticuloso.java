package ud4.ejercicios;

import java.util.Scanner;

public class AntepasadoMeticuloso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer L y N
        System.out.print("Ingrese el máximo número de letras y espacios en una línea (L) y el número de palabras (N): ");
        int L = scanner.nextInt();
        int N = scanner.nextInt();

        // Leer las longitudes de las palabras
        int[] longitudes = new int[N];
        System.out.print("Ingrese las longitudes de las palabras: ");
        for (int i = 0; i < N; i++) {
            longitudes[i] = scanner.nextInt();
        }

        // Encontrar la mayor longitud de línea posible
        int maxLength = 0;

        // Probar cada longitud de línea desde 1 hasta L
        for (int length = 1; length <= L; length++) {
            if (canFit(longitudes, N, length)) {
                maxLength = length; // Actualizar la longitud máxima
            }
        }

        // Imprimir el resultado
        System.out.println("La mayor longitud de línea que se puede usar es: " + maxLength);

        scanner.close();
    }

    // Método para verificar si se pueden acomodar las palabras en líneas de longitud 'length'
    private static boolean canFit(int[] longitudes, int N, int length) {
        int currentLineLength = 0; // Longitud actual de la línea
        for (int i = 0; i < N; i++) {
            // Si la palabra es más larga que la longitud de la línea, no se puede acomodar
            if (longitudes[i] > length) {
                return false;
            }

            // Si es la primera palabra en la línea, no hay espacio adicional
            if (currentLineLength == 0) {
                currentLineLength += longitudes[i];
            } else {
                // Si no es la primera palabra, se necesita un espacio adicional
                if (currentLineLength + 1 + longitudes[i] > length) {
                    // Si no cabe en la línea actual, se empieza una nueva línea
                    currentLineLength = longitudes[i];
                } else {
                    // Si cabe, se suma la longitud de la palabra y el espacio
                    currentLineLength += 1 + longitudes[i];
                }
            }
        }
        return true; // Si se acomodaron todas las palabras
    }
}
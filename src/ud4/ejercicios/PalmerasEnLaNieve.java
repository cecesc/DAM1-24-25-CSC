package ud4.ejercicios;

import java.util.Scanner;

public class PalmerasEnLaNieve {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el peso de la nieve
        System.out.println("Ingrese el peso de la nieve:");
        int pesoNieve = scanner.nextInt(); // Peso de la nieve

        // Leer el número de palmeras
        System.out.println("Ingrese el número de palmeras:");
        int n = scanner.nextInt(); // Número de palmeras

        int[] pesosPalmeras = new int[n]; // Arreglo para los pesos que pueden soportar las palmeras
        System.out.println("Ingrese los pesos que puede soportar cada palmera:");
        for (int j = 0; j < n; j++) {
            pesosPalmeras[j] = scanner.nextInt(); // Leer el peso que puede soportar cada palmera
        }

        // Usar la técnica de ventana deslizante
        int maxLength = 0;
        int left = 0;
        int count = 0; // Contador de palmeras que pueden soportar el peso

        for (int right = 0; right < n; right++) {
            // Si la palmera en la posición right puede soportar el peso
            if (pesosPalmeras[right] >= pesoNieve) {
                count++;
            }

            // Si hay más de 5 palmeras que pueden soportar el peso, mover el límite izquierdo
            while (count > 5) {
                if (pesosPalmeras[left] >= pesoNieve) {
                    count--;
                }
                left++;
            }

            // Calcular la longitud de la ventana actual
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Imprimir la longitud máxima de la franja más afectada
        System.out.println("La longitud máxima de la franja más afectada es: " + maxLength);

        scanner.close(); // Cerrar el escáner al final
    }
}
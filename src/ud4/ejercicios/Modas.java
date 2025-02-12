package ud4.ejercicios;

import java.util.Scanner;

public class Modas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los números (0 para terminar):");
        int[] conteo = new int[10001]; // Suponiendo que los números están en el rango de 0 a 10000
        int maxOcurrencias = 0;
        int moda = 0;

        // Leer los valores y contar las ocurrencias
        while (true) {
            int valor = scanner.nextInt();
            if (valor == 0) {
                break; // Terminar si se recibe 0
            }
            conteo[valor]++;

            // Verificar si este valor tiene más ocurrencias
            if (conteo[valor] > maxOcurrencias) {
                maxOcurrencias = conteo[valor];
                moda = valor;
            }
        }

        // Imprimir la moda
        System.out.println("La moda es: " + moda);

        scanner.close(); // Cerrar el escáner al final
    }
}
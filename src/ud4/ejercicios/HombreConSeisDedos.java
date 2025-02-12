package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class HombreConSeisDedos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer N y A
        System.out.print("Ingrese el número de nacimientos (N) y el periodo de años (A): ");
        int N = scanner.nextInt();
        int A = scanner.nextInt();

        // Procesar hasta que se ingresen ceros
        while (N != 0 && A != 0) {
            // Leer los años de nacimiento
            System.out.println("Ingrese los años de nacimiento (separados por espacio):");
            int[] años = new int[N];
            for (int i = 0; i < N; i++) {
                años[i] = scanner.nextInt();
            }

            // Usar un enfoque de ventana deslizante para contar nacimientos en periodos de A años
            int maxNacimientos = 0;
            int nacimientosActuales = 0;
            int inicioVentana = 0;

            for (int finVentana = 0; finVentana < N; finVentana++) {
                // Aumentar el conteo de nacimientos en la ventana
                nacimientosActuales++;

                // Mover la ventana si excede el periodo de A años
                while (años[finVentana] - años[inicioVentana] >= A) {
                    nacimientosActuales--;
                    inicioVentana++;
                }

                // Actualizar el máximo de nacimientos
                maxNacimientos = Math.max(maxNacimientos, nacimientosActuales);
            }

            // Imprimir el resultado
            System.out.println("El mayor número de personas que ha nacido en un periodo de " + A + " años es: " + maxNacimientos);


        }

        scanner.close();
    }
}
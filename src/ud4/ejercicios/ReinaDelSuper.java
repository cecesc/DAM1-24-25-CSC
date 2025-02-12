package ud4.ejercicios;

import java.util.Scanner;

public class ReinaDelSuper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de cajas y el número de clientes
        System.out.print("Ingrese el número de cajas y el número de clientes: ");
        int n = scanner.nextInt(); // Número de cajas
        int c = scanner.nextInt(); // Número de clientes

        // Leer los tiempos de atención de los clientes
        System.out.print("Ingrese los tiempos de atención de los clientes (separados por espacio): ");
        int[] tiempos = new int[c];
        for (int i = 0; i < c; i++) {
            tiempos[i] = scanner.nextInt();
        }

        // Arreglo para llevar el tiempo total de cada caja
        int[] tiemposCajas = new int[n];

        // Procesar cada cliente
        for (int i = 0; i < c; i++) {
            // Encontrar la caja con el menor tiempo total
            int cajaMinima = 0;
            for (int j = 1; j < n; j++) {
                if (tiemposCajas[j] < tiemposCajas[cajaMinima]) {
                    cajaMinima = j;
                }
            }

            // Asignar el tiempo del cliente a la caja seleccionada
            tiemposCajas[cajaMinima] += tiempos[i];
        }

        // Encontrar la caja donde será atendido Ismael (el último cliente)
        int cajaIsmael = 0;
        for (int j = 1; j < n; j++) {
            if (tiemposCajas[j] < tiemposCajas[cajaIsmael]) {
                cajaIsmael = j;
            }
        }

        // Imprimir el número de la caja (sumando 1 para que sea 1-indexed)
        System.out.println("Ismael será atendido en la caja: " + (cajaIsmael + 1));

        scanner.close();
    }
}
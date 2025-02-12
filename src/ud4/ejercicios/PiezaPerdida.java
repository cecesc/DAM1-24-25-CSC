package ud4.ejercicios;

import java.util.Scanner;

public class PiezaPerdida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Sistema de Detección de Piezas Faltantes --");

        int n;
        do {
            System.out.print("\n¿Cuántas piezas debería haber? (0 para salir): ");
            n = scanner.nextInt();

            if(n == 0) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            // Crear array para almacenar las piezas
            int[] piezas = new int[n - 1];

            System.out.print("Introduce los números de las piezas disponibles (" + (n-1) + " números separados por espacios): ");

            // Leer todas las piezas
            for(int i = 0; i < n - 1; i++) {
                piezas[i] = scanner.nextInt();
            }

            // Calcular suma total esperada
            int sumaEsperada = n * (n + 1) / 2;

            // Calcular suma actual
            int sumaActual = 0;
            for(int num : piezas) {
                sumaActual += num;
            }

            // Determinar pieza faltante
            int faltante = sumaEsperada - sumaActual;

            System.out.println("\n¡Alerta! La pieza faltante es: " + faltante);

        } while(n != 0);

        scanner.close();
    }
}
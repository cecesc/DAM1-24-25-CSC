package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class CuentasParalelas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número máximo de casos de prueba
        int maxCases = 100; // Suponiendo un máximo de 100 casos
        int[][] casos = new int[maxCases][]; // Arreglo para almacenar los movimientos
        int[] movimientosCount = new int[maxCases]; // Para almacenar el número de movimientos de cada caso
        int index = 0;

        // Leer todos los casos de prueba
        while (index < maxCases) {
            int n = scanner.nextInt(); // Leer el número de movimientos
            if (n == 0) {
                break; // Terminar si se encuentra "0"
            }
            movimientosCount[index] = n; // Guardar el número de movimientos
            casos[index] = new int[n]; // Crear un arreglo para los movimientos
            for (int i = 0; i < n; i++) {
                casos[index][i] = scanner.nextInt(); // Leer los movimientos
            }
            index++;
        }

        // Procesar los casos de prueba
        for (int i = 0; i < index; i++) {
            int n = movimientosCount[i];
            long saldoFinal = 0;

            // Calcular el saldo final
            for (int j = 0; j < n; j++) {
                saldoFinal += casos[i][j];
            }

            // Calcular los puntos de singularidad
            long saldoAcumulado = 0;
            int puntosDeSingularidad = 0;

            for (int j = 0; j < n - 1; j++) { // No consideramos el último movimiento
                saldoAcumulado += casos[i][j];
                // Verificar si el saldo acumulado es igual al saldo final menos el siguiente movimiento
                if (saldoAcumulado == saldoFinal - casos[i][j + 1]) {
                    puntosDeSingularidad++;
                }
            }

            // Imprimir el resultado
            System.out.println(puntosDeSingularidad);
        }

        scanner.close();
    }
}
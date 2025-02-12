package ud4.ejercicios;

import java.util.Scanner;

public class CuentasParalelas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arreglo para almacenar los movimientos
        int[] movimientos = new int[100]; // Suponiendo un máximo de 100 movimientos
        int movimientoCount = 0; // Contador para el número de movimientos leídos

        // Leer los movimientos
        System.out.println("Ingrese los movimientos (0 para terminar):");
        while (movimientoCount < 100) {
            int movimiento = scanner.nextInt(); // Leer un movimiento
            if (movimiento == 0) {
                break; // Terminar si se encuentra "0"
            }
            movimientos[movimientoCount] = movimiento; // Guardar el movimiento
            movimientoCount++;
        }

        // Calcular el saldo final
        long saldoFinal = 0;
        for (int j = 0; j < movimientoCount; j++) {
            saldoFinal += movimientos[j];
        }

        // Calcular los puntos de singularidad
        long saldoAcumulado = 0;
        int puntosDeSingularidad = 0;

        for (int j = 0; j < movimientoCount - 1; j++) { // No consideramos el último movimiento
            saldoAcumulado += movimientos[j];
            // Verificar si el saldo acumulado es igual al saldo final menos el siguiente movimiento
            if (saldoAcumulado == saldoFinal - movimientos[j + 1]) {
                puntosDeSingularidad++;
            }
        }

        // Imprimir el resultado
        System.out.println("Puntos de singularidad: " + puntosDeSingularidad);

        scanner.close(); // Cerrar el escáner al final
    }
}
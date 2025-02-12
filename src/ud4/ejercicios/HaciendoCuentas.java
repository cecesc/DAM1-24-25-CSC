package ud4.ejercicios;

import java.util.Scanner;

public class HaciendoCuentas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el saldo inicial y el número de movimientos
        System.out.print("Ingrese el saldo inicial y el número de movimientos: ");
        long saldoInicial = scanner.nextLong();
        int numMovimientos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Arreglo para almacenar el saldo de cada mes
        long[] saldosMensuales = new long[12];

        // Inicializar el saldo mensual con el saldo inicial
        for (int i = 0; i < 12; i++) {
            saldosMensuales[i] = saldoInicial;
        }

        // Procesar cada movimiento
        for (int i = 0; i < numMovimientos; i++) {
            System.out.print("Ingrese el movimiento (DD-MM cantidad concepto): ");
            String movimiento = scanner.nextLine();
            String[] partes = movimiento.split(" ");
            String fecha = partes[0];
            long cantidad = Long.parseLong(partes[1]);
            String concepto = partes[2]; // No se utiliza, pero se lee

            // Extraer el mes de la fecha
            String[] fechaPartes = fecha.split("-");
            int mes = Integer.parseInt(fechaPartes[1]) - 1; // Convertir a índice (0-11)

            // Actualizar el saldo del mes correspondiente
            saldosMensuales[mes] += cantidad;
        }

        // Imprimir los saldos mensuales
        for (int i = 0; i < 12; i++) {
            System.out.print(saldosMensuales[i]);
            if (i < 11) {
                System.out.print(" "); // Espacio entre números
            }
        }
        System.out.println(); // Nueva línea al final

        scanner.close();
    }
}
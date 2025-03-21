package ud4.ejercicios;

import java.util.Scanner;

public class DiasHastaNochevieja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Días en cada mes para un año no bisiesto
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Leer el día y el mes
        System.out.println("Ingrese el día y el mes (formato: día mes):");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();

        // Calcular los días restantes hasta el 31 de diciembre
        int diasRestantes = 0;

        // Sumar los días restantes del mes actual
        diasRestantes += diasPorMes[mes - 1] - dia;

        // Sumar los días de los meses siguientes
        for (int j = mes; j < 12; j++) {
            diasRestantes += diasPorMes[j];
        }

        // Imprimir el resultado
        System.out.println("Días restantes hasta Nochevieja: " + diasRestantes);

        scanner.close();
    }
}
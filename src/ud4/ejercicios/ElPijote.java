package ud4.ejercicios;

import java.util.Scanner;

public class ElPijote {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la secuencia de dígitos
        System.out.println("Ingrese la secuencia de dígitos (0-9):");
        String secuencia = scanner.nextLine();

        // Contar las ocurrencias de cada dígito
        int[] contador = new int[10]; // Array para contar dígitos del 0 al 9

        for (char c : secuencia.toCharArray()) {
            int digito = Character.getNumericValue(c); // Convertir carácter a dígito
            contador[digito]++; // Incrementar el contador para ese dígito
        }

        // Verificar si todos los dígitos que aparecen tienen la misma cantidad
        int cantidad = -1; // Variable para almacenar la cantidad de ocurrencias
        boolean subnormal = true; // Bandera para determinar si es subnormal

        for (int i = 0; i < 10; i++) {
            if (contador[i] > 0) { // Solo considerar dígitos que aparecen
                if (cantidad == -1) {
                    cantidad = contador[i]; // Establecer la cantidad inicial
                } else if (contador[i] != cantidad) {
                    subnormal = false; // Si hay una discrepancia, no es subnormal
                    break;
                }
            }
        }

        // Imprimir el resultado
        if (subnormal) {
            System.out.println("subnormal");
        } else {
            System.out.println("no subnormal");
        }

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class LaAbuelaMaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la línea de dientes superiores
        System.out.print("Ingrese los dientes superiores (separados por espacio): ");
        String dientesSuperiores = scanner.nextLine();

        // Leer la línea de dientes inferiores
        System.out.print("Ingrese los dientes inferiores (separados por espacio): ");
        String dientesInferiores = scanner.nextLine();

        // Convertir las líneas en arreglos de enteros
        String[] partesSuperiores = dientesSuperiores.split(" ");
        String[] partesInferiores = dientesInferiores.split(" ");

        // Verificar si los dientes encajan
        boolean encajan = true;
        for (int j = 0; j < 6; j++) {
            if (Integer.parseInt(partesSuperiores[j]) != Integer.parseInt(partesInferiores[j])) {
                encajan = false;
                break;
            }
        }

        // Imprimir el resultado
        if (encajan) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
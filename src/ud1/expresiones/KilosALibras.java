package ud1.expresiones;

import java.util.Scanner;

public class KilosALibras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        final double LIBRA = 0.453592;

        System.out.print("Introduzca el peso en kilogramos: ");
        double kilogramos = scanner.nextDouble();
        scanner.close();

        double resultado = kilogramos/LIBRA;

        System.out.printf("\n%.2f kilogramos equivalen a %.2f libras", kilogramos, resultado);

    }
    
}

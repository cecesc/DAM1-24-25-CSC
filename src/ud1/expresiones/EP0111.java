package ud1.expresiones;

import java.util.Scanner;

public class EP0111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double baseImponible;
        double iva;

        System.out.println("Introduzca la base imponible: ");
        baseImponible = sc.nextDouble();

        System.out.println("Introdizca el IVA que debe aplicarse: ");
        iva = sc.nextDouble();
        sc.close();

        double importeIva = baseImponible * (iva / 100);
        double total = baseImponible + importeIva;

        System.out.printf("Importe del IVA: %.2f %n", importeIva);
        System.out.printf("Total con IVA: %.2f %n", total);

    }

}

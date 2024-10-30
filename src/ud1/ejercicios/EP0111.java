/* Un economista te ha encargado un programa para realizar cálculos con el IVA. La
aplicación debe solicitar la base imponible y el IVA que se debe aplicar. Muestra en pantalla
el importe correspondiente al IVA y al total. */
package ud1.ejercicios;

import java.util.Scanner;

public class EP0111 { 
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base imponible: ");
        double baseImponible = sc.nextDouble();

        System.out.println("Introduce el porcentaje del IVA: ");
        double porcentajeIVA = sc.nextDouble();

        double importeIVA = baseImponible *(porcentajeIVA/100);
        double total = baseImponible + importeIVA;

        System.out.println("Importe de IVA: " + importeIVA);
        System.out.println("Total (base imponible + IVA): " + total);
    sc.close();


}
    
}
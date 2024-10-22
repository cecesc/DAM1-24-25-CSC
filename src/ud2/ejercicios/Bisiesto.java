/* Haz un programa que pida por teclado un número de año y que muestre un mensaje indicando si el año es bisiesto o no.
Investiga el agoritmo para calcular si un año es bisiesto o no.

“Año bisiesto es el divisible entre 4, salvo que sea año secular es decir divisible por 100, en cuyo caso también ha de ser divisible entre 400.”
*/
package ud2.ejercicios;

import java.util.Scanner;

public class Bisiesto {
    public static void main(String[] args) {
        int anho;
        boolean esBisiesto;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un año: ");
        anho = sc.nextInt();
        sc.close();

        boolean div4 = anho % 4 == 0;
        boolean div100 = anho % 100 == 0;
        boolean div400 = anho % 400 == 0;

        if (div4) {
            if (div100) {
                if (div400) {
                    esBisiesto = true;
                } else {
                    esBisiesto = false;
                }
            } else {
                esBisiesto = true;
            }
        } else {
            esBisiesto = false;
        }

        if (esBisiesto) {
            System.out.println("El año " + anho + " es Bisiesto");
        } else {
            System.out.println("El año " + anho + "  no es Bisiesto");
        }

    }
}
    /*
    if ((anho % 4 == 0 && anho % 100 != 0) || (anho % 400 == 0)) {
        System.out.println("El año " + anho + " es bisiesto.");
    } else {
        System.out.println("El año " + anho + " NO es bisiesto.");
    }
     */



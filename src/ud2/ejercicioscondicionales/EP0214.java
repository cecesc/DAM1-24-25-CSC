/*  Escribe un programa que solicite al usuario un número comprendido entre 1 y 99.
El programa debe mostrario con letras, por ejemplo, para 56, se verá: “cincuenta y seis”.*/
package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0214 {
    public static void main(String[] args) {
        int num;
        String numALetras;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número entre 1 y 99: ");
        num = sc.nextInt();

        /*if (num < 1 || num > 99) {
            System.out.println("El número debe estar entre 1 y 99.");
        } else {
            System.out.println("El número en letras es: " + numALetras(num));
        }

        String[] unidades = {
                "", "uno", "dos", "tres", "cuatro", "cinco",
                "seis", "siete", "ocho", "nueve"
        };

        String[] decenas = {
                "", "diez", "veinte", "treinta", "cuarenta",
                "cincuenta", "sesenta", "setenta", "ochenta", "noventa"
        };*/

    }
}

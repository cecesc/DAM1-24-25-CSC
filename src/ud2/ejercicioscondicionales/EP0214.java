/*  Escribe un programa que solicite al usuario un número comprendido entre 1 y 99.
El programa debe mostrario con letras, por ejemplo, para 56, se verá: “cincuenta y seis”.*/
package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0214 {
    public static void main(String[] args) {
        int num;
        String numALetras = "";

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número entre 1 y 99: ");
        num = sc.nextInt();
        sc.close();

        if (num < 1 || num > 99) {
            System.out.println("Número fuera de rango. Debe estar entre 1 y 99.");
            return; // Salir del programa si el número está fuera de rango
        }

        // Definir las palabras para los números
        String[] unidades = {
            "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"
        };

        String[] decenas = {
            "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"
        };

        // Comprobar si el número es menor que 20
        if (num < 20) {
            numALetras = unidades[num];
        } else {
            // Obtener las decenas y unidades
            int decena = num / 10;
            int unidad = num % 10;

            // Construir la parte de las decenas
            if (decena == 2 && unidad > 0) {
                numALetras = decenas[decena] + " y " + unidades[unidad];
            } else {
                numALetras = decenas[decena];
                if (unidad > 0) {
                    numALetras += " y " + unidades[unidad];
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El número " + num + " se escribe como: " + numALetras);
    }
}
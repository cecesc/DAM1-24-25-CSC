/*  EI DNI consta de un entero de 8 digitos seguido de una letra que se obtiene a
partir del número de la siguiente forma:
letra = número DNI módulo 23
Basándote en esta información, elige la letra a partir de la numeración de la siguiente tabla:
y diseña una aplicación en la que, dado un número de DNI, calcule la letra que le
corresponde. Observa que un número de 8 digitos está dentro del rango del tipo int. */
package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0212 {
    public static void main(String[] args) {
        int dni;
        final int INDICE;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el número de DNI: ");
        dni = sc.nextInt();
        sc.close();

        if (dni < 10000000 || dni > 99999999) {
            System.out.println("Número de DNI inválido. Debe tener 8 dígitos.");
        }

        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        INDICE = (dni % 23);
        char letra = letrasDNI.charAt(INDICE);

        System.out.println("La letra correspondiente al DNI " + dni + " es: " + letra);

    }

}

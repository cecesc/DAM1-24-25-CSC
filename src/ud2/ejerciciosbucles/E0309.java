/* Implementar una aplicación que pida al usuario un número comprendido entre 1 y
10. Hay que mostrar la tabla de multiplicar de dicho número, asegurándose de que el
número introducido se encuentra en el rango establecido. */
package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entre 1 y 10: ");
        int numero = sc.nextInt();

        if (numero < 1 || numero > 10) {
            System.out.println("El número debe estar entre 1 y 10.");
        } else {
            System.out.println("Tabla de multiplicar del " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        }

        sc.close();
    }
}
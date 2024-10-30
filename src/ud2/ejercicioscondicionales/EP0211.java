/* . Escribe una aplicación que solicite al usuario un número comprendido entre 0 y
9999. La aplicación tendrá que indicar si el número introducido es capicúa. */
package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0211 {
    public static void main(String[] args) {
        int num;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un número comprendido entre 0 y 9999: ");
        num = sc.nextInt();
        sc.close();

        if (num < 0 || num > 9999) {
            System.out.println("Número fuera de rango");
        }else{
            String capicua;
        }

        
    }
}

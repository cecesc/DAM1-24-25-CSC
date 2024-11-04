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
        } else {
            // Almacenar el número original para compararlo después
            int originalNum = num;
            int reversedNum = 0;

            // Invertir el número
            while (num > 0) {
                int digit = num % 10; // Obtener el último dígito
                reversedNum = reversedNum * 10 + digit; // Construir el número invertido
                num /= 10; // Eliminar el último dígito
            }

            // Comparar el número original con el número invertido
            if (originalNum == reversedNum) {
                System.out.println("El número " + originalNum + " es capicúa.");
            } else {
                System.out.println("El número " + originalNum + " no es capicúa.");
            }
        }
    }
}

/* Escribir una aplicación para aprender a contar, que pedirá un número n y mostrará
todos los números del 1 al n. */
package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0306 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número n: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
        sc.close();
    }
}
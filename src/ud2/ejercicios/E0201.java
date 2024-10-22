//Diseña una aplicación que solicite un número al usuario e indique si es par o impar.

package ud2.ejercicios;

import java.util.Scanner;

public class E0201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num;

        System.out.println("Introduzca un número: ");
        num = sc.nextInt();
        sc.close();

        if (num % 2 == 0) {
            System.out.println("PAR");
        } else {
            System.out.println("INPAR");
        }
    }
}

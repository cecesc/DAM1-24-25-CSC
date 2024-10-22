// Pedir dos números y mostrarlos ordenados de forma decreciente.
package ud2.ejercicios;

import java.util.Scanner;

public class E0205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.print("Introduzca un número: ");
        num1 = sc.nextInt();
        System.out.print("Introduzca un número: ");
        num2 = sc.nextInt();
        sc.close();

        if (num1 < num2) {
            System.out.printf("El número %s es menor que %s ", num1, num2);
        } else {
            System.out.printf("El número %s es menor que %s ", num2, num1);
        }
    }
}

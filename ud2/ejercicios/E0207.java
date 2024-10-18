//Pedir tres números y mostrarlos ordenados de mayor a menor.

package ud2.ejercicios;

import java.util.Scanner;

public class E0207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, num3;

        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        num2 = sc.nextInt();
        System.out.print("Introduce el tercer número: ");
        num3 = sc.nextInt();
        sc.close();

        if (num1 >= num2 && num1 >= num3) {
            if (num2 >= num3) {
                System.out.println("Orden: " + num1 + " " + num2 + " " + num3);
            } else {
                System.out.println("Orden: " + num1 + " " + num3 + " " + num2);
            }
        } else if (num2 >= num1 && num2 >= num3) {
            if (num1 >= num3) {
                System.out.println("Orden: " + num2 + " " + num1 + " " + num3);
            } else {
                System.out.println("Orden: " + num2 + " " + num3 + " " + num1);
            }
        } else {
            if (num1 >= num2) {
                System.out.println("Orden: " + num3 + " " + num1 + " " + num2);
            } else {
                System.out.println("Orden: " + num3 + " " + num2 + " " + num1);
            }
        }

    }
}

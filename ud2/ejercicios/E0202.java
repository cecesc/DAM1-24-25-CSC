package ud2.ejercicios;

import java.util.Scanner;

public class E0202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1, num2;

        System.out.print("Introduzca un número: ");
        num1 = sc.nextDouble();
        System.out.print("Introduzca un número: ");
        num2 = sc.nextDouble();
        sc.close();

        if (num1 == num2) {
            System.out.println("Los dos números son iguales");
        } else {
            System.out.println("Los dos números no son iguales");
        }
    }
}

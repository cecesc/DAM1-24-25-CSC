package ud2.ejercicios;

import java.util.Scanner;

public class E0203 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.print("Introduzca un número: ");
        num1 = sc.nextInt();
        System.out.print("Introduzca un número: ");
        num2 = sc.nextInt();
        sc.close();

        if (num1 > num2) {
            System.out.printf("El número %s es mayor que %s ", num1, num2);
        } else {
            System.out.printf("El número %s es mayor que %s ", num2, num1);
        }
    }
}

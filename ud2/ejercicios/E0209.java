package ud2.ejercicios;

import java.util.Scanner;

public class E0209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print("Introduce un número entero entre 0 y 99999: ");
        num = sc.nextInt();
        sc.close();

        if (num >= 0 && num <= 9) {
            System.out.println("El número tiene 1 cifra.");
        } else if (num <= 99) {
            System.out.println("El número tiene 2 cifras.");
        } else if (num <= 999) {
            System.out.println("El número tiene 3 cifras.");
        } else if (num <= 9999) {
            System.out.println("El número tiene 4 cifras.");
        } else {
            System.out.println("El número tiene 5 cifras.");
        }
    }
}

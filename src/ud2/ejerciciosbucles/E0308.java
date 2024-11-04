package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0308 {
    public static void main(String[] args) {
        final int NUMEROS = 10;
        Scanner sc = new Scanner(System.in);
        int suma = 0;

        for (int i = 0; i < NUMEROS; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            suma += sc.nextInt();
        }

        double media = (double) suma / NUMEROS;
        System.out.println("La media es: " + media);
        sc.close();
    }
}
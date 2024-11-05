//Pedir un número y calcular su factorial. Por ejemplo el factorial de 5 se denota 5! y es igual a 5 x 4 x 3 x 2 x 1 = 120.
package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número para calcular su factorial: ");
        int numero = sc.nextInt();
        long factorial = 1;

        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        System.out.println("El factorial de " + numero + " es: " + factorial);
        sc.close();
    }
}
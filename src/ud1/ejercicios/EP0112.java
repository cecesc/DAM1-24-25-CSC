/* Crea un programa que pida la base y la altura de un triángulo y muestre su área. */
package ud1.ejercicios;

import java.util.Scanner;

public class EP0112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la base del triángulo: ");
        double base = sc.nextDouble();
        System.out.println("Introduce la altura del triángulo: ");
        double altura = sc.nextDouble();


        double areaTriangulo = (base * altura)/2 ;

        System.out.println("El área del triángulo es: " + areaTriangulo);
        sc.close();
    }
}


package ud1.ejercicios;

import java.util.Scanner;

/* Solicita al usuario tres distancias:
La primera, medida en milímetros.
La segunda, medida en centímetros.
La última, medida en metros.

Diseña un programa que muestre la suma de las tres longitudes introducidas (medida en
centimetros). */
public class EP0116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la primera medida en milímetrios: ");
        double milimetros = sc.nextDouble();
        System.out.println("Introduce la segunda medida en centímetros: ");
        double centrimetros = sc.nextDouble();
        System.out.println("Introduce la tercera medida en metros: ");
        double metros = sc.nextDouble();

        double centM = metros * 100;
        double centMili = milimetros / 100;

        double total = centM + centrimetros + centMili;

        System.out.println("El total de centimetros es " + total);
        sc.close();

    }
}

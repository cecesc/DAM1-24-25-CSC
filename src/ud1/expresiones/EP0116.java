package ud1.expresiones;

import java.util.Scanner;

public class EP0116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la primera medida en milimetros");
        double medmili = sc.nextDouble();
        System.out.println("Introduzca la segunda medida en centimetros");
        double medcent = sc.nextDouble();
        System.out.println("Introduzca la tercera medida en metros");
        double medmtr = sc.nextDouble();
        sc.close();

        double total = (medmili / 10) + medcent + (medmtr * 100);

        System.out.println("La suma de las tres longitudes es: " + total + " centímetros.");
    }

}

package expresiones;

import java.util.Scanner;

public class EP0121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double gradosC, gradosF;

        System.out.println("Introduzca la temperatura en Celsius");
        gradosC=sc.nextDouble();
        sc.close();

        gradosF = gradosC * (9.0/5.0)+32;

        System.out.printf("La temperatura en Fahrenheit es %.2f", gradosF);
    }
}
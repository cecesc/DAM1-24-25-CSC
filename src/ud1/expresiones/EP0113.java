package expresiones;

import java.util.Scanner;

public class EP0113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el coeficiente a: ");
        double coeA = sc.nextDouble();
        System.out.println("Introduce el coeficiente b: ");
        double coeB = sc.nextDouble();
        System.out.println("Introduce el coeficiente c: ");
        double coeC = sc.nextDouble();
        System.out.println("Introduce el coeficiente x: ");
        double valorx = sc.nextDouble();
        sc.close();
        
        double valory =   coeA * Math.pow(valorx, 2) + coeB * valorx + coeC;

        System.out.println("El valor de y es: " + valory);

        
    }
}

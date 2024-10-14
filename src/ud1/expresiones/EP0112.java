package expresiones;

import java.util.Scanner;

public class EP0112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base;
        double altura;
        
        System.out.println("Introduzca la base del triángulo");
        base = sc.nextDouble();
        System.out.println("Introduzca la altura del triangulo");
        altura = sc.nextDouble();
        sc.close();

        double area = (base * altura)/2;

        System.out.println("El área del triángulo es " +area);
        
    }
    
}

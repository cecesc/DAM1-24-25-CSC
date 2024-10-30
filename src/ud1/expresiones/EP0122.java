package ud1.expresiones;

import java.util.Scanner;

public class EP0122 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double gradosC, gradosF;
        System.out.println("Introduzca la temperatura en Farenheit");
        gradosF=sc.nextDouble();
        sc.close();

        gradosC = (5.0/9.0)*(gradosF-32);

        System.out.printf("La temperatura en Celsius es %.2f", gradosC);



    }
    
}

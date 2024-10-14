package expresiones;

import java.util.Scanner;

public class ConversionTemperatura {
    public static void main(String[] args) {
        /*  Declarar la variable F como tipo double*/
    double Fahrenheit ; 
    

    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce la temperatura en Fahrenheit: ");
    Fahrenheit  = sc.nextDouble();
    sc.close();
    
    /*  Usar la fórmula para convertir Fahrenheit a Celsius*/
    double Celsius = (5.0 / 9.0) * (Fahrenheit  - 32);
    
    // Imprimir el resultado
   System.out.println("La temperatura en grados Celsius es: " + Celsius);

    }
    
}

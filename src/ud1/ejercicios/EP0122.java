package ud1.ejercicios;

import java.util.Scanner;
/*Convertir una temperatura introducida por teclado en grados Farenheit a grados Celsius o centígrados, mostrando el resultado por pantalla.
 */
public class EP0122 {
    public static void main(String[] args) {
        /*  Declarar la variable F como tipo double*/
    double Fahrenheit, Celsius ; 
    
    

    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce la temperatura en Fahrenheit: ");
    Fahrenheit = sc.nextDouble();
    
    
    /*  Usar la fórmula para convertir Fahrenheit a Celsius*/
    Celsius = (5.0 / 9.0) * (Fahrenheit  - 32);
    
    // Imprimir el resultado
   System.out.printf("La temperatura en grados Celsius es: " + Celsius + " ºC");
   sc.close();

    }
    
}

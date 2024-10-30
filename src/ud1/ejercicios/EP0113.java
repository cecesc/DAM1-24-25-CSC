
/*crea un programa que pida los coeficientes a, b y c, así como el valor de x, y calcula el valor
correspondiente de y.*/
package ud1.ejercicios;

import java.util.Scanner;

public class EP0113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce el coficiente a: ");
        double coeA = sc.nextDouble();
        System.out.println("Introduce el coeficiente b: ");
        double coeB = sc.nextDouble();
        System.out.println("Introduce el coeficiente c: ");
        double coeC = sc.nextDouble();

        System.out.println("Introduce el valor X: ");
        double valoX = sc.nextDouble();

        double valorY= (coeA * Math.pow(valoX, 2)) + (coeB * valoX) + coeC;
        
        System.out.println("El valor de Y es: " + valorY);
        sc.close();



    }
}

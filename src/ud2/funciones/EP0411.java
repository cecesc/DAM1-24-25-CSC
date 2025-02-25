package ud2.funciones;

import java.util.Scanner;

public class EP0411 {

public static double SVE(double radio){
    double superficie= (4*Math.PI)* Math.pow(radio, 2);
    double volumen= (4*Math.PI/3)* Math.pow(radio, 3);

    System.out.printf("La superficie de esta esfera es de %.2f y el volumen es de %.2f", superficie, volumen);

    return radio;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca el radio de la esfera: ");
        double radio =sc.nextDouble();
        sc.close();
        
        System.out.print(SVE(radio));
    }
}

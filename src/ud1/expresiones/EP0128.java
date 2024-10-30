package ud1.expresiones;

import java.util.Scanner;

public class EP0128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a , b ;

        System.out.print("Introduzca un valor para a: ");
         a = sc.nextInt();
        System.out.print("Introduzca un valor para b: ");
         b = sc.nextInt();
        sc.close();

        String comprobacion = (a == b) ? "true" : "false";
        System.out.println("La afirmación de que los números sean iguales es " + comprobacion);
    }
}

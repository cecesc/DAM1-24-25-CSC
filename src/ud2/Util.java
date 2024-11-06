package ud2;

import java.util.Scanner;

public class Util {

    static boolean esPar(int n) {
        return n % 2 == 0;
    }

    static boolean esBisiesto(int anho) {
        return anho % 400 == 0 || (anho % 4 == 0 && anho % 100 != 0);
    }

  /*   static float esCasi0(int anho) {
        return  }*/

    static int mayor(int a, int b) {
         
        return a > b? a:b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero / Año: ");
        int n = sc.nextInt();
        sc.close();

        if (esPar(n)) 
            System.out.println("Es Par");
         else 
            System.out.println("Es impar");

        
        
        if (esBisiesto(n)) 
            System.out.println("Es bisiesto");
         else 
            System.out.println("No es bisiesto");

            System.out.println(mayor(14, 5));
            System.out.println(mayor(8, 1));
    }

}

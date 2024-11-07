package ud2.funciones;

import java.util.Scanner;

import ud2.Util;

public class LlamadasUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Numero / Año: ");
       int n = sc.nextInt();
        sc.close();

        if (Util.esPar(n))
        System.out.println("Es Par");
        else
        System.out.println("Es impar");
         
        if (Util.esBisiesto(n))
        System.out.println("Es bisiesto");
        else
        System.out.println("No es bisiesto");
    }
}

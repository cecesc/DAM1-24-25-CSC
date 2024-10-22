//Programa que pide un número por teclado y muestra si es par o impar  
package ud2.ejemplos;

import java.util.Scanner;

public class EjemploIfElse2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Introduzca un numero entero: ");
        num = sc.nextInt();
        sc.close();

        // Si solo se utiliza una sentencia no hace falta {}
        if (num % 2 == 0) {
            System.out.println("PAR");
        } else {
            System.out.println("INPAR");
        }
        System.out.println("Hasta Pronto!");
    }
}

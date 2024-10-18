//Programa que pide una nota por teclado y muestra si se ha aprobado o no
package ud2.ejemplos;

import java.util.Scanner;

public class EjemploIfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nota: ");
        int nota = sc.nextInt();
        sc.close();

        // Si solo se utiliza una sentencia no hace falta {}
        if (nota >= 5) {
            System.out.println("Enhorabuena!!");
            System.out.println("Has aprobado");
        } else {
            System.out.println("Lo siento, has suspendido");
        }
        System.out.println("Hasta Pronto!");
    }
}

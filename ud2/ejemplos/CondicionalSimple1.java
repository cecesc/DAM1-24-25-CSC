//Programa que pide una nota por teclado y muestra un mensaje si la nota es mayor o igual que 5
package ud2.ejemplos;

import java.util.Scanner;

public class CondicionalSimple1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nota: ");
        int nota = sc.nextInt();
        sc.close();

        if (nota >= 5) { // Si solo se utiliza una sentencia no hace falta {}
            System.out.println("Enhorabuena!!");
            System.out.println("Has aprobado");
        }
        System.out.println("Hasta Pronto!");
    }
}

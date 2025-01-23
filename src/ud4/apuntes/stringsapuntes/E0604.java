
/*Diseña una aplicación que pida al usuario que introduzca una frase por teclado e indique cuántos 
espacios en blanco tiene. Implementa un método con el siguiente prototipo:
static int contarEspacios(String cad) */
package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0604 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        String frase = sc.nextLine();
        System.out.println("La frase tiene " + contarEspacios(frase) + " espacios");

        sc.close();
    }

    static int contarEspacios(String cad) {
        int numEspacios = 0;

        for (int i = 0; i < cad.length(); i++) {
            if (Character.isSpaceChar(cad.charAt(i))) {
                numEspacios++;
            }
        }
        return numEspacios;
    }
}

/* Introducir por teclado dos frases e indicar cuál de ellas es la más corta, es decir, la que contiene menos caracteres.  */

package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int longitud, longitud2;

        System.out.println("Introduce la primera frase");
        String frase1 = sc.nextLine();
        System.out.println("Introduce la segunda frase");
        String frase2 = sc.nextLine();

        longitud = frase1.length();

        longitud2 = frase2.length();

        if (longitud == longitud2) {
            System.out.println("Las dos frases tienen la misma longitud ");
        } else  if (longitud > longitud2) {
            System.out.println("La frase mas larga es: \" " + frase1 + "\"");
        } else{
           System.out.println("La frase mas larga es: \" " + frase2 + "\"");
        }

        sc.close();
    }
}

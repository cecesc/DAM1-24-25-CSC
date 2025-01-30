package ud4.apuntes.stringsapuntes;

import java.util.Random;
import java.util.Scanner;

public class E0614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra = sc.nextLine();

        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            Random rnd = new Random(0);
            int nuevaPosicion = rnd.nextInt(letras.length);
            char letra = letras[nuevaPosicion];
            letras[nuevaPosicion]= letras[i];
            letras[i] = letra;
        }

        String anagrama = String.valueOf(letras);
        System.out.println("Anagrama: " + anagrama);
    
    sc.close();
    }
}

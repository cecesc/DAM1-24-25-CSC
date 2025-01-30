package ud4.apuntes.stringsapuntes;

import java.util.Random;
import java.util.Scanner;


public class E0615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra: ");
        String palabra;
        do {
            palabra = sc.nextLine();
        } while (palabra.isEmpty());

        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            Random rnd = new Random(0);
            int nuevaPosicion = rnd.nextInt(letras.length);
            char letra = letras[nuevaPosicion];
            letras[nuevaPosicion] = letras[i];
            letras[i] = letra;
        }

        String anagrama = String.valueOf(letras);
        System.out.println("Anagrama: " + anagrama);

        final int MAX_INTENTOS = 3;
        int intentos = 0;

        String palabraj2;
        do {
            System.out.println("Jugador 2:  Adivina la palabra original: ");
            palabraj2 = sc.nextLine();
            intentos++ ;

        } while (!palabraj2.equalsIgnoreCase(palabra)&& intentos < MAX_INTENTOS);

        
        if (!palabraj2.equalsIgnoreCase(palabra)) {
            System.out.println("geniall");
        } else {
            System.out.println("No hays acertado");
        }
        
        
        
        sc.close();

    }

    private static int contarCaracteresIguales(String palabra, String palabraJ2){

    }
}

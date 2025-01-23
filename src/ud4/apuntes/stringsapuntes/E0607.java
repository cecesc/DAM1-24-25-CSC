/*Diseñar un programa que solicite al usuario una frase y una palabra. 
A continuación buscará cuantas veces aparece la palabra en la frase. */
package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una frase");
        String frase = sc.nextLine();
        System.out.println("Introduce una palabra");
        String palabra = sc.nextLine();

        int contador = contarPalabra(frase, palabra);
        System.out.println("La palabra '" + palabra + "' aparece " + contador + " veces en la frase.");

        sc.close();
    }

    static int contarPalabra(String frase, String palabra) {
        int contador = 0;
        int index = 0;

        String fraseLower = frase.toLowerCase();
        String palabraLower = palabra.toLowerCase();

        while ((index = fraseLower.indexOf(palabraLower, index)) != -1) {
            contador++;
            index += palabraLower.length();
        }

        return contador;
    }
}
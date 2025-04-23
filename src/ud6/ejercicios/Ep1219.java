package ud6.ejercicios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ep1219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = sc.nextLine();
        String[] palabras = frase.split(" ");
        Set<String> repetidas = new HashSet<>();
        Set<String> noRepetidas = new HashSet<>();

        for (String palabra : palabras) {
            if (noRepetidas.contains(palabra)) {
                noRepetidas.remove(palabra);
                repetidas.add(palabra);
            } else if (!repetidas.contains(palabra)) {
                noRepetidas.add(palabra);
            }
        }

        System.out.println("Palabras repetidas: " + repetidas);
        System.out.println("Palabras no repetidas: " + noRepetidas);
        sc.close();
    }
}

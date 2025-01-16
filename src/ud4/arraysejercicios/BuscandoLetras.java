package ud4.arraysejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscandoLetras {
    public static void main(String[] args) {
        String[] conceptos = { "Algoritmo", "Lenguaje de programacion", "Entorno de desarrollo", "Compilación",
                "Ejecución", "Código fuente", "Bytecode", "Código objeto" };

        String fraseAleatoria = fraseAleatoria(conceptos);

        System.out.println(fraseAleatoria);

        Scanner sc = new Scanner(System.in);
        int[] posiciones;
        System.out.println("Escribe letras para comprobar su posicion en  la frase aleatoria");
        do {
            char letra = sc.next().charAt(0);
            posiciones = buscarLetra(fraseAleatoria, letra);
            System.out.println("Se encuentra en las posiciones" + Arrays.toString(posiciones));
        } while (posiciones.length != 0);
        System.out.println("Aparece en las posiciones: ");
        System.out.println(Arrays.toString(buscarLetra(fraseAleatoria, 'a')));
        sc.close();
    }

    public static String fraseAleatoria(String[] t) {
        int indiceAleatorio;
        Random rdn = new Random();

        indiceAleatorio = rdn.nextInt(t.length);

        return (t[indiceAleatorio]);

    }

    static int[] buscarLetra(String cadena, char letra) {
        char[] t = cadena.toCharArray();
        int[] posiciones = new int[0];

        for (int i = 0; i < t.length; i++) {
            if (t[i] == letra) {
                posiciones = Arrays.copyOf(posiciones, posiciones.length + 1);
                posiciones[posiciones.length - 1] = i;
            }
        }
        return posiciones;

    }

}

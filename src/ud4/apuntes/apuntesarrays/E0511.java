package ud4.apuntes.apuntesarrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class E0511 {
    public static void main(String[] args) {

        int longCombinacion;

        Scanner sc = new Scanner(System.in);
        System.out.println("Adivina la combiancmion secreta");
        System.out.println("¿Cuantos dígitos tendrá la combinación?");
        longCombinacion = sc.nextInt();
        int[] combinacionSecreta = generarCombinacion(longCombinacion);

        int[] combinacionUsuaerio = leerCombinacion(longCombinacion);
        while (!Arrays.equals(combinacionSecreta, combinacionUsuaerio)) {
            mostrarPistas(combinacionSecreta, combinacionUsuaerio);
            combinacionUsuaerio = leerCombinacion(longCombinacion);
        }

        System.out.println("Enhorabuena");
        sc.close();
    }

    static void mostrarPistas(int[] tSecreto, int[] tUsuario) {
        for (int i = 0; i < tUsuario.length; i++) {
            if (tSecreto[i] == tUsuario[i])
                System.out.print("= ");
            else if (tSecreto[i] > tUsuario[i])
                System.out.print("> ");
            else 
                System.out.print("<");
        }
        System.out.println();
    }

    static int[] leerCombinacion(int n) {
        Scanner sc = new Scanner(System.in);
        int[] combinacion = new int[n];
        System.out.println("Introduce los " + n + " dígitos de la combinación");
        for (int i = 0; i < combinacion.length; i++) {
            combinacion[i] = sc.nextInt();
        }
        return combinacion;
    }

    static int[] generarCombinacion(int n) {
        Random rnd = new Random();
        int[] combinacion = new int[n];
        for (int i = 0; i < combinacion.length; i++)
            combinacion[i] = rnd.nextInt(5) + 1;
        return combinacion;
    }
}

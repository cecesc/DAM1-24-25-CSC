package ud4.practicas.wordle;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        final int NUM_INTENTOS = 6;
        final int NUM_LETRAS = 5;
        int contador = 0;
        Scanner sc = new Scanner(System.in);

        Palabra[] palabras = {
                new Palabra("mando"), new Palabra("clave"), new Palabra("casas"),
                new Palabra("lapiz"), new Palabra("silla"), new Palabra("tigre")
        };

        Random rdm = new Random();
        Palabra palabraOculta = palabras[rdm.nextInt(palabras.length)];
        palabraOculta.incrementarOculta(); 

        String entrada = "";

        System.out.println("****************");
        System.out.println("     WORDLE     ");
        System.out.println("****************");

        mostrar(NUM_LETRAS);

        while (contador < NUM_INTENTOS && !entrada.equals(palabraOculta.getTexto())) {
            do {
                System.out.println();
                System.out.println("Intento " + (contador + 1) + "/" + NUM_INTENTOS + ": ");
                entrada = sc.nextLine().toLowerCase();
                System.out.println();

                if (entrada.length() != NUM_LETRAS) {
                    System.out.println("Longitud de carácteres no coincide, por favor intente otra palabra.");
                }

            } while (entrada.length() != NUM_LETRAS);

            for (Palabra p : palabras) {
                if (p.getTexto().equals(entrada)) {
                    p.incrementarIntentada();
                }
            }

            mostrarTablero(palabraOculta.getTexto(), entrada);
            contador++;
        }

        if (entrada.equals(palabraOculta.getTexto())) {
            System.out.println("HAS ACERTADO!!");
            palabraOculta.incrementarAcertada(); 
        } else {
            System.out.println("HAS PERDIDO! A palabra era: " + palabraOculta.getTexto());
        }

        System.out.println("\nEstatísticas:");
        for (Palabra p : palabras) {
            p.estadisticas();
        }

        sc.close();
    }

    public static void mostrar(int numLetras) {
        System.out.println();
        for (int i = 0; i < numLetras; i++) {
            System.out.print("  _  ");
        }
        System.out.println();
    }

    public static void mostrarTablero(String palabraOculta, String entrada) {
        char[] muestra = new char[palabraOculta.length()];
        Arrays.fill(muestra, '_');
        boolean[] caractError = ltrError(entrada, palabraOculta);
        boolean[] caractAcert = ltrAcert(entrada, palabraOculta);
        System.out.println();

        for (int i = 0; i < muestra.length; i++) {
            if (caractAcert[i]) {
                System.out.print("  " + palabraOculta.toUpperCase().charAt(i) + "  ");
            } else if (caractError[i]) {
                System.out.print(" <" + entrada.toUpperCase().charAt(i) + "> ");
            } else {
                System.out.print("  _  ");
            }
        }
        System.out.println();
    }

    public static boolean[] ltrError(String entrada, String palabraOculta) {
        char[] entradaLetras = entrada.toCharArray();
        char[] palabraOcultaLetras = palabraOculta.toCharArray();
        boolean[] caractError = new boolean[palabraOculta.length()];

        for (int i = 0; i < palabraOculta.length(); i++) {
            for (int j = 0; j < palabraOculta.length(); j++) {
                if (i != j && palabraOcultaLetras[i] == entradaLetras[j]) {
                    caractError[j] = true;
                    palabraOcultaLetras[i] = '0';
                    entradaLetras[j] = '0';
                    break;
                }
            }
        }
        return caractError;
    }

    public static boolean[] ltrAcert(String entrada, String palabraOculta) {
        boolean[] caractAcert = new boolean[palabraOculta.length()];
        for (int i = 0; i < palabraOculta.length(); i++) {
            if (palabraOculta.charAt(i) == entrada.charAt(i)) {
                caractAcert[i] = true;
            }
        }
        return caractAcert;
    }
}

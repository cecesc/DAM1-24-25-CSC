package ud4.ejercicios;

import java.util.Scanner;

public class AlanSmithee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que ingrese la primera frase
        System.out.println("Ingrese la primera frase:");
        String frase1 = sc.nextLine();

        // Solicitar al usuario que ingrese la segunda frase
        System.out.println("Ingrese la segunda frase:");
        String frase2 = sc.nextLine();

        if (sonAnagramas(frase1, frase2)) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }

    private static boolean sonAnagramas(String str1, String str2) {
        // Normalizar las cadenas: convertir a minúsculas y eliminar espacios
        str1 = str1.toLowerCase().replaceAll(" ", "");
        str2 = str2.toLowerCase().replaceAll(" ", "");

        // Si las longitudes son diferentes, no pueden ser anagramas
        if (str1.length() != str2.length()) {
            return false;
        }

        // Contar la frecuencia de cada letra
        int[] contador = new int[27];

        for (char c : str1.toCharArray()) {
            contador[c - 'a']++; // Incrementar el contador para la letra
        }

        for (char c : str2.toCharArray()) {
            contador[c - 'a']--; // Decrementar el contador para la letra
        }

        // Verificar si todos los contadores son cero
        for (int count : contador) {
            if (count != 0) {
                return false; // Si hay alguna letra con un conteo diferente de cero, no son anagramas
            }
        }

        return true; // Son anagramas
    }
}
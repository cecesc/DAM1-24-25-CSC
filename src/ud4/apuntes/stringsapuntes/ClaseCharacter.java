package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class ClaseCharacter {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String linea;

        System.out.println("Introduce un caracter");
        do {
            linea=sc.nextLine();
        } while (linea.equals(""));
        char ch = linea.charAt(0);
        sc.close();

        System.out.println("");
        System.out.println("Digito" + Character.isDigit(ch));
        System.out.println("Letra" + Character.isLetter(ch));
        System.out.println("Digito o letra" + Character.isLetterOrDigit(ch));
        System.out.println("minuscula" + Character.isLowerCase(ch));
        System.out.println("En mayuscula seria" + Character.isLowerCase(ch));
        System.out.println("mayuscula" + Character.isUpperCase(ch));
        System.out.println("En minuscula seria" + Character.isLowerCase(ch));
        System.out.println("Caracter de espacio " + Character.isLowerCase(ch));
        System.out.println("Caracter de espacio en blanco" + Character.isWhitespace(ch));
        System.out.println("que es" + Character.getName(ch));
    }

    
}

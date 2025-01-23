/* Diseñar el juego de “Acierta la contraseña”, que funciona así: un primer jugador introduce una contraseña. A continuación, un segundo
 jugador debe teclear palabras hasta que acierte. */

package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0603 {
    public static void main(String[] args) {
        final int MAX_INTENTOS = 3;
        int intentos = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la contraseña");
        String password = sc.nextLine();

        for (int i = 0; i < 40; i++) {
            System.out.println();
        }

        System.out.println("Introduce tu intento (Max " + MAX_INTENTOS + ") ");
        String intento;

        do {
            intento = sc.nextLine();
            intentos++;
        } while (!password.equals(intento) && intentos < MAX_INTENTOS);
        if (password.equals(intento)) {
            System.out.println("genial!");
        } else {
            System.out.println("Has perdido");
        }
        sc.close();
    }

}

//Autora: Celia Sanmartin Chapela

package ud4.cscexamen;

import java.util.Scanner;

public class CodificandoMorse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] letrasMorse = new String[28];
        letrasMorse[0] = ".-"; // A
        letrasMorse[1] = "-..."; // B
        letrasMorse[2] = "-.-."; // C
        letrasMorse[3] = "-.."; // D
        letrasMorse[4] = "."; // E
        letrasMorse[5] = "..-."; // F
        letrasMorse[6] = "--."; // G
        letrasMorse[7] = "...."; // H
        letrasMorse[8] = ".."; // I
        letrasMorse[9] = ".---"; // J
        letrasMorse[10] = "-.-"; // K
        letrasMorse[11] = ".-.."; // L
        letrasMorse[12] = "--"; // M
        letrasMorse[13] = "-."; // N
        letrasMorse[14] = "---"; // O
        letrasMorse[15] = ".--."; // P
        letrasMorse[16] = "--.-"; // Q
        letrasMorse[17] = ".-."; // R
        letrasMorse[18] = "..."; // S
        letrasMorse[19] = "-"; // T
        letrasMorse[20] = "..-"; // U
        letrasMorse[21] = "...-"; // V
        letrasMorse[22] = ".--"; // W
        letrasMorse[23] = "-..-"; // X
        letrasMorse[24] = "-.--"; // Y
        letrasMorse[25] = "--.."; // Z
        letrasMorse[26] = "-.-.--";// !
        letrasMorse[27] = "..-.."; // ?

        System.out.println("Ingrese una frase:");
        String frase = sc.nextLine();

        if (frase.equals("")) {
            System.out.println("No se ingresó ninguna palabra.");
            sc.close();
            return;
        }

        System.out.println(numPuntosMorse(frase));

        sc.close();

    }

    private static int numPuntosMorse(String frase) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            char letra = Character.toUpperCase(frase.charAt(i));
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ!?".indexOf(letra) != -1) {
                if (letra == '-') {
                    contador += 3;

                } else {
                    contador += 1;
                }
            }
        }
        return contador;

    }

}

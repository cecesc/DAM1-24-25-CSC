package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class AprendiendoCodigoMorse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arreglo que contiene los códigos Morse para cada letra (A-Z)
        String[] morseCode = new String[26];
        morseCode[0] = ".-";   // A
        morseCode[1] = "-..."; // B
        morseCode[2] = "-.-."; // C
        morseCode[3] = "-..";  // D
        morseCode[4] = ".";    // E
        morseCode[5] = "..-."; // F
        morseCode[6] = "--.";  // G
        morseCode[7] = "...."; // H
        morseCode[8] = "..";   // I
        morseCode[9] = ".---"; // J
        morseCode[10] = "-.-"; // K
        morseCode[11] = ".-.."; // L
        morseCode[12] = "--";  // M
        morseCode[13] = "-.";  // N
        morseCode[14] = "---"; // O
        morseCode[15] = ".--."; // P
        morseCode[16] = "--.-"; // Q
        morseCode[17] = ".-."; // R
        morseCode[18] = "..."; // S
        morseCode[19] = "-";   // T
        morseCode[20] = "..-"; // U
        morseCode[21] = "...-"; // V
        morseCode[22] = ".--"; // W
        morseCode[23] = "-..-"; // X
        morseCode[24] = "-.--"; // Y
        morseCode[25] = "--.."; // Z

        while (scanner.hasNextLine()) {
            String palabra = scanner.nextLine().trim();
            if (palabra.isEmpty()) break; // Terminar si la línea está vacía

            char primeraLetra = Character.toUpperCase(palabra.charAt(0));
            int index = primeraLetra - 'A'; // Obtener el índice correspondiente a la letra

            // Generar el código Morse de la palabra
            String codigoGenerado = generarCodigoMorse(palabra);

            if (codigoGenerado.equals(morseCode[index])) {
                System.out.println(palabra + " OK");
            } else {
                System.out.println(palabra + " X");
            }
        }

        scanner.close();
    }

    // Método para generar el código Morse a partir de la palabra
    private static String generarCodigoMorse(String palabra) {
        StringBuilder codigo = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            char letra = Character.toUpperCase(c);
            if ("AEIOU".indexOf(letra) != -1) { // Si es vocal
                if (letra == 'O') {
                    codigo.append("-"); // Vocal 'O' se convierte en raya
                } else {
                    codigo.append("."); // Otras vocales se convierten en punto
                }
            }
        }
        return codigo.toString();
    }
}
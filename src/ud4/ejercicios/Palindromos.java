package ud4.ejercicios;

import java.util.Scanner;
//buho
public class Palindromos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer todas las líneas de entrada
        String[] lineas = new String[100]; // Suponiendo un máximo de 100 líneas
        int index = 0;

        while (true) {
            String frase = scanner.nextLine(); // Leer la línea de entrada
            if (frase.equals("XXX")) {
                break; // Terminar si se encuentra "XXX"
            }
            lineas[index++] = frase; // Almacenar la línea
        }

        // Procesar cada línea
        for (int i = 0; i < index; i++) {
            String normalizada = lineas[i].replaceAll(" ", "").toLowerCase(); // Normalizar la frase
            String reverso = new StringBuilder(normalizada).reverse().toString(); // Obtener el reverso

            // Verificar si es un palíndromo
            if (normalizada.equals(reverso)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}
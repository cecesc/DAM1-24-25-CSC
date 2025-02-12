package ud4.ejercicios;

import java.util.Scanner;

public class Palindromos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer una línea de entrada
        System.out.println("Ingrese una frase (XXX para terminar):");
        String frase = scanner.nextLine(); // Leer la línea de entrada

        // Terminar si se encuentra "XXX"
        if (frase.equals("XXX")) {
            System.out.println("Terminando el programa.");
            scanner.close();
            return;
        }

        // Normalizar la frase
        String normalizada = frase.replaceAll(" ", "").toLowerCase(); // Eliminar espacios y convertir a minúsculas
        String reverso = new StringBuilder(normalizada).reverse().toString(); // Obtener el reverso

        // Verificar si es un palíndromo
        if (normalizada.equals(reverso)) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
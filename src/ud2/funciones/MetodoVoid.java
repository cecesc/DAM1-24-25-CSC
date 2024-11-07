package ud2.funciones;

import java.util.Scanner;

public class MetodoVoid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena, caracter;
        System.out.print("Introduce cadena de texto: ");
        cadena = sc.nextLine();
        System.out.println("Introduce el caracter que quiera: ");
        caracter= sc.nextLine();
        sc.close();
        cajaTexto(cadena); // llamada al método
    }

    // método que muestra un String rodeado por un borde
    public static void cajaTexto(String str) {
        int n = str.length(); // longitud del String

        imprimirlinea(n);
        System.out.println("# " + str + " #"); // cadena con un borde en cada lado
        imprimirlinea(n);
    }

    public static void imprimirlinea(int n) {
        for (int i = 1; i <= n + 4; i++) { // borde de arriba
            System.out.print("#");
        }
        System.out.println();
    }

}

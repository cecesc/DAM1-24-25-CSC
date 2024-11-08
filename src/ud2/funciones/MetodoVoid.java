/*MetodoVoid. Modifica el programa y el método cajaTexto del programa MetodoVoid del material Métodos en Java para que el recuadro se pueda hacer con cualquier carácter que indique el usuario en lugar del hashtag “#”. */
package ud2.funciones;

import java.util.Scanner;

public class MetodoVoid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena, caracter;

        System.out.print("Introduce cadena de texto: ");
        cadena = sc.nextLine();

        System.out.print("Introduce el carácter que quiera: ");
        caracter= sc.nextLine();
        sc.close();
        cajaTexto(cadena, caracter); // llamada al método
    }

    // método que muestra un String rodeado por un borde
    public static void cajaTexto(String str, String caracter) {
        int n = str.length(); // longitud del String

        imprimirlinea(n, caracter);
        System.out.println(caracter + " " + str + " " + caracter); // cadena con un borde en cada lado
        imprimirlinea(n, caracter);
    }

    public static void imprimirlinea(int n, String caracter) {
        for (int i = 1; i <= n + 4; i++) { // borde de arriba
            System.out.print(caracter);
        }
        System.out.println();
    }
}

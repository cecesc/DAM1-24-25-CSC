package ud2;

import java.util.Scanner;

public class Ayuda {
    public static void main(String[] args) {

    // entradas > 1 entradas tienen que ser mayor que uno 


    //Triangulo inverso
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
            System.out.print("* ");
        }
        System.out.println("");
    } 


    //Triangulo inverso
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println("");
    }



    //Triangulo completo
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5 - i - 1; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }


    //Cuadrado
    for (int i = 0; i < tamaño; i++) { // Iterar sobre las filas
        for (int j = 0; j < tamaño; j++) { // Iterar sobre las columnas
            System.out.print("* "); // Imprimir un asterisco
        }
        System.out.println(); // Cambiar de línea después de cada fila
    }


    //Rectangulo
    for (int i = 0; i < filas; i++) { // Iterar sobre las filas
        for (int j = 0; j < columnas; j++) { // Iterar sobre las columnas
            System.out.print("* "); // Imprimir un asterisco
        }
        System.out.println(); // Cambiar de línea después de cada fila
    }


    //Caja con palabra
    // Solicitar al usuario la palabra
    System.out.print("Ingrese una palabra: ");
    String palabra = scanner.nextLine();
    
    // Calcular el tamaño de la caja
    int longitudPalabra = palabra.length();
    int anchoCaja = longitudPalabra + 4; // 2 espacios a cada lado y 2 asteriscos
    int altoCaja = 3; // 1 fila para la parte superior, 1 para la palabra, 1 para la parte inferior
    
    // Imprimir la parte superior de la caja
    for (int i = 0; i < anchoCaja; i++) {
        System.out.print("*");
    }
    System.out.println();
    
    // Imprimir la fila con la palabra
    System.out.print("* " + palabra + " *");
    System.out.println();
    
    // Imprimir la parte inferior de la caja
    for (int i = 0; i < anchoCaja; i++) {
        System.out.print("*");
    }
    System.out.println();


    //Utulizar un try catch
    Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Por favor, ingrese un número: ");
            try {
                numero = Integer.parseInt(scanner.nextLine()); // Intentar convertir la entrada a un número entero
                entradaValida = true; // Si la conversión es exitosa, cambiar la bandera a true
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, intente de nuevo."); // Mensaje de error
            }
        }

        System.out.println("El número ingresado es: " + numero);
        scanner.close();
}
}
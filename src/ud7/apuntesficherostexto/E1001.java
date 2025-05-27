/*Escribir el método Integer leerEntero() que pide un entero por consola, lo lee del teclado y lo devuelve. Si la cadena introducida por consola no tiene el formato correcto, muestra un mensaje de error y vuelve a pedirlo. */
package ud7.apuntesficherostexto;

import java.util.Scanner;

public class E1001 {

    public static Integer leerEntero() {
        Scanner sc = new Scanner(System.in);
        Integer numero = null;
        boolean valido = false;

        while (!valido) {
            System.out.print("Introduce un número entero: ");
            String entrada = sc.nextLine();

            try {
                numero = Integer.parseInt(entrada);
                valido = true; // se ha introducido un número válido
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un número entero válido.");
            }
        }
        sc.close();
        return numero;
        
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Integer valor = leerEntero();
        System.out.println("Has introducido: " + valor);
    }
}

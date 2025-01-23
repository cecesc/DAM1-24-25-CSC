/*Escribir un programa que pida el nombre completo al usuario y lo muestre sin 
vocales (mayúsculas, minúsculas y acentuadas). Por ejemplo, “Álvaro Pérez” 
quedaría como “lvr Prz”.

Implementa un método con el siguiente prototipo:

static String sinVocales(String cad)
 */

package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre completo: ");
        String nombreCompleto = sc.nextLine();
        String resultado = sinVocales(nombreCompleto);
        System.out.println("Nombre sin vocales: " + resultado);
        sc.close();
    }

    static String sinVocales(String cad) {
        String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ";
        String resultado = "";

        for (char c : cad.toCharArray()) {
            if (vocales.indexOf(c) == -1) {
                resultado += c;
            }
        }
        return resultado;
    }
}

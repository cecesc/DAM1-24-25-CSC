/*E0605. Diseña una función a la que se le pase una cadena de caracteres y la devuelva invertida. 
Por ejemplo: la cadena “Hola mundo” se devolvería como “odnum aloH”. Puedes implementar un método 
con el siguiente prototipo: static String invertirCadena(String cad) */

package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena de caracteres: ");
        String cadena = sc.nextLine();

        String cadenaInvertida = invertirCadena(cadena);
        System.out.println(cadenaInvertida); 
        sc.close();
    }

    static String invertirCadena(String cad) {
        StringBuilder cadenaInvertida = new StringBuilder(cad);
        return cadenaInvertida.reverse().toString();
    }
}

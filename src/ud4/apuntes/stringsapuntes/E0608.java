/*Los habitantes de Javalandia tienen un idioma algo extraño; cuando hablan
siempre comienzan sus frases con “Javalín, javalón”, para después hacer una pausa más
o menos larga (la pausa se representa mediante espacios en blanco o tabuladores) y a
continuación expresan el mensaje.
Existe un dialecto que no comienza sus frases con la muletilla anterior, pero siempre las
terminan con un silencio, más o menos prolongado y la coletilla “javalén, len, len”.
Se pide diseñar un traductor que, en primer lugar, nos diga si la frase introducida está
escrita en el idioma de Javalandia (en cualquiera de sus dialectos), y en caso afirmativo,
nos muestre solo el mensaje sin muletillas. */

package ud4.apuntes.stringsapuntes;

import java.util.Scanner;

public class E0608 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String frase = sc.nextLine();

        String mensaje = traducirFrase(frase);
        if (mensaje != null) {
            System.out.println("Mensaje traducido: " + mensaje);
        } else {
            System.out.println("La frase no está en el idioma de Javalandia.");
        }
        sc.close();
    }

    static String traducirFrase(String frase) {
        String muletillaInicio = "Javalín, javalón";
        String muletillaFin = "javalén, len, len";

        if (frase.startsWith(muletillaInicio)) {
            String mensaje = frase.substring(muletillaInicio.length()).trim();
            return mensaje;
        }

        if (frase.endsWith(muletillaFin)) {
            String mensaje = frase.substring(0, frase.length() - muletillaFin.length()).trim();
            return mensaje; 
        }

        return null;
    }
}
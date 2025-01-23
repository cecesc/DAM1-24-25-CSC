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
//Celia Sanmartín Chapela
package ud4.arraysejercicios;

import java.util.Random;

public class ConceptosProgramacion {
    public static String fraseAleatoria(String[] t) {
        Random rdn = new Random();

        for (int i = 0; i < t.length; i++) {
            int j = rdn.nextInt(t.length);
            String temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
        
        return null;
    }

    public static void main(String[] args) {
        String[] t = { "Algoritmo", "Lenguaje de programacion", "Entorno de desarrollo", "Compilación", "Ejecución",
                "Código fuente", "Bytecode", "Código objeto" };
        fraseAleatoria(t);
        System.out.print("Concepto: " + java.util.Arrays.toString(t));
    }
}

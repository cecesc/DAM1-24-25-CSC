/*Los siguientes términos corresponden a conceptos que el alumnado de programación en Java debe conocer:
"Algoritmo", "Lenguaje de programación", "Entorno de desarrollo", "Compilación", "Ejecución", "Código fuente", "Bytecode", "Código objeto"
Realiza un programa que almacene los términos anteriores en un array de datos de tipo String y que muestre uno de ellos por pantalla elegido 
al azar. Para ello implementa una función que devuelva uno de los términos del array elegido al azar, con el siguiente prototipo:
static String fraseAleatoria(String[] t)  */

package ud4.arraysejercicios;

import java.util.Random;

public class ConceptosProgramacion {
    public static String fraseAleatoria(String[] t) {
        int indiceAleatorio;
        Random rdn = new Random();

        indiceAleatorio = rdn.nextInt(t.length);

        return(t[indiceAleatorio]);

    }

    public static void main(String[] args) {
        String[] conceptos = { "Algoritmo", "Lenguaje de programacion", "Entorno de desarrollo", "Compilación", "Ejecución",
                "Código fuente", "Bytecode", "Código objeto" };
        System.out.print(fraseAleatoria(conceptos));
    }
}

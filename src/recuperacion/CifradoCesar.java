package recuperacion;
/*Uno de los métodos más antiguos para codificar mensajes es el conocido como cifrado César. Su funcionamiento es simple: cada una de las letras del mensaje original es sustituida por otra letra que se encuentra un número fijo de posiciones más adelante (o más atrás) en el alfabeto.

Así, si utilizamos un desplazamiento de 2, las apariciones de la letra 'a' se sustituyen por la 'c', todas las apariciones de la 'b' por 'd', etc. El método tradicional comienza de nuevo al llegar al final del alfabeto, de forma que, con el desplazamiento de 2, la 'y' se sustituye por la 'a' y la 'z' se sustituye por la 'b'. Los desplazamientos también pueden ser negativos; si utilizamos un desplazamiento de -1, la 'E' se convertirá en 'D', mientras que la 'a' pasará a ser 'z'.

Nuestro cifrado Cesar no codifica los caracteres que no sean letras anglosajonas. Así, por ejemplo, los espacios, vocales con tildes o diéresis o los símbolos de puntuación no sufrirán cambio alguno.

Realiza y prueba dos funciones para encriptar y desencriptar mensajes utilizando este cifrado siguiendo los siguientes prototipos:

String encriptarCesar(String cadena, int desplazamiento);
Encripta la cadena que se le pasa como parámetro usando el desplazamiento indicado, que puede ser positivo o negativo.


String desencriptarCesar(String cadena, int desplazamiento);
Desencripta la cadena que se le pasa como parámetro usando el desplazamiento indicado, que puede ser positivo o negativo.


Nota: Ten en cuenta que, en función de la versión del JDK, el método isLetter() de la clase Character puede considerar o no como letras las vocales acentuadas.

Nota2: Códigos ASCII/Unicode de las siguientes letras: ‘A’=65, ‘Z’=90, ‘a’=97, ‘z’=122.  Solicita la tabla ASCII si es necesario.

Ideas:
Variable auxiliar: String textoCifrado;
Podemos usar la aritmética de caracteres o un índice numérico de un posible  array o string de letras cifrables.
Fíjate que descifrar es igual a cifrar con el desplazamiento invertido. Desde una función podemos llamar a la otra.
Implementa un array int[] letrasCifrables; cuyo contenido son las letras anglosajonas en mayúscula.
Módulo: boolean esLetraCifrable(char ch); que devuelva true si el caracter se encuentra en el array anterior, independientemente de que sea mayúscula minúscula.
Módulo: char cifrarLetra(char ch, int desplazamiento);
Recorremos el array original con un bucle controlado por contador, concatenando en el texto cifrado cada caracter, tal cual si no es cifrable, o cifrado si sí lo es.
Responde descifrando a frase: Zkcklóxd! Dfzockmrod k zkceo zcëmesmk nk FN3!!!!
*/
public class CifradoCesar {

    // Función principal para encriptar
    public static String encriptarCesar(String cadena, int desplazamiento) {
        StringBuilder textoCifrado = new StringBuilder();

        for (char ch : cadena.toCharArray()) {
            if (esLetraCifrable(ch)) {
                textoCifrado.append(cifrarLetra(ch, desplazamiento));
            } else {
                textoCifrado.append(ch); // No se cifra
            }
        }

        return textoCifrado.toString();
    }

    // Función para desencriptar (llama a encriptar con el desplazamiento invertido)
    public static String desencriptarCesar(String cadena, int desplazamiento) {
        return encriptarCesar(cadena, -desplazamiento);
    }

    // Devuelve true si el carácter es una letra entre a-z o A-Z
    private static boolean esLetraCifrable(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    // Cifra una sola letra teniendo en cuenta si es mayúscula o minúscula
    private static char cifrarLetra(char ch, int desplazamiento) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) ((ch - 'A' + desplazamiento + 26) % 26 + 'A');
        } else {
            return (char) ((ch - 'a' + desplazamiento + 26) % 26 + 'a');
        }
    }

    // Para probar descifrado
    public static void main(String[] args) {
        String mensaje = "Zkcklóxd! Dfzockmrod k zkceo zcëmesmk nk FN3!!!!";
        String descifrado = desencriptarCesar(mensaje, 10); // Probamos con desplazamiento 10
        System.out.println("Descifrado: " + descifrado);
    }
}

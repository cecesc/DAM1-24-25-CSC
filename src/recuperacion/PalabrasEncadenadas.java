package recuperacion;
/*Entrada: una serie de entre 1 y 50 palabras en una misma línea. Cada palabra, de un mínimo de 2 caracteres y un máximo de 24, está separada de la siguiente mediante un espacio.

Podemos suponer que las palabras utilizadas están formadas por sílabas de dos letras.
Se considera que dos palabras están encadenadas si la última sílaba de la primera palabra es igual que la primera de la segunda. Para las palabras que tienen una única sílaba, ésta se considera simultáneamente la primera y la última.

Exigiremos que no sólo el sonido sea igual, sino que la grafía también lo sea. No obstante, todas las palabras se escribirán en minúscula y no se tendrán vocales con tilde u otros símbolos no pertenecientes al alfabeto inglés.

Salida: true si todas las palabras de la serie están correctamente encadenadas, y false en caso contrario. */
import java.util.List;

public class PalabrasEncadenadas {
public static void main(String[] args) {
        List<String> pruebas = List.of(
            "gugutata",
            "mata tapa papa pato",
            "seto taco coma matute",
            "sien encima mapa patuco comida",
            "cata tasama malote tejaba batama",
            "kiosko comida",
            "",
            "gugutata a",
            "mata abcdefghijklmnopqrstuvwxyz",
            "seto ñoño",
            "Seto"
        );

        for (String linea : pruebas) {
            try {
                boolean resultado = PalabrasEncadenadas.estanEncadenadas(linea);
                System.out.println("Entrada: \"" + linea + "\" → " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada: \"" + linea + "\" → Exception: " + e.getMessage());
            }
        }
    }
    public static boolean estanEncadenadas(String linea) {
        if (linea == null) {
            throw new IllegalArgumentException("Entrada null");
        }

        linea = linea.trim();
        if (linea.isEmpty()) {
            throw new IllegalArgumentException("Entrada vacía");
        }

        String[] palabras = linea.split("\\s+");
        for (String palabra : palabras) {
            if (palabra.length() < 2) {
                throw new IllegalArgumentException("Palabra de una letra");
            }
            if (palabra.length() > 24) {
                throw new IllegalArgumentException("Palabra de más de 24 letras");
            }

            for (int i = 0; i < palabra.length(); i++) {
                char c = palabra.charAt(i);
                if (c < 'a' || c > 'z') {
                    if (c >= 'A' && c <= 'Z') {
                        throw new IllegalArgumentException("Palabra con mayúsculas");
                    } else {
                        throw new IllegalArgumentException("Palabra con caracteres no anglosajones");
                    }
                }
            }
        }

        for (int i = 0; i < palabras.length - 1; i++) {
            String palabraActual = palabras[i];
            String palabraSiguiente = palabras[i + 1];

            String ultimaSilaba = palabraActual.substring(palabraActual.length() - 2);
            String primeraSilaba = palabraSiguiente.substring(0, 2);

            if (!ultimaSilaba.equals(primeraSilaba)) {
                return false;
            }
        }

        return true;
    }
}



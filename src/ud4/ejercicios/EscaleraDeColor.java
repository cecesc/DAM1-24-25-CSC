package ud4.ejercicios;

import java.util.Scanner;
import java.util.Arrays;

public class EscaleraDeColor {

    // Arreglos para los valores y sus representaciones
    private static final String[] valoresCartas = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };

    private static final int[] valoresNumericos = {
            2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las cartas (0 para terminar):");
        String linea = scanner.nextLine();

        while (!linea.equals("0")) {
            String[] cartas = linea.split(" ");
            int[] valores = new int[cartas.length];
            String palo = null;

            for (int i = 0; i < cartas.length; i++) {
                String valor = cartas[i].substring(0, cartas[i].length() - 1);
                String simbolo = cartas[i].substring(cartas[i].length() - 1);
                valores[i] = getValorNumerico(valor);
                if (palo == null) {
                    palo = simbolo; // Guardamos el palo de la primera carta
                } else if (!palo.equals(simbolo)) {
                    palo = null; // Si hay diferentes palos, no se puede formar escalera de color
                }
            }

            if (palo == null) {
                System.out.println("NADA");
            } else {
                // Ordenar los valores de las cartas
                Arrays.sort(valores);
                int cartaFaltante = -1;

                // Verificar si se puede formar una escalera
                for (int i = 0; i < valores.length - 1; i++) {
                    int actual = valores[i];
                    int siguiente = valores[i + 1];
                    if (siguiente - actual > 1) {
                        // Hay un hueco, podemos colocar la carta faltante
                        cartaFaltante = actual + 1;
                        break;
                    }
                }

                // Verificar si se puede añadir un As después de un K
                if (cartaFaltante == -1 && contains(valores, 13) && !contains(valores, 14)) {
                    cartaFaltante = 14; // As
                }

                // Verificar si la carta faltante es válida
                if (cartaFaltante != -1 && cartaFaltante <= 14 && !contains(valores, cartaFaltante)) {
                    String valorFaltante = getValorString(cartaFaltante);
                    System.out.println(valorFaltante + palo);
                } else {
                    System.out.println("NADA");
                }
            }

            System.out.println("Ingrese las cartas (0 para terminar):");
            linea = scanner.nextLine();
        }

        scanner.close();
    }

    // Método para obtener el valor numérico de una carta
    private static int getValorNumerico(String valor) {
        for (int i = 0; i < valoresCartas.length; i++) {
            if (valoresCartas[i].equals(valor)) {
                return valoresNumericos[i];
            }
        }
        return -1; // Valor no encontrado
    }

    // Método para obtener la representación de una carta a partir de su valor numérico
    private static String getValorString(int valor) {
        for (int i = 0; i < valoresNumericos.length; i++) {
            if (valoresNumericos[i] == valor) {
                return valoresCartas[i];
            }
        }
        return ""; // Valor no encontrado
    }

    // Método para verificar si un arreglo contiene un valor
    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
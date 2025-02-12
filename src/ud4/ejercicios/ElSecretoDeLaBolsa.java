package ud4.ejercicios;

import java.util.Scanner;

public class ElSecretoDeLaBolsa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada
        System.out.println("Ingrese la suma clave y la secuencia de dígitos:");
        String input = scanner.nextLine();
        String[] partes = input.split(" ");

        int sumaClave = Integer.parseInt(partes[0]); // Suma clave
        String secuencia = partes[1]; // Secuencia de dígitos

        int contador = 0; // Contador de coincidencias

        // Calcular las sumas de dígitos consecutivos
        for (int i = 0; i < secuencia.length(); i++) {
            for (int j = i + 1; j <= secuencia.length(); j++) {
                // Obtener el bloque de dígitos
                String bloque = secuencia.substring(i, j);
                // Calcular la suma de los dígitos en el bloque
                int sumaBloque = 0;
                for (char c : bloque.toCharArray()) {
                    sumaBloque += Character.getNumericValue(c);
                }
                // Comparar con la suma clave
                if (sumaBloque == sumaClave) {
                    contador++;
                }
            }
        }

        // Imprimir el resultado
        System.out.println(contador);

        scanner.close();
    }
}
package ud4.ejercicios;

import java.util.Scanner;

public class YongeStreet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la situación de Yonge Street
        String calle = scanner.nextLine();
        int longitud = calle.length();

        // Crear un arreglo para almacenar la posición final de cada carácter
        char[] resultado = new char[longitud];

        // Inicializar el resultado con los caracteres de la calle
        for (int i = 0; i < longitud; i++) {
            resultado[i] = calle.charAt(i);
        }

        // Simular el movimiento de los vehículos
        for (int i = 0; i < longitud; i++) {
            if (Character.isLetter(calle.charAt(i))) { // Si es un vehículo
                // Mover el vehículo hasta el semáforo más cercano
                int j = i;
                while (j < longitud && resultado[j] != '|') {
                    j++;
                }
                // El vehículo se detiene justo antes del semáforo
                if (j > i) {
                    resultado[j - 1] = calle.charAt(i); // Colocar el vehículo en la posición final
                    resultado[i] = '.'; // Dejar la posición original libre
                }
            }
        }

        // Leer las consultas
        String[] consulta = scanner.nextLine().split(" ");
        int n = Integer.parseInt(consulta[0]);
        StringBuilder salida = new StringBuilder();

        // Procesar cada consulta
        for (int i = 1; i <= n; i++) {
            int posicion = Integer.parseInt(consulta[i]) - 1; // Convertir a índice 0
            salida.append(resultado[posicion]); // Agregar el resultado a la salida
            if (i < n) {
                salida.append(" "); // Agregar espacio entre respuestas
            }
        }

        // Imprimir la salida
        System.out.println(salida.toString());

        scanner.close();
    }
}
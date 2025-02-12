package ud4.ejercicios;

import java.util.Scanner;

public class TomasIneditas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cadena de movimientos
        System.out.print("Ingrese la cadena de movimientos (deje vacío para terminar): ");
        String input = scanner.nextLine(); // Leer la cadena de movimientos

        while (!input.isEmpty()) { // Continuar mientras la entrada no esté vacía
            // Inicializar variables
            int altura = 0; // Altura inicial
            int maxAltura = 0; // Altura máxima para determinar el tamaño del marco
            int length = input.length(); // Longitud de la entrada

            // Calcular la altura máxima
            for (char c : input.toCharArray()) {
                if (c == 'S') {
                    altura++;
                } else if (c == 'B') {
                    altura--;
                }
                maxAltura = Math.max(maxAltura, altura);
            }

            // Crear el marco
            char[][] grafica = new char[maxAltura + 1][length];
            for (int i = 0; i <= maxAltura; i++) {
                for (int j = 0; j < length; j++) {
                    grafica[i][j] = ' '; // Inicializar con espacios
                }
            }

            // Dibujar la gráfica
            altura = 0; // Reiniciar altura para dibujar
            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);
                if (c == 'S') {
                    altura++;
                    grafica[maxAltura - altura][i] = '/';
                } else if (c == 'B') {
                    grafica[maxAltura - altura][i] = '\\';
                    altura--;
                } else { // c == 'I'
                    grafica[maxAltura - altura][i] = '_';
                }
            }

            // Imprimir el marco
            System.out.println("#" + "-".repeat(length) + "#");
            for (int i = 0; i <= maxAltura; i++) {
                System.out.print("#");
                for (int j = 0; j < length; j++) {
                    System.out.print(grafica[i][j]);
                }
                System.out.println("#");
            }
            System.out.println("#" + "-".repeat(length) + "#");

            // Leer nuevamente la cadena de movimientos
            System.out.print("Ingrese la cadena de movimientos (deje vacío para terminar): ");
            input = scanner.nextLine(); // Leer la cadena de movimientos
        }

        scanner.close();
    }
}
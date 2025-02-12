package ud4.ejercicios;

import java.util.Scanner;

public class ElAlcanceDeLasHistorias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de páginas leídas
        System.out.print("Ingrese el número de páginas leídas: ");
        int n = scanner.nextInt();

        // Leer la secuencia de páginas
        System.out.println("Ingrese la secuencia de páginas (separadas por espacio):");
        int[] paginas = new int[n];
        for (int i = 0; i < n; i++) {
            paginas[i] = scanner.nextInt();
        }

        // Calcular el alcance
        int alcance = Integer.MIN_VALUE; // Inicializar con el valor mínimo posible

        // Iterar sobre cada página
        for (int i = 0; i < n; i++) {
            // Comparar con las páginas que siguen
            for (int j = i + 1; j < n; j++) {
                int diferencia = paginas[i] - paginas[j];
                if (diferencia > alcance) {
                    alcance = diferencia; // Actualizar el alcance si encontramos una diferencia mayor
                }
            }
        }

        // Imprimir el resultado
        System.out.println("El alcance de la historia es: " + alcance);

        scanner.close();
    }
}
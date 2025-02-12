package ud4.ejercicios;

import java.util.Scanner;

public class ColocandoBarcos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de posiciones ocupadas
        System.out.print("Ingrese la cantidad de posiciones ocupadas: ");
        int n = scanner.nextInt();

        while (n > 0) {
            // Leer las posiciones ocupadas
            System.out.println("Ingrese las posiciones ocupadas (fila columna):");
            int[][] posiciones = new int[n][2];

            for (int i = 0; i < n; i++) {
                posiciones[i][0] = scanner.nextInt(); // Fila
                posiciones[i][1] = scanner.nextInt(); // Columna
            }

            // Calcular la distancia máxima
            int maxDistancia = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // Calcular la distancia de Manhattan
                    int distancia = Math.abs(posiciones[i][0] - posiciones[j][0]) +
                            Math.abs(posiciones[i][1] - posiciones[j][1]);
                    if (distancia > maxDistancia) {
                        maxDistancia = distancia; // Actualizar la distancia máxima
                    }
                }
            }

            // Imprimir el resultado
            System.out.println("La distancia máxima entre dos posiciones ocupadas es: " + maxDistancia);

            // Leer el siguiente número de posiciones ocupadas
            System.out.print("Ingrese la cantidad de posiciones ocupadas: ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
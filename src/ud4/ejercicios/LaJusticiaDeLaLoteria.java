package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class LaJusticiaDeLaLoteria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de localidades
        System.out.print("Ingrese el número de localidades: ");
        int n = scanner.nextInt();

        // Procesar solo si hay localidades
        if (n > 0) {
            int[][] datos = new int[n][2];

            // Leer los datos de cada localidad
            System.out.println("Ingrese el dinero invertido y los premios ganados (separados por espacio):");
            for (int i = 0; i < n; i++) {
                datos[i][0] = scanner.nextInt(); // Dinero invertido
                datos[i][1] = scanner.nextInt(); // Premios ganados
            }

            // Ordenar las localidades por dinero invertido
            Arrays.sort(datos, (a, b) -> Integer.compare(a[0], b[0]));

            // Verificar si la lotería fue justa
            boolean justa = true;
            for (int i = 1; i < n; i++) {
                if (datos[i][0] > datos[i - 1][0] && datos[i][1] <= datos[i - 1][1]) {
                    justa = false;
                    break;
                }
            }

            // Imprimir el resultado
            if (justa) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("No se procesará ninguna localidad.");
        }

        scanner.close();
    }
}
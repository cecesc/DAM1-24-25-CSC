package ud4.ejercicios;

import java.util.Scanner;

public class MataMoscas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de columnas y filas
        System.out.println("Ingrese el número de columnas y filas (0 0 para terminar):");
        int tx = scanner.nextInt(); // Número de columnas
        int ty = scanner.nextInt(); // Número de filas

        if (tx == 0 && ty == 0) {
            return; // Terminar si se recibe 0 0
        }

        System.out.println("Ingrese el ancho y alto del matamoscas:");
        int mx = scanner.nextInt(); // Ancho del matamoscas
        int my = scanner.nextInt(); // Alto del matamoscas

        // Leer la mesa
        char[][] mesa = new char[ty][tx];
        System.out.println("Ingrese la mesa (cada fila como una cadena):");
        for (int i = 0; i < ty; i++) {
            mesa[i] = scanner.next().toCharArray();
        }

        // Contar las posiciones
        int[] conteo = new int[8]; // Conteo de posiciones para 0 a 7 moscas

        // Recorrer todas las posiciones posibles del matamoscas
        for (int i = 0; i <= ty - my; i++) {
            for (int j = 0; j <= tx - mx; j++) {
                int moscasMuertas = 0;

                // Contar moscas en la región cubierta por el matamoscas
                for (int k = 0; k < my; k++) {
                    for (int l = 0; l < mx; l++) {
                        if (mesa[i + k][j + l] == 'X') {
                            moscasMuertas++;
                        }
                    }
                }

                // Clasificar la posición según el número de moscas muertas
                if (moscasMuertas >= 0 && moscasMuertas <= 7) {
                    conteo[moscasMuertas]++;
                } else {
                    conteo[7]++; // Para más de 7 moscas
                }
            }
        }

        // Imprimir el resultado
        for (int i = 0; i < conteo.length; i++) {
            System.out.print(conteo[i]);
            if (i < conteo.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); // Nueva línea después de cada caso

        scanner.close(); // Cerrar el escáner al final
    }
}
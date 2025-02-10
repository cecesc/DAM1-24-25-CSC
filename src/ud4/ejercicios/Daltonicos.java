package ud4.ejercicios;

import java.util.Scanner;

public class Daltonicos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer conjunto de datos
        int filas = scanner.nextInt();
        int columnas = scanner.nextInt();

        // Continuar procesando mientras filas y columnas no sean 0
        while (filas != 0 || columnas != 0) {
            // Leer el cuadro
            char[][] cuadro = new char[filas][columnas];
            for (int i = 0; i < filas; i++) {
                cuadro[i] = scanner.next().toCharArray();
            }

            // Leer el número de daltónicos
            int numDaltónicos = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea restante

            // Aplicar las transformaciones de cada daltónico
            for (int i = 0; i < numDaltónicos; i++) {
                String transformacion = scanner.nextLine();
                char colorOriginal = transformacion.charAt(0);
                char colorSustituto = transformacion.charAt(1);

                // Reemplazar los colores en el cuadro
                for (int j = 0; j < filas; j++) {
                    for (int k = 0; k < columnas; k++) {
                        if (cuadro[j][k] == colorOriginal) {
                            cuadro[j][k] = colorSustituto;
                        }
                    }
                }
            }

            // Imprimir el cuadro resultante
            for (int i = 0; i < filas; i++) {
                System.out.println(cuadro[i]);
            }

            // Leer el siguiente conjunto de datos
            filas = scanner.nextInt(); // Leer el número de filas
            columnas = scanner.nextInt(); // Leer el número de columnas
        }

        scanner.close();
    }
}
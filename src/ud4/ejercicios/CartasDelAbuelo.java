package ud4.ejercicios;

import java.util.Scanner;

public class CartasDelAbuelo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cadena escrita por el abuelo
        System.out.print("Ingrese la cadena escrita por el abuelo: ");
        String cadena = scanner.nextLine();

        // Leer el número de intervalos
        System.out.print("Ingrese el número de intervalos: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        while (n != 0) { // Continuar mientras n no sea 0
            String[] resultados = new String[n]; // Arreglo para almacenar resultados

            for (int k = 0; k < n; k++) {
                System.out.print("Ingrese el intervalo (i j): ");
                String[] intervalos = scanner.nextLine().split(" ");
                int i = Integer.parseInt(intervalos[0]);
                int j = Integer.parseInt(intervalos[1]);

                // Determinar el rango
                int start = Math.min(i, j);
                int end = Math.max(i, j);

                // Verificar si todos los caracteres en el rango son iguales
                char firstChar = cadena.charAt(start);
                boolean allEqual = true;

                for (int index = start; index <= end; index++) {
                    if (cadena.charAt(index) != firstChar) {
                        allEqual = false;
                        break;
                    }
                }

                // Almacenar resultado
                resultados[k] = allEqual ? "SI" : "NO";
            }

            // Imprimir resultados
            for (String resultado : resultados) {
                System.out.println(resultado);
            }

            System.out.println(); // Línea en blanco adicional al final de cada caso de prueba

            // Leer la siguiente cadena para el siguiente caso de prueba
            System.out.print("Ingrese la nueva cadena escrita por el abuelo: ");
            cadena = scanner.nextLine();
            System.out.print("Ingrese el nuevo número de intervalos: ");
            n = scanner.nextInt(); // Leer el nuevo número de intervalos
            scanner.nextLine(); // Consumir el salto de línea
        }

        scanner.close(); // Cerrar el escáner al final
    }
}
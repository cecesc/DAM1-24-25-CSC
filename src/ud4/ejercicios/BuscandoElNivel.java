package ud4.ejercicios;

import java.util.Scanner;

public class BuscandoElNivel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de niveles
        System.out.print("Ingrese la cantidad de niveles (0 para terminar): ");
        int n = scanner.nextInt();

        // Terminar si se encuentra con un caso sin niveles
        if (n == 0) {
            scanner.close();
            return;
        }

        // Leer las longitudes de los niveles
        int[] longitudes = new int[n];
        System.out.println("Ingrese las longitudes de cada nivel:");
        for (int i = 0; i < n; i++) {
            longitudes[i] = scanner.nextInt();
        }

        // Calcular las posiciones acumuladas
        int[] posiciones = new int[n + 1]; // +1 para incluir la posición inicial (0)
        for (int i = 1; i <= n; i++) {
            posiciones[i] = posiciones[i - 1] + longitudes[i - 1];
        }

        // Leer el número de subconsultas
        System.out.print("Ingrese la cantidad de subconsultas: ");
        int q = scanner.nextInt();

        // Procesar cada subconsulta
        System.out.println("Ingrese las subconsultas (a b):");
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt(); // Último nivel cargado
            int b = scanner.nextInt(); // Siguiente nivel a cargar

            // Calcular el desplazamiento
            int desplazamiento = posiciones[b - 1] - posiciones[a - 1];
            System.out.println(desplazamiento);
        }

        scanner.close();
    }
}
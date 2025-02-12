package ud4.ejercicios;

import java.util.Scanner;

public class TiraYAfloja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de alumnos
        System.out.print("Ingrese el número de alumnos (0 para terminar): ");
        int n = scanner.nextInt();

        while (n != 0) { // Continuar mientras no se reciba 0
            int[] pesos = new int[n];
            System.out.println("Ingrese los pesos de los alumnos:");
            for (int i = 0; i < n; i++) {
                pesos[i] = scanner.nextInt(); // Leer el peso de cada alumno
            }

            // Calcular el peso total
            int pesoTotal = 0;
            for (int peso : pesos) {
                pesoTotal += peso;
            }

            int pesoIzquierda = 0;
            int posiblesPosiciones = 0;
            int posicionFinal = -1;

            // Iterar sobre las posiciones
            for (int i = 0; i < n - 1; i++) { // n-1 porque la última posición no puede ser una línea divisoria
                pesoIzquierda += pesos[i];
                int pesoDerecha = pesoTotal - pesoIzquierda;

                // Verificar si la diferencia de peso es la misma
                if (pesoIzquierda == pesoDerecha) {
                    posiblesPosiciones++;
                    posicionFinal = i + 1; // Guardar la posición (número de alumnos a la izquierda)
                }
            }

            // Imprimir resultados
            if (posiblesPosiciones == 1) {
                System.out.println(posicionFinal + " " + pesoIzquierda + " " + (pesoTotal - pesoIzquierda));
            } else {
                System.out.println("NO JUEGAN");
            }

            // Leer el siguiente número de alumnos
            System.out.print("Ingrese el número de alumnos (0 para terminar): ");
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
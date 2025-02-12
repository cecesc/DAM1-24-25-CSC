package ud4.ejercicios;

import java.util.Scanner;

public class LuchaDeEgos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de superhéroes
        System.out.print("Ingrese el número de superhéroes: ");
        int N = scanner.nextInt();

        while (N > 0) {
            int[] destrezas = new int[N];
            String[] preferencias = new String[N];
            boolean[] emparejado = new boolean[N]; // Para marcar si un superhéroe ya fue emparejado

            // Leer las destrezas
            System.out.println("Ingrese las destrezas de los superhéroes (1-5):");
            for (int i = 0; i < N; i++) {
                destrezas[i] = scanner.nextInt();
            }

            // Leer las preferencias
            System.out.println("Ingrese las preferencias de los superhéroes (<N, =N, >N):");
            for (int i = 0; i < N; i++) {
                preferencias[i] = scanner.next();
            }

            // Array para almacenar los emparejamientos
            String[] emparejamientos = new String[N]; // Máximo N emparejamientos
            int emparejamientosCount = 0; // Contador de emparejamientos

            // Emparejar superhéroes
            for (int i = 0; i < N; i++) {
                if (emparejado[i]) continue; // Si ya está emparejado, saltar

                for (int j = i + 1; j < N; j++) {
                    if (emparejado[j]) continue; // Si el oponente ya está emparejado, saltar

                    // Verificar si se pueden emparejar
                    if (puedenEmparejarse(destrezas[i], preferencias[i], destrezas[j], preferencias[j])) {
                        emparejamientos[emparejamientosCount++] = (i + 1) + " " + (j + 1); // Guardar el emparejamiento
                        emparejado[i] = true; // Marcar como emparejado
                        emparejado[j] = true; // Marcar como emparejado
                        break; // Salir del bucle interno
                    }
                }
            }

            // Imprimir los emparejamientos
            if (emparejamientosCount == 0) {
                System.out.println("NO HAY");
            } else {
                for (int k = 0; k < emparejamientosCount; k++) {
                    System.out.println(emparejamientos[k]);
                }
            }

            // Leer el siguiente número de superhéroes
            System.out.print("Ingrese el número de superhéroes: ");
            N = scanner.nextInt();
        }

        scanner.close();
    }

    // Método para verificar si dos superhéroes pueden emparejarse
    private static boolean puedenEmparejarse(int destreza1, String preferencia1, int destreza2, String preferencia2) {
        return cumplePreferencia(destreza1, preferencia2, destreza2) && cumplePreferencia(destreza2, preferencia1, destreza1);
    }

    // Método para verificar si un superhéroe cumple con la preferencia de otro
    private static boolean cumplePreferencia(int destreza, String preferencia, int oponente) {
        if (preferencia.startsWith("<")) {
            int limite = Integer.parseInt(preferencia.substring(1));
            return destreza < limite;
        } else if (preferencia.startsWith("=")) {
            int limite = Integer.parseInt(preferencia.substring(1));
            return destreza == limite;
        } else if (preferencia.startsWith(">")) {
            int limite = Integer.parseInt(preferencia.substring(1));
            return destreza > limite;
        }
        return false;
    }
}
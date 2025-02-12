package ud4.ejercicios;

import java.util.Scanner;

public class DigitosSaltarines {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        for (int caseNum = 0; caseNum < n; caseNum++) {
            String numero = scanner.nextLine();
            int longitud = numero.length();
            boolean[] visitado = new boolean[longitud]; // Para marcar los dígitos visitados
            int posicion = 0; // Comenzar desde el primer dígito
            int saltos = 0; // Contador de saltos

            // Simular el salto de dígitos
            for (int i = 0; i < longitud; i++) {
                if (visitado[posicion]) {
                    // Si ya hemos visitado esta posición, no es saltarín
                    System.out.println("NORMALES");
                    break;
                }
                visitado[posicion] = true; // Marcar como visitado
                saltos = Character.getNumericValue(numero.charAt(posicion)); // Obtener el número de saltos
                posicion = (posicion + saltos) % longitud; // Calcular la nueva posición
            }

            // Verificar si todos los dígitos fueron visitados
            if (posicion == 0 && allVisited(visitado)) {
                System.out.println("SALTARINES");
            }
        }

        scanner.close();
    }

    // Método para verificar si todos los dígitos fueron visitados
    private static boolean allVisited(boolean[] visitado) {
        for (boolean v : visitado) {
            if (!v) {
                return false; // Si hay algún dígito no visitado
            }
        }
        return true; // Todos los dígitos fueron visitados
    }
}
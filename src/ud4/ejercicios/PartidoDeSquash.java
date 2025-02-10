package ud4.ejercicios;

import java.util.Scanner;

public class PartidoDeSquash {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la primera línea de entrada
        String partido = scanner.nextLine();

        while (!partido.equals("F")) {
            // Inicializar variables
            int setsA = 0, setsB = 0;
            int puntosA = 0, puntosB = 0;
            StringBuilder resultado = new StringBuilder();
            boolean saqueA = true; // A comienza sacando

            for (char punto : partido.toCharArray()) {
                // Determinar quién ganó el punto
                if (punto == 'A') {
                    if (saqueA) {
                        puntosA++;
                    }
                    // Si B gana el punto, cambia el saque
                    saqueA = false;
                } else if (punto == 'B') {
                    if (!saqueA) {
                        puntosB++;
                    }
                    // Si A gana el punto, cambia el saque
                    saqueA = true;
                }

                // Verificar si alguien ganó el set
                if (puntosA >= 9 && puntosA - puntosB >= 2) {
                    setsA++;
                    resultado.append(puntosA).append("-").append(puntosB).append(" ");
                    puntosA = 0;
                    puntosB = 0;
                    saqueA = true; // A comienza sacando el siguiente set
                } else if (puntosB >= 9 && puntosB - puntosA >= 2) {
                    setsB++;
                    resultado.append(puntosA).append("-").append(puntosB).append(" ");
                    puntosA = 0;
                    puntosB = 0;
                    saqueA = false; // B comienza sacando el siguiente set
                }
            }

            // Imprimir el resultado final
            if (resultado.length() > 0) {
                // Eliminar el último espacio
                resultado.setLength(resultado.length() - 1);
            }
            System.out.println(resultado.toString());

            // Leer la siguiente línea de entrada
            partido = scanner.nextLine();
        }

        scanner.close();
    }
}
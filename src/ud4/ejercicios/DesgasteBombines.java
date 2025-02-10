package ud4.ejercicios;

import java.util.Scanner;

public class DesgasteBombines {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de días
        int n = scanner.nextInt();

        while (n != 0) {
            int[] desgastes = new int[n]; // Arreglo para los desgastes
            for (int i = 0; i < n; i++) {
                desgastes[i] = scanner.nextInt(); // Leer el desgaste de cada día
            }

            // Calcular el desgaste total
            long totalDesgaste = 0;
            for (int desgaste : desgastes) {
                totalDesgaste += desgaste;
            }

            long desgasteAcumulado = 0; // Desgaste acumulado hasta el día actual
            long minDiferencia = Long.MAX_VALUE; // Mínima diferencia encontrada
            int mejorDia = 0; // Día en que el cerrajero debe venir

            // Evaluar cada día
            for (int i = 0; i < n; i++) {
                // Calcular el desgaste si el cerrajero viene este día
                long desgasteSiViene = desgasteAcumulado - desgastes[i] + (totalDesgaste - desgasteAcumulado);
                long diferencia = Math.abs(desgasteSiViene);

                // Actualizar la mejor opción
                if (diferencia < minDiferencia) {
                    minDiferencia = diferencia;
                    mejorDia = i + 1; // Guardar el día (1-indexed)
                }

                // Actualizar el desgaste acumulado
                desgasteAcumulado += desgastes[i];
            }

            // Si no hay necesidad de cerrajero
            if (minDiferencia == 0) {
                System.out.println(0);
            } else {
                System.out.println(mejorDia);
            }

            // Leer el siguiente número de días
            n = scanner.nextInt();
        }

        scanner.close();
    }
}
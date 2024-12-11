package ud2.ejercicios;

import java.util.Scanner;

public class GananciasHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Leer el precio de la habitación y el número de días
            System.out.print("Introduce el precio de la habitación y el número de días: ");
            int precioInicial = scanner.nextInt();
            int N = scanner.nextInt();
            if (N == 0) break; // Terminar si N es 0
            
            long totalCaja = 0; // Total en la caja
            
            // Calcular el día central
            int diaCentral = (N - 1) / 2;
            
            // Procesar cada día
            for (int i = 0; i < N; i++) {
                // Leer el número de habitaciones ocupadas para el día actual
                System.out.print("Introduce el número de habitaciones ocupadas para el día " + (i + 1) + ": ");
                int habitacionesOcupadas = scanner.nextInt();
                
                // Calcular el precio según el día
                int precioHabitacion;
                if (i <= diaCentral) {
                    // Multiplicamos por 3 hasta el día central
                    precioHabitacion = precioInicial * (int) Math.pow(3, i);
                } else {
                    // Dividimos por 3 después del día central
                    precioHabitacion = precioInicial * (int) Math.pow(3, N - 1 - i);
                }
                
                // Calcular las ganancias del día
                long gananciasDelDia = (long) precioHabitacion * habitacionesOcupadas;
                totalCaja += gananciasDelDia;
                
                // Mostrar ganancias del día
                System.out.println("Ganancias del día " + (i + 1) + ": " + gananciasDelDia + " céntimos.");
                
                // Retirar dinero de la caja si es posible
                while (totalCaja >= 78787) {
                    totalCaja -= 78787;
                    System.out.println("Se retiran 78,787 céntimos de la caja. Total en caja ahora: " + totalCaja + " céntimos.");
                }
            }
            
            // Imprimir el total en la caja al final de la temporada
            System.out.println("Total en la caja al final de la temporada: " + totalCaja + " céntimos.");
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}
package ud2.ejercicios;

import java.util.Scanner;

public class Loteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese el premio total y los límites
            System.out.print("Ingrese el premio total, límite diario, límite semanal y límite mensual (0 0 0 0 para salir): ");
            long p = scanner.nextLong(); // Premio total
            long d = scanner.nextLong(); // Límite diario
            long s = scanner.nextLong(); // Límite semanal
            long m = scanner.nextLong(); // Límite mensual
            
            // Terminar si se ingresan todos ceros
            if (p == 0 && d == 0 && s == 0 && m == 0) {
                break;
            }
            
            // Calcular el número de meses completos
            long meses = p / m;
            p %= m; // Resto después de retirar meses
            
            // Calcular el número de semanas completas en el último mes
            long semanas = p / s;
            p %= s; // Resto después de retirar semanas
            
            // Calcular el número de días en la última semana
            long dias = p / d;
            p %= d; // Resto después de retirar días
            
            // Si queda dinero, significa que necesitamos un día más
            if (p > 0) {
                dias++;
            }
            
            // Imprimir el resultado
            System.out.println(meses + " " + semanas + " " + dias);
        }
        
        // Cerrar el Scanner
        scanner.close();
    }
}
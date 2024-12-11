package ud2.ejercicios;

import java.util.Scanner;

public class Ascensor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingrese el piso inicial (número negativo para terminar): ");
            int pisoInicial = scanner.nextInt(); // Leer el piso inicial
            if (pisoInicial < 0) break; // Terminar si el piso inicial es menor que 0
            
            int recorridoTotal = 0;
            int pisoActual = pisoInicial; // Establecer el piso actual al inicial
            
            while (true) {
                System.out.print("Ingrese el piso desde donde llaman (o -1 para terminar): ");
                int pisoDesde = scanner.nextInt(); // Leer el piso desde donde llaman
                if (pisoDesde == -1) break; // Terminar si se encuentra -1
                
                System.out.print("Ingrese el piso destino: ");
                int pisoDestino = scanner.nextInt(); // Leer el piso destino
                
                // Calcular el recorrido desde el piso actual hasta el piso desde
                recorridoTotal += Math.abs(pisoActual - pisoDesde);
                // Calcular el recorrido desde el piso desde hasta el piso destino
                recorridoTotal += Math.abs(pisoDesde - pisoDestino);
                
                // Actualizar el piso actual al destino
                pisoActual = pisoDestino;
            }
            
            // Imprimir el recorrido total para este caso de prueba
            System.out.println("Recorrido total del ascensor: " + recorridoTotal + " pisos.");
        }
        
        System.out.println("Fin del programa.");
        scanner.close();
    }
}
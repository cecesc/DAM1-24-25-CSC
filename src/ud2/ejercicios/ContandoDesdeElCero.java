package ud2.ejercicios;

import java.util.Scanner;

public class ContandoDesdeElCero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese un año
            System.out.print("Ingrese un año (número negativo para salir): ");
            int año = scanner.nextInt(); // Leer el año
            
            // Terminar si se ingresa un año negativo
            if (año < 0) {
                break;
            }
            
            // Convertir el año
            if (año > 0) {
                año--; // Restar 1 si es un año positivo
            }
            // Si el año es negativo, no se hace nada
            
            // Imprimir el resultado
            System.out.println(año);
        }
        
        scanner.close();
    }
}
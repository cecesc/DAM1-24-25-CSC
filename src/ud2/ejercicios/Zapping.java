package ud2.ejercicios;

import java.util.Scanner;

public class Zapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese los canales
            System.out.print("Ingrese el canal A y el canal B (0 0 para salir): ");
            int canalA = scanner.nextInt();
            int canalB = scanner.nextInt();
            
            if (canalA == 0 && canalB == 0) {
                break; // Terminar si se ingresan 0 0
            }
            
            int saltos = calcularSaltos(canalA, canalB);
            System.out.println("Número mínimo de saltos: " + saltos);
        }
        
        scanner.close();
    }
    
    // Función para calcular el número mínimo de saltos
    public static int calcularSaltos(int A, int B) {
        // Diferencia directa
        int diferenciaDirecta = Math.abs(A - B);
        
        // Diferencia circular
        int diferenciaCircular = 99 - diferenciaDirecta;
        
        // Retornar el mínimo de las dos diferencias
        return Math.min(diferenciaDirecta, diferenciaCircular);
    }
}
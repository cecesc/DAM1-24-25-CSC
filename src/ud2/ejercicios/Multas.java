package ud2.ejercicios;

import java.util.Scanner;

public class Multas {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            // Leer los tramos de los drones
            System.out.print("Ingresa el tramo del primer dron (punto inicial y final): ");
            int a1 = scanner.nextInt();
            int b1 = scanner.nextInt();
            
            System.out.print("Ingresa el tramo del segundo dron (punto inicial y final): ");
            int a2 = scanner.nextInt();
            int b2 = scanner.nextInt();
            
            // Asegurarse de que a1 < b1 y a2 < b2
            if (a1 > b1) {
                int temp = a1;
                a1 = b1;
                b1 = temp;
            }
            if (a2 > b2) {
                int temp = a2;
                a2 = b2;
                b2 = temp;
            }
            
            // Verificar si los tramos se solapan
            if (a1 < b2 && a2 < b1) {
                System.out.println("SOLAPADOS");
            } else {
                System.out.println("SEPARADOS");
            }
            
            // Cerrar el Scanner
            scanner.close();
        }
} 


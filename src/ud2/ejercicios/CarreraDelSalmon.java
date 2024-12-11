package ud2.ejercicios;

import java.util.Scanner;

public class CarreraDelSalmon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Solicitar al usuario que ingrese la longitud del recorrido, avance y retroceso
            System.out.print("Ingrese la longitud del recorrido, avance y retroceso (0 0 0 para salir): ");
            int longitudRecorrido = scanner.nextInt();
            int avance = scanner.nextInt();
            int retroceso = scanner.nextInt();
            
            // Terminar si se ingresan tres ceros
            if (longitudRecorrido == 0 && avance == 0 && retroceso == 0) {
                break;
            }
            
            // Calcular el avance neto
            int avanceNeto = avance - retroceso;
            
            // Si el avance neto es menor o igual a cero y no puede llegar en el primer avance
            if (avanceNeto <= 0) {
                if (avance < longitudRecorrido) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(1); // Puede llegar en el primer intento
                }
            } else {
                // Contar los ciclos necesarios
                int posicion = 0;
                int ciclos = 0;
                
                while (posicion < longitudRecorrido) {
                    ciclos++;
                    posicion += avance; // Avanza
                    if (posicion >= longitudRecorrido) {
                        break; // Si ya ha llegado, salir del bucle
                    }
                    posicion -= retroceso; // Retrocede
                }
                
                System.out.println(ciclos);
            }
        }
        
        scanner.close();
    }
}
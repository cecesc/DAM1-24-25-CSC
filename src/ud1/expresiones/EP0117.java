package ud1.expresiones;

import java.util.Scanner;

public class EP0117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de hormigas capturadas");
        double nHormigas = sc.nextDouble();
        System.out.println("Introduzca el número de arañas capturadas");
        double nArañas = sc.nextDouble();
        System.out.println("Introduzca el número de conchinchillas capturadas");
        double nConchinchillas = sc.nextDouble();
        sc.close();

        double total = (nHormigas * 6) + (nArañas*8) + (nConchinchillas*14);

        System.out.println("El total de patas que tienen todos los animales capturados es de " + total);

    
    
    
    
    }
}

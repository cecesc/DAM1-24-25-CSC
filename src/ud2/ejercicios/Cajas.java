package ud2.ejercicios;

import java.util.Scanner;

public class Cajas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario que ingrese las dimensiones de la caja del juguete
        System.out.print("Ingresa la longitud del juguete: ");
        int longitudJuguete = scanner.nextInt();
        
        System.out.print("Ingresa el ancho del juguete: ");
        int anchoJuguete = scanner.nextInt();
        
        System.out.print("Ingresa la altura del juguete: ");
        int alturaJuguete = scanner.nextInt();
        
        // Pedir al usuario que ingrese las dimensiones de la caja de cartón
        System.out.print("Ingresa la longitud de la caja de cartón: ");
        int longitudCarton = scanner.nextInt();
        
        System.out.print("Ingresa el ancho de la caja de cartón: ");
        int anchoCarton = scanner.nextInt();
        
        System.out.print("Ingresa la altura de la caja de cartón: ");
        int alturaCarton = scanner.nextInt();
        
        // Verificar si el juguete cabe en la caja de cartón
        if (Math.min(longitudJuguete, Math.min(anchoJuguete, alturaJuguete)) <= Math.min(longitudCarton, Math.min(anchoCarton, alturaCarton)) &&
            Math.max(longitudJuguete, Math.min(anchoJuguete, alturaJuguete)) <= Math.max(longitudCarton, Math.min(anchoCarton, alturaCarton)) &&
            Math.max(longitudJuguete, Math.max(anchoJuguete, alturaJuguete)) <= Math.max(longitudCarton, Math.max(anchoCarton, alturaCarton))) {
            System.out.println("SIRVE");
        } else {
            System.out.println("NO SIRVE");
        }
        
        // Cerrar el Scanner
        scanner.close();
    }

}

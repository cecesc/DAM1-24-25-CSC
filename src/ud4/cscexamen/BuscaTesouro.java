//Autora: Celia Sanmartin Chapela
package ud4.cscexamen;

import java.util.Scanner;
import java.util.Random;

public class BuscaTesouro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contadorIntentos;
        
        System.out.println("Ingrese el numero de filas:");
        int filas= sc.nextInt();
        System.out.println("Ingrese el numero de columnas:");
        int columnas= sc.nextInt();
        int[][] tablero = new int[filas][columnas];

        int intentos= ( filas * columnas )/100;


        Random tesoro = new Random();
        int fila  = filas * tesoro.nextInt();
        int columna = columnas * tesoro.nextInt();
        
        do {

            System.out.print("Introduce tu intento: ");
            int intento = sc.nextInt();
            if (tesoro != intento ) {
            contadorIntentos++;
        }
            
           
            int pista;
            
                

        } while (contadorIntentos >= intentos);
            System.out.println("Has perdido");
    }
       
} 
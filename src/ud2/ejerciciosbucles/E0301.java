/* Diseñar un programa que muestre, para cada número introducido por teclado, si
es par, si es positivo y su cuadrado. El proceso se repetirá hasta que el número
introducido sea 0. */
package ud2.ejerciciosbucles;

import java.util.Scanner;

public class E0301 {
    public static void main(String[] args) {
        int numero;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número ( 0 para finalizar): ");
        numero = sc.nextInt();

        while (numero !=0) {
            //Proceso
            if (numero % 2 == 0) 
                System.out.println("Es par");
                
            if (numero > 0) 
                System.out.println("Es positivo");
                
                    
            double resultado = Math.pow(numero,2);
            System.out.printf("El número %s es par y positivo. Su raíz cuadrada es %2.f ", numero, resultado);
        }
        sc.close();
    }
}

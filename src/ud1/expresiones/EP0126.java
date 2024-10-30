package ud1.expresiones;

import java.util.Scanner;

public class EP0126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero, raiz;
          
        System.out.print("Introduce un número real: ");
        numero = sc.nextDouble();
        sc.close();
        
        raiz = Math.sqrt(numero);
        
        System.out.println("Raíz cuadrada: " + raiz);
    }
}

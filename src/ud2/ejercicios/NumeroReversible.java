package ud2.ejercicios;

import java.util.Scanner;

public class NumeroReversible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int numero = scanner.nextInt();
            if (numero == 0) {
                break; // Terminar si se ingresa 0
            }
            
            if (esReversible(numero)) {
                System.out.println(numero + " es un número reversible.");
            } else {
                System.out.println(numero + " no es un número reversible.");
            }
        }
        
        scanner.close();
    }
    
    // Función para verificar si un número es reversible
    public static boolean esReversible(int numero) {
        String original = String.valueOf(numero);
        String invertido = new StringBuilder(original).reverse().toString();
        
        // Verificar que ambos números tengan la misma cantidad de dígitos
        if (original.length() != invertido.length()) {
            return false;
        }
        
        // Sumar el número original y su reverso
        int suma = numero + Integer.parseInt(invertido);
        
        // Verificar si todos los dígitos de la suma son impares
        return sonTodosImpares(suma);
    }
    
    // Función para verificar si todos los dígitos son impares
    public static boolean sonTodosImpares(int numero) {
        while (numero > 0) {
            int digito = numero % 10;
            if (digito % 2 == 0) {
                return false; // Si hay un dígito par, no es reversible
            }
            numero /= 10;
        }
        return true; // Todos los dígitos son impares
    }
}


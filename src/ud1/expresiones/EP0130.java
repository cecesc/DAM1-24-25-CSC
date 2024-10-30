package ud1.expresiones;

import java.util.Scanner;

public class EP0130 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
    
        System.out.print("Introduzca un número entero: ");
        int n = sc.nextInt();
        System.out.print("Introduzca otro número entero para comprobar si es o no múltiplo: ");
        int m = sc.nextInt();
        sc.close();

        int resto = n % m;
        int suma = (resto == 0) ? 0 : (m - resto);


        String mensaje = (resto  != 0) 
        ? String.format("\nA %d hay que sumarle %d para que el resultado (%d+%d=%d) sea múltiplo de %d\n", n, suma, n, suma, n + suma, m) 
        : String.format("\nA %d no hay que sumarle nada (0) para sea múltiplo de %d\n", n, m);
        System.out.println(mensaje);
    }
}

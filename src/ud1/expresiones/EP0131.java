package ud1.expresiones;

import java.util.Scanner;

public class EP0131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MACM = 100;

        System.out.print("Introduzca la longitud (en metros) del lanzamiento: ");
        float metros = sc.nextFloat();
        sc.close();

        // Pasar de metros a centímetros
        float centimetros = metros*MACM;

        // Si no ponemos esto, el valor se redondea
        int truncado = (int) centimetros;

        System.out.printf("La longitud del lanzamiento (%f m) es %d cm", metros, truncado);
    
    }
}

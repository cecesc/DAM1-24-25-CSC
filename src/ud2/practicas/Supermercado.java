package ud2.practicas;

import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        double precio, efectivo, resto;
        int unidad,pagar;

        Scanner sc = new Scanner(System.in);
       
        System.out.print("Introduzca el precio: ");
        precio = sc.nextDouble();
        System.out.print("Introduzca la unidades que se llevará: ");
        unidad = sc.nextInt();
      
        System.out.print("Introduzca con que va a pagar (1-Pagar en efectivo  2-Pagar con Tarjeta): ");
        pagar = sc.nextInt();

        if (pagar == 1) {
        System.out.print("Introduzca el importe pagado: ");
        efectivo = sc.nextDouble();
       
        resto = efectivo % 5;
        System.out.printf("\nSe retirarán %d euros", efectivo - resto);

        
        int billetes50 = (int) (efectivo / 50);
        efectivo %= 50; // Actualiza efectivo para calcular cuánto dinero queda después de sacar los billetes de 50
        int billetes20 = (int)efectivo / 20;
        efectivo %= 20; // Actualiza efectivo para calcular cuánto dinero queda después de sacar los billetes de 20
        int billetes10 = (int) efectivo / 10;
        efectivo %= 10; // Actualiza efectivo para calcular cuánto dinero queda después de sacar los billetes de 10
        int billetes5 =  (int) (efectivo / 5);

        System.out.printf("\n%d billetes de 50 euros: ", billetes50);
        System.out.printf("\n%d billetes de 20 euros: ", billetes20);
        System.out.printf("\n%d billetes de 10 euros: ", billetes10);
        System.out.printf("\n%d billetes de 5 euros: ", billetes5);
        } else {
            
        }

        sc.close();
    }
}
        
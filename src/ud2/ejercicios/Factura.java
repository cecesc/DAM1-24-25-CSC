package ud2.ejercicios;

import java.util.Scanner;

public class Factura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precio, unidad;

        System.out.print("Introduzca el precio del producto: ");
        precio = sc.nextDouble();
        System.out.print("Introduzca el número de unidaades compradas: ");
        unidad = sc.nextDouble();
        sc.close();
        
        double totalSinIVA = precio * unidad;
        
        double iva = 0.21 * totalSinIVA;
        double totalConIVA = totalSinIVA + iva;
                
        if (totalConIVA > 100) {
            double descuento = 0.05 * totalConIVA;
            totalConIVA -= descuento;
        }
    
        System.out.printf("El precio final con IVA es: %.2f €\n", totalConIVA);
        
    }

}

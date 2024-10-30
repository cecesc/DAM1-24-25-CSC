package ud1.expresiones;

import java.util.Scanner;

public class EP0124 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        double cantidad, conversion;
        int unidadMedida;
        final double GALON = 3.78541; 

        System.out.println("Introduzca la cantidad: ");
        cantidad = sc.nextDouble();
        System.out.println("Indica la unidad de medida (1=Galón, 2=Litro)");
        unidadMedida = sc.nextInt();
        sc.close();

        conversion = unidadMedida == 1 ? cantidad * GALON : cantidad / GALON;
        String unidadMedidaDestino = unidadMedida == 1 ? "Litros":"Galones";

        System.out.printf("La cantidad que usted me ha dado son %.2f %s ",conversion,unidadMedidaDestino);
    }
}

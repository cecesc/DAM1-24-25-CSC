package expresiones;

import java.util.Scanner;

public class EP0123 {
    public static void main(String[] args) {
        final double GRAMOS_LIBRA = 453.592;
        final double KILOS_LIBRAS = 1000 / GRAMOS_LIBRA;
        final double LIBRAS_KILOS = GRAMOS_LIBRA / 1000;

        double masaOrigen, masaDestino;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la masa de origen: ");
        masaOrigen = sc.nextDouble();
        sc.nextLine();

        /*byte unidadMedida;
        System.out.print("Introduce la unidad de medida de origen: (1 = Kilos, 2 = Libras): ");
        unidadMedida = sc.nextByte();*/

        char unidadMedida;
        System.out.print("Introduce la unidad de medida de origen: (K = Kilos, L = Libras): ");
        unidadMedida = sc.nextLine().charAt(0);
        sc.close();

        masaDestino = unidadMedida == 'K' || unidadMedida == 'k' ? masaOrigen * KILOS_LIBRAS : masaOrigen * LIBRAS_KILOS;

        String unidadMedidaDestino = unidadMedida == 'K' || unidadMedida == 'k' ? "libras" : "kilos";

        System.out.printf("La masa en la medida de destino es %.3f %s %n", masaDestino, unidadMedidaDestino);

    
    }

    
}

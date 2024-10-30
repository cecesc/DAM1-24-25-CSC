//Autor: Celia Sanmartín Chapela

package ud1.cscexamen;

import java.util.Scanner;

public class AreaPerimetroyVueltas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double largo, ancho, areaTotal, periTotal;
        final double AREA_CIR, AREA_RECT, PERIMETRO_CIR, PERIMETRO_RECT;

        System.out.println("Introduzca el largo del terreno: ");
        largo = sc.nextDouble();
        System.out.println("Introduzca el ancho del terreno: ");
        ancho = sc.nextInt();
        sc.close();

        AREA_CIR = Math.PI * Math.pow((ancho / 2), 2);
        AREA_RECT = (AREA_CIR - largo) * ancho;
        areaTotal = AREA_CIR + AREA_RECT;
        System.out.printf("El área total es de %.3f \n", areaTotal);

        PERIMETRO_CIR = 2 * Math.PI * (ancho / 2);
        PERIMETRO_RECT = (largo - PERIMETRO_CIR) * 2;
        periTotal = PERIMETRO_CIR + PERIMETRO_RECT;
        System.out.printf("El perímetro total es de %.3f \n", periTotal);

        double distancia = (periTotal >= 21.097) ? periTotal / 21.097 : 0;
        double distanciaTotal = Math.round(distancia * 100) / 100;

        System.out.printf("El número de vueltas que podrán dar son %.2f ", distanciaTotal);
    }
}

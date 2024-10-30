/*Piloto: Celia Sanmartín Chapela
 * Copiloto:Alejandro Feijoo Regueira*/
package ud1.ejercicios.parejas;

import java.util.Scanner;

public class RecetaseIngradientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("RECETA  DE COMPOTA DE MANZANA");
        System.out.println("https://www.recetasderechupete.com/compota-de-manzana-casera/12509/");

        int personasOriginal = 6;
        double manzanas = 1.5;
        double agua = 330;
        double azucar = 120;
        byte zumo_limon = 1;
        byte rama_canela = 1;

        System.out.println("Receta para " + personasOriginal + " personas");
        System.out.println("Para esta receta necesitara los siguientes ingredientes:");
        System.out.println(manzanas + " kilos de las manzanas que más os gusten");
        System.out.println(agua + " ml de agua");
        System.out.println(azucar + " gr. de ázucar (blanquilla o morena)");
        System.out.println(zumo_limon + " cucharaditas de zumo de limón");
        System.out.println("La piel (sin el blanco ) de una naranja");
        System.out.println(rama_canela + " ramita de canela (o media cucharadita tipo postre de canela molida)");

        System.out.println("¿Para cuántas personas tiene pensado hacer esta receta? ");
        int personas = sc.nextInt();

        double manzanasMod = 1.5 * personas / 6;
        double aguaMod = 330 * personas / 6;
        double azucarMod = 120 * personas / 6;

        System.out.println("Receta para " + personas + " personas");
        System.out.println("Para esta receta necesitara los siguientes ingredientes:");
        System.out.println(manzanasMod + " kilos de las manzanas que más os gusten");
        System.out.println(aguaMod + " ml de agua");
        System.out.println(azucarMod + " gr. de ázucar (blanquilla o morena)");
        System.out.println(zumo_limon + " cucharaditas de zumo de limón");
        System.out.println("La piel (sin el blanco ) de una naranja");
        System.out.println(rama_canela + " ramita de canela (o media cucharadita tipo postre de canela molida)");

        System.out.println("Recomendación:  Reducir al máximo la cantidad de azúcar para que la receta sea más saludable ");
        sc.close();

    }

}

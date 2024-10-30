//Autor: Celia Sanmartín Chapela
package ud1.cscexamen;

import java.util.Scanner;

public class CompraConjunta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precio, dineroper1, dineroper2, dineroper3;

        System.out.print("Introduzca el precio del artículo: ");
        precio = sc.nextDouble();
        System.out.print("Introduzca el dinero que aporta la primera persona: ");
        dineroper1 = sc.nextDouble();
        System.out.print("Introduzca el dinero que aporta la segunda persona: ");
        dineroper2 = sc.nextDouble();
        System.out.print("Introduzca el dinero que aporta la tercera persona: ");
        dineroper3 = sc.nextDouble();
        sc.close();

        double sumaTotal = dineroper1 + dineroper2 + dineroper3;

        double resultado = (sumaTotal >= precio) ? sumaTotal : precio - sumaTotal;

        System.out.println("Con el dinero aportado teneis: " + sumaTotal);
        System.out.println("Para comprar el artículo necesitais " + resultado);

    }
}

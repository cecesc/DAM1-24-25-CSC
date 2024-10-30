package ud1.expresiones;

import java.util.Scanner;

public class EP0120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double descuento;
        System.out.println("¿Cuántas entradas infantiles va a comprar?");
        int entrInf = sc.nextInt();
        System.out.println("¿Cuántas entradas adultos va a comprar?");
        int entrAdul = sc.nextInt();
        sc.close();

        double precioInf = entrInf * 15;
        double precioAdult = entrAdul * 20;
        double importeTotal = precioAdult + precioInf;
    
        descuento = (importeTotal >= 100) ? importeTotal * 0.5 :importeTotal;
        System.out.println("El importe total a cobrar es: " + importeTotal + " euros");
    
    }

}

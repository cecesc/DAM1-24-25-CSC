package ud1.ejercicios.parejas;

import java.util.Scanner;

public class UnidadesDeMedida {
    public static void main(String[] args) {
        double hectareas, m2;
        double campoFutbol=105*15;
        double canchaBaloncesto=28*15;
        double pistaTenis=27.77*10.97;
        double parqueRetiro=125*10000;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introducir el numero de hectareas");
        hectareas = sc.nextDouble();
        m2 = hectareas * 10000;
        sc.close();

       double numcampoFutbol = m2 / campoFutbol;
       double numcanchaBaloncesto = m2 / canchaBaloncesto;
       double numpistaTenis = m2 / pistaTenis;
       double numparqueRetiro = m2 / parqueRetiro;

       System.out.printf("%.2f Hectareas es igual a:",hectareas);
       System.out.printf("%.2f campos de futbol \n", numcampoFutbol);
       System.out.printf(" %.2f canchas de baloncesto \n", numcanchaBaloncesto);
       System.out.printf(" %.2f pistas de tenis \n", numpistaTenis);
       System.out.printf(" %.2f parque de retiro \n", numparqueRetiro);

    



        



    }
    
}

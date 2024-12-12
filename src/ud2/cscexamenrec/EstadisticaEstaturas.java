package ud2.cscexamenrec;

import java.util.Scanner;

public class EstadisticaEstaturas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0, estatura, alturaMax=0, alturaMin=0, sumaEstatura = 0;
        double media = 0;

        do {
            System.out.print("Introduzca la estura del alumno en cm (negativa para terminar): ");
            estatura = sc.nextInt();

            if (estatura >= 0) {
                sumaEstatura += estatura;
                contador++;
            }
        } while (estatura >= 0);

        if (contador > 0) {
            media = (double) sumaEstatura / contador;

            System.out.println("El numero de alumnos es: " + contador);
            System.out.printf( "La media de estatura es %.2f %n", media);
            System.out.println("La altura más baja es: " + alturaMin );
            System.out.println("La altura más alta es: " + alturaMax);
        }

        sc.close();

    }
}
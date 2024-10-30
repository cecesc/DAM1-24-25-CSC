package ud1.ejercicios.parejas;

    /**
    * En este ejercicio el piloto fue Alejandro Feijoo Regueira
    * y la copiloto fue Celia Sanmartín Chapela
    */

    import java.util.Scanner;
public class horasyasistencias {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            final double HORASPROGRAMACION = 240;
            double numsesiones, numFaltas, asistenciasAper, asistenciasEcon;
          
            numsesiones = HORASPROGRAMACION / 60 * 50;
            asistenciasAper = numsesiones * 0.06;
            asistenciasEcon = numsesiones * 0.10;
            System.out.println("Hola, el módulo de programación cuenta con 240 horas de clase, que es lo mismo que "
             + numsesiones + " clases,");
            System.out.println("El número máximo de faltas para que se envíe un apercimiento es " + asistenciasAper);
            System.out.println("El número de faltas necesario para que se pierda la evaluación continua es " + asistenciasEcon);
            
            System.out.println("Para saber su situación escriba a continuación el número de horas faltadas:");
            numFaltas = sc.nextDouble();
            sc.close();
            System.out.println("Su situación es la siguiente:");
            System.out.printf( numFaltas >= asistenciasAper ? "Recibirá un apercimiento" : "");
            System.out.printf( numFaltas >= asistenciasEcon ? " y perderá la evaluación continua" : "");
            System.out.printf( numFaltas <= asistenciasAper ? "Está todo bien" : "");


            
        }



}

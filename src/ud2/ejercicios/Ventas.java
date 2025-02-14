/*Debido a la crisis, el bar de Javier ha notado un descenso de las consumiciones. Además, según dicen en los telediarios, la ley antitabaco le está perjudicando aún más. Como no termina de creerse todo lo que dicen en la televisión, ha decidido hacer un estudio de mercado semanal de su establecimiento. Para ello, ha estado apuntando la caja diaria que se ha realizado en las últimas semanas. Le gustaría saber qué día de la semana se producen el mayor y el menor número de ventas, y si las ventas del domingo superan a la media semanal. De esta manera podrá establecer estrategias de marketing que le permitan recuperar algo de las ganancias perdidas.

Javier abre su bar todos los días menos los Lunes, que utiliza para descansar.

Realiza un programa que ayude a Javier en su cometido. Dada una lista de valores correspondiente a una semana, nuestro programa deberá decirle a Javier el día de la semana que más y menos ha vendido, y si las ventas del domingo superan la media.

Entrada
El programa recibirá una lista de semanas a evaluar. Cada semana constará de un valor para cada día. El número de semanas es indeterminado. El programa terminará de ejecutarse cuando para el primer día de la semana se indique una venta de -1.

Salida
Para cada caso de prueba, el programa escribirá una línea conteniendo dos días de la semana (MARTES, MIERCOLES, JUEVES, VIERNES, SABADO o DOMINGO). El primero indicará el día de más ventas y el segundo el de menos. Después se indicará un SI si el domingo se realizaron más ventas que la media semanal, y NO en caso contrario. Las tres palabras se separarán entre ellas por un espacio.

Si hay empate en alguno de los valores de ventas mínimo y máximo, se especificará EMPATE. */
package ud2.ejercicios;

import java.util.Locale;
import java.util.Scanner;

public class Ventas {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        sc.useLocale(Locale.US);
        double max = 0, min = 0, media = 0;
        int diaMax = 0, diaMin = 0;
        double recaudacion = 0;

        for (int i = 0; i < 6; i++) {
            recaudacion = sc.nextDouble();
            // máximo y mínimo
            if (i == 0) {
                min = recaudacion;
                max = recaudacion;
                diaMin = 0;
                diaMax = 0;
            } else {
                if (recaudacion < min) {
                    min = recaudacion;
                    diaMin = i;
                } else if (recaudacion > max) {
                    max = recaudacion;
                    diaMax = i;
                }
            }
            // media
            media += recaudacion;
        }

        media /= 6;

        System.out.println(diaSemana(diaMax) + " " + diaSemana(diaMin) + " " + (recaudacion > media ? "SI" : "NO"));
        sc.close();
            }
        
        private static String diaSemana(int dia) {
            return switch (dia) {
                case 0: yield "MARTES";
                case 1: yield "MIÉRCOLES";
                case 2: yield "JUEVES";
                case 3: yield "VIERNES";
                case 4: yield "SÁBADO";
                case 5: yield "DOMINGO"; 
                default: yield "ERROR";               
            };
        }
}

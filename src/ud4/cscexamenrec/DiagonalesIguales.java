//Autor: Celia Sanmartín Chapela
package ud4.cscexamenrec;

public class DiagonalesIguales {
    static boolean diagonalesIguales(int[][] t){
        boolean dgIgual = false;

        if (t != null && t.length != 0){
            int sumDgPrin = 0;
            int sumDgSecund = 0;

            for (int i = 0; i < t.length; i++){
                sumDgPrin += t[i][i];
                sumDgSecund += t[i][t.length - 1 - i];
            }

            dgIgual = sumDgPrin == sumDgSecund;
        }

        return dgIgual;
    }

}

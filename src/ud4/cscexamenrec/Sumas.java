//Autor: Celia Sanmartín Chapela
package ud4.cscexamenrec;

public class Sumas {

    static int[] sumas(int t[]) {
        int[] num=null;
        int suma = 0;
        int sumaPar = 0;
        int sumaImpar = 0;

        if (t != null) {
            for (int i = 0; i < t.length; i++) {
                suma += t[i];
                if (t[i] % 2 == 0){
                    sumaPar += t[i];
                }else{
                    sumaImpar += t[i];
                }
            }
            num = new int[3];
            num[0] = suma;
            num[1] = sumaPar;
            num[2] = sumaImpar;
        }
        return num;
    }
}

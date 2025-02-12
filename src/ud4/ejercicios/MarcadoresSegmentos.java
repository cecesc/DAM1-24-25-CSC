package ud4.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class MarcadoresSegmentos {

    static boolean [][] matriz = new boolean[3][7];

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce los números del letrero: ");
        int n = sc.nextInt();
        int suma =0;
        String prueba = "123";
        Integer m0 = Integer.parseInt(prueba.charAt(0) + "");
        Integer m1 = Integer.parseInt(prueba.charAt(1) + "");
        Integer m2 = Integer.parseInt(prueba.charAt(2) + "");

        suma += cambiosnum(2,m0);
        suma += cambiosnum(1,m0);
        suma += cambiosnum(2,m1);
        suma += cambiosnum(0,m0);
        suma += cambiosnum(1,m1);
        suma += cambiosnum(2,m2);
        suma += cambiosnum(0,m1);
        suma += cambiosnum(1,m2);
        suma += cambiosnum(0,m2);
        suma += cambiosnum(0,-1);
        System.out.println(suma);



    }

    private static int cambiosnum(int posicion, int numIntroducir) {

        boolean n1 []={false, true,true,false,false, false,false};
        boolean n2 []={true, true, false, true, true, false, true};
        boolean n3 []={true, true,true, true, false ,false, true};
        boolean n4 []={false, true,true,false,false,true,true};
        boolean n5 []={true,false,true,true,false,true,true};
        boolean n6 []={true,false, true, true, true,true,true};
        boolean n7 []={true, true,true,false, false, false, false};
        boolean n8 []={true, true, true,true, true, true, true};
        boolean n9 []={true, true, true, false, false, true, true};
        boolean aux []= {false, false, false, false, false, false, false};
        boolean n0 []= {true, true,true, true, true, true, false};

        int contador = 0;
        char n = (char)numIntroducir;
        int m = (int) n;

        switch (m) {

            case 0:
                for( int i = 0; i < n0.length; i++)
                    if (n0[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n0, 0, matriz[posicion], 0, n0.length);
                    }

                break;

            case 1:
                for( int i = 0; i < n1.length; i++)
                    if (n1[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n1, 0, matriz[posicion], 0, n1.length);
                    }
                break;

            case 2:
                for( int i = 0; i < n2.length; i++)
                    if (n2[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n2, 0, matriz[posicion], 0, n2.length);
                    }
                break;

            case 3:
                for( int i = 0; i < n3.length; i++)
                    if (n3[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n3, 0, matriz[posicion], 0, n3.length);
                    }
                break;

            case 4:
                for( int i = 0; i < n4.length; i++)
                    if (n4[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n4, 0, matriz[posicion], 0, n4.length);
                    }
                break;

            case 5:
                for( int i = 0; i < n5.length; i++)
                    if (n5[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n5, 0, matriz[posicion], 0, n5.length);
                    }
                break;

            case 6:
                for( int i = 0; i < n6.length; i++)
                    if (n6[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n6, 0, matriz[posicion], 0, n6.length);
                    }
                break;

            case 7:
                for( int i = 0; i < n7.length; i++)
                    if (n7[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n7, 0, matriz[posicion], 0, n7.length);
                    }
                break;

            case 8:
                for( int i = 0; i < n8.length; i++)
                    if (n8[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n8, 0, matriz[posicion], 0, n8.length);
                    }
                break;

            case 9:
                for( int i = 0; i < n9.length; i++)
                    if (n9[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(n9, 0, matriz[posicion], 0, n9.length);
                    }
                break;

            case -1:
                for( int i = 0; i < aux.length; i++)
                    if (aux[i] != matriz[posicion][i]) {

                        contador++;
                        System.arraycopy(aux, 0, matriz[posicion], 0, aux.length);
                    }
                break;
        }

        return contador;
    }
}

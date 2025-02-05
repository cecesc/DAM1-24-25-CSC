//autor: Celia Sanmartin
package ud4.apuntes.apuntesarrays;

import java.util.*;

public class ConjugarVerbos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] verbo ;
        System.out.print("Introduzca un verbo en infinitivo: " );
        String infinitivo = sc.nextLine();
       

    }

     public static String[] conjugarPresente(String verbo){
        do {
             if(!infinitivo.matches("[a-zA-Z]+,[ar | er | ir])"))
        System.out.println("La expresion no encaja con el patrón");
        } while (!infinitivo.matches("[a-zA-Z]+,[ar | er | ir])"));
       
        
        return null; 
    }

}

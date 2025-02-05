//autor: Celia Sanmartin
package ud4.apuntes.apuntesarrays;

public class MontañaRusa {
    public static void main(String[] args) {
        int [] alturas = {1,2,1,50};
        System.out.println(alturas.length + " alturas diferentes");

        System.out.println("La altura mas alta es " +contarPicos(alturas) + " metros");
            }
        
            static int contarPicos(int[] alturas) {
               int MaxAltitud = -1;
               for (int i = alturas.length -1; i >= 0 ; i--) {
                if (alturas[i] > MaxAltitud) {
                    MaxAltitud = alturas[i];
                }
               }
               return MaxAltitud;
            }
    
}
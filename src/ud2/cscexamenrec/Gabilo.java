package ud2.cscexamenrec;

import java.util.Scanner;

public class Gabilo {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alt = 0, altcamion=0, numcarriles=0;
        
        do {
            System.out.print("Introduce el número de puentes o túneles: ");
            int numtuneles = sc.nextInt(); 
            if (numtuneles == 100 || numtuneles<=0) break;
            
            do {
               System.out.print("Introduce el número de carriles: ");
                numcarriles = sc.nextInt(); 
                if (numcarriles == 5 || numcarriles<=0) break;
               
            }while(numcarriles <=5); 
            
                System.out.println("Introduce la altura em cm :");
                alt = sc.nextInt(); 
                if (alt > 200 && alt < 800) break;

        } while (alt > altcamion);
            System.out.println("El camion puede pasar");
        
sc.close();
    }
}

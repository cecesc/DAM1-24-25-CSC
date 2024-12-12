package ud2.ejemplos;

import java.util.Scanner;

public class Ejemplo2While {
    public static void main(String[] args) {
        int N; //variable que contiene el número de asteriscos a mostrar
        int dor = 0; //variable para r los asteriscos que se han mostrado                         
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce número de asteriscos a mostrar: ");
        N = sc.nextInt(); //leemos el número total de asteriscos a mostrar
        
        while (dor < N){ //inicio del bucle while                                                      
               System.out.print("*");
               dor++;
        }  //fin del bucle while
        sc.close();

        System.out.println("Fin programa");

    }
}

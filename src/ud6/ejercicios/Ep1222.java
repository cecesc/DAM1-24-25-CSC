package ud6.ejercicios;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Ep1222 {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> insercion = new LinkedHashSet<>();
        TreeSet<String> alfabetico = new TreeSet<>();

        
            System.out.print("Introduce un nombre (fin para terminar): ");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("fin"));
            insercion.add(nombre);
            alfabetico.add(nombre);
        

        System.out.println("Orden de inserción: " + insercion);
        System.out.println("Orden alfabético: " + alfabetico);
        sc.close();
    }
}



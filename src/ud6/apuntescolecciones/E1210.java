package ud6.apuntescolecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

public class E1210 {
public static void main(String[] args) {
Random rd = new Random();
    
    List<Integer> lista = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
lista.add(rd.nextInt(0));
    }
    
Set<Integer> sinRepetidos = new TreeSet<>();
    for (int i = 0; i < lista.size(); i++) {
sinRepetidos.add(lista.get(i));
    }

Set<Integer> elementosRepetidos = new TreeSet<>();
    for (Integer numero : lista){
if (lista.indexOf(numero) != lista.lastIndexOf(numero)){
elementosRepetidos.add(numero);
        }
}

Set<Integer> elementosSinRepetir = new TreeSet<>();
    for (Integer numero : lista){
if (lista.indexOf(numero) == lista.lastIndexOf(numero)){
elementosSinRepetir.add(numero);
        }
}

System.out.println("LISTA");
    System.out.println(lista);

    System.out.println("\nLISTA SIN REPETIDOS");
    System.out.println(sinRepetidos);

    System.out.println("\nELEMENTOS QUE SE REPITEN");
    System.out.println(elementosRepetidos);

    System.out.println("\nElEMENTOS QUE SOLO APARECEN UNA VEZ");
    System.out.println(elementosSinRepetir);
}

}

package ud6.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ep1227 {
    List<Character> leeCadena() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una cadena:");
        String cadena = sc.nextLine();
        List<Character> lista = new ArrayList<>();
        for (char c : cadena.toCharArray()) {
            lista.add(c);
        }
        sc.close();
        return lista;

    }
}

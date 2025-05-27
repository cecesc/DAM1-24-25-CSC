package ud7.animales;

import java.util.ArrayList;
import java.util.List;

public class testLeopardo {
    
    public static void main(String[] args) {
        List<Leopardo> felinos = new ArrayList<>();

        Leopardo leopardo1 = new Leopardo("Leopardo", 5, "Amarillo con manchas", true, "Selva");
        Leopardo leopardo2 = new Leopardo("Leopardo", 3, "Amarillo sin manchas", false, "Sabana");
        Leopardo leopardo3 = new Leopardo("Leopardo", 7, "Amarillo con manchas", true, "Montaña");

        felinos.add(leopardo1);
        felinos.add(leopardo2);
        felinos.add(leopardo3);

        // Guardar los objetos en un fichero
        String fichero = "gatos.txt";
        for (Leopardo leopardo : felinos) {
            leopardo.guardar(fichero);
        }

        // Leer los objetos desde el fichero
        List<Leopardo> felinosLeidos = new ArrayList<>();
        for (int i = 0; i < felinos.size(); i++) {
            Leopardo leopardo = Leopardo.leer(fichero);
            if (leopardo != null) {
                felinosLeidos.add(leopardo);
            }
        }

        // Mostrar los objetos leídos
        for (Leopardo leopardo : felinosLeidos) {
            System.out.println(leopardo);
        }
    }
}
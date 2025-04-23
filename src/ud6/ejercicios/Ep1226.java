package ud6.ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ep1226 {
 public static List<List<String>> repartoAlumnos(List<String> lista, int numGrupos) {
        Collections.shuffle(lista);
        List<List<String>> grupos = new ArrayList<>();
        for (int i = 0; i < numGrupos; i++) {
            grupos.add(new ArrayList<>());
        }
        for (int i = 0; i < lista.size(); i++) {
            grupos.get(i % numGrupos).add(lista.get(i));
        }
        return grupos;
    }
}

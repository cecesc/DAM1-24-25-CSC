package ud6.practicas.festivalmeigas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Feitizo {

    // Atributos
    private String nomeFeitizo;
    List<String> ingredientes;
    private Integer dificultade;

    // Constructores
    public Feitizo(String nomeFeitizo, String[] ingredientes, Integer dificultade) {
        this.nomeFeitizo = nomeFeitizo;
        this.ingredientes = List.of(ingredientes);
        this.dificultade = dificultade;
    }

    @Override
    public String toString() {
        return "Feitizo [nomeFeitizo=" + nomeFeitizo + "]";
    }

    // Otros métodos
    public static void main(String[] args) {
        Feitizo[] feitizos = crearFeitizosExemplo();
        System.out.println(ingredientesUnicos(List.of(feitizos)));

        String[] ingredientes = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira",
                "auga do mar", "salicornia", "berberechos místicos", "po de estrela fugaz", "cinza de bidueiro" };

        System.out.println(feitizosPosibles(Set.of(ingredientes), List.of(crearFeitizosExemplo())));

    }

    public static Feitizo[] crearFeitizosExemplo() {
        String[] ingredientes1 = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira" };
        String[] ingredientes2 = { "auga do mar", "salicornia", "berberechos místicos" };
        String[] ingredientes3 = { "raíz de toxo", "auga bendita", "po de estrela fugaz" };
        String[] ingredientes4 = { "auga de río encantada", "raíz de toxo", "pel de serpe" };
        String[] ingredientes5 = { "auga do mar", "po de estrela fugaz", "cinza de bidueiro" };
        String[] ingredientes6 = { "auga bendita", "pétalos de rosa silvestre", "brétema das fragas" };

        Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
        Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
        Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
        Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
        Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
        Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

        return new Feitizo[] { f1, f2, f3, f4, f5, f6 };
    }

    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();
        for (Feitizo feitizo : feitizos) {
            ingredientesUnicos.addAll(feitizo.ingredientes);
        }
        return ingredientesUnicos;
    }

    public static List<Feitizo> feitizosPosibles(Set<String> ingredientes, Collection<Feitizo> feitizos) {
        List<Feitizo> feitizosPosibles = new ArrayList<>();
        for (Feitizo feitizo : feitizos) {
            if (ingredientes.containsAll(feitizo.ingredientes))
                feitizosPosibles.add(feitizo);
        }
        return feitizosPosibles;
    }

    public static Map<String, Integer> ingredientesVecesUsados(Collection<Feitizo> feitizos) {
        Map<String, Integer> contador = new HashMap<>();
        for (Feitizo f : feitizos) {
            for (String ing : f.ingredientes) {
                contador.put(ing, contador.getOrDefault(ing, 0) + 1);
            }
        }
        return contador;
    }

    public boolean addIngrediente(String ingrediente) {
        return true;
    }

    public boolean removeIngrediente(String ingrediente) {
        return true;
    }

    public boolean cambiarIngrediente(String ingredienteViejo, String ingredienteNuevo) {
        return true;
    }

    public static List<Feitizo> feitizosUsanIngrediente(String ingrediente) {
        return null;
    }

public boolean addIngrediente(String ingrediente) {
    if (ingredientes.contains(ingrediente)) return false;
    ingredientes = new ArrayList<>(ingredientes); // Hacemos mutable
    ingredientes.add(ingrediente);
    return true;
}

public boolean removeIngrediente(String ingrediente) {
    if (!ingredientes.contains(ingrediente)) return false;
    ingredientes = new ArrayList<>(ingredientes); // Hacemos mutable
    ingredientes.remove(ingrediente);
    return true;
}

public boolean cambiarIngrediente(String ingredienteViejo, String ingredienteNovo) {
    if (!ingredientes.contains(ingredienteViejo) || ingredientes.contains(ingredienteNovo)) return false;
    ingredientes = new ArrayList<>(ingredientes); // Hacemos mutable
    int index = ingredientes.indexOf(ingredienteViejo);
    ingredientes.set(index, ingredienteNovo);
    return true;
}
public static List<Feitizo> feitizosUsanIngrediente(String ingrediente, Collection<Feitizo> feitizos) {
    List<Feitizo> lista = new ArrayList<>();
    for (Feitizo f : feitizos) {
        if (f.ingredientes.contains(ingrediente)) {
            lista.add(f);
        }
    }
    return lista;
}

}

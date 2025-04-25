package ud6.practicas.festivalmeigas;


package festivalmeigas;

import java.util.HashSet;
import java.util.Set;

public class Meiga implements Comparable<Meiga> {
    private String nome;
    private String alcumeMaxico;
    private Set<Feitizo> feitizosFavoritos;

    public Meiga(String nome, String alcumeMaxico) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
        this.feitizosFavoritos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public String getAlcumeMaxico() {
        return alcumeMaxico;
    }

    public Set<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public boolean engadirFeitizoFavorito(Feitizo f) {
        return feitizosFavoritos.add(f);
    }

    public boolean eliminarFeitizoFavorito(Feitizo f) {
        return feitizosFavoritos.remove(f);
    }

    @Override
    public String toString() {
        return "Meiga [nome=" + nome + ", alcume=" + alcumeMaxico + "]";
    }

    @Override
    public int compareTo(Meiga outra) {
        return this.nome.compareTo(outra.nome);
    }
}

public class FestivalUtils {

    // Meigas que comparten un ingrediente nun feitizo favorito
    public static Map<String, Set<Meiga>> meigasPorIngrediente(Collection<Meiga> meigas) {
        Map<String, Set<Meiga>> mapa = new HashMap<>();
        for (Meiga meiga : meigas) {
            for (Feitizo f : meiga.getFeitizosFavoritos()) {
                for (String ingrediente : f.getIngredientes()) {
                    mapa.putIfAbsent(ingrediente, new HashSet<>());
                    mapa.get(ingrediente).add(meiga);
                }
            }
        }
        return mapa;
    }

    // Recomendar un feitizo novo que use un ingrediente dado
    public static Map<Meiga, List<Feitizo>> recomendarFeitizosPorIngrediente(Collection<Meiga> meigas, Collection<Feitizo> feitizos, String ingrediente) {
        Map<Meiga, List<Feitizo>> recomendacion = new HashMap<>();
        for (Meiga meiga : meigas) {
            List<Feitizo> candidatos = new ArrayList<>();
            for (Feitizo f : feitizos) {
                if (f.getIngredientes().contains(ingrediente) && !meiga.getFeitizosFavoritos().contains(f)) {
                    candidatos.add(f);
                }
            }
            if (!candidatos.isEmpty()) {
                recomendacion.put(meiga, candidatos);
            }
        }
        return recomendacion;
    }

    // Feitizos que comparten ingredientes
    public static Map<String, List<Feitizo>> feitizosPorIngrediente(Collection<Feitizo> feitizos) {
        Map<String, List<Feitizo>> mapa = new HashMap<>();
        for (Feitizo f : feitizos) {
            for (String ingrediente : f.getIngredientes()) {
                mapa.putIfAbsent(ingrediente, new ArrayList<>());
                mapa.get(ingrediente).add(f);
            }
        }
        return mapa;
    }

    // Recomendar feitizos segundo ingredientes favoritos
    public static List<Feitizo> recomendarPorPreferencias(Meiga meiga, Collection<Feitizo> todosFeitizos) {
        Set<String> ingredientesFavoritos = new HashSet<>();
        for (Feitizo f : meiga.getFeitizosFavoritos()) {
            ingredientesFavoritos.addAll(f.getIngredientes());
        }

        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo f : todosFeitizos) {
            if (!meiga.getFeitizosFavoritos().contains(f)) {
                for (String ing : f.getIngredientes()) {
                    if (ingredientesFavoritos.contains(ing)) {
                        recomendados.add(f);
                        break;
                    }
                }
            }
        }
        return recomendados;
    }

    // Ingrediente máis usado
    public static String ingredienteMaisUsado(Collection<Feitizo> feitizos) {
        Map<String, Integer> conta = Feitizo.ingredientesVecesUsados(feitizos);
        String maxIng = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : conta.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxIng = entry.getKey();
            }
        }
        return maxIng;
    }
}

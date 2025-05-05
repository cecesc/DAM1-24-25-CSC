package ud6.practicas.festivalmeigas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Meiga implements Comparable<Meiga> {
    private String nomeMeiga;
    private String alcume;
    private Set<Feitizo> feitizosFavoritos;
    private Map<String, Integer> inventario;

    @Override
    public int compareTo(Meiga o) {
        return this.alcume.compareTo(o.alcume);
    }

    // NOVO: rexistro de feitizos lanzados
    private List<Feitizo> feitizosLanzados;

    public Meiga(String nomeMeiga, String alcume) {
        this.nomeMeiga = nomeMeiga;
        this.alcume = alcume;
        this.feitizosFavoritos = new HashSet<>();
        this.inventario = new HashMap<>();
        this.feitizosLanzados = new ArrayList<>();
    }

    public boolean engadirFeitizoFavorito(Feitizo f) {
        return feitizosFavoritos.add(f);
    }

    public void eliminarFeitizoFavorito(Feitizo f) {
        feitizosFavoritos.remove(f);
    }

    public void engadirIngrediente(String ingrediente, int unidades) {
        inventario.put(ingrediente, inventario.getOrDefault(ingrediente, 0) + unidades);
    }

    public void lanzarFeitizo(Feitizo f) {
        if (f.getIngredientes().stream().allMatch(i -> inventario.getOrDefault(i, 0) > 0)) {
            System.out.println(nomeMeiga + " lanza o feitizo: " + f.getNomeFeitizo());
            for (String ing : f.getIngredientes()) {
                inventario.put(ing, inventario.get(ing) - 1);
            }
            feitizosLanzados.add(f); // rexistro
        } else {
            System.out.println("Non hai ingredientes suficientes para lanzar " + f.getNomeFeitizo());
        }
    }

    public static Set<Feitizo> getFeitizosRnd(Collection<Feitizo> todos, int num) {
        List<Feitizo> lista = new ArrayList<>(todos);
        Collections.shuffle(lista);
        return new HashSet<>(lista.subList(0, Math.min(num, lista.size())));
    }

    public static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientes, int maxUnidades) {
        Map<String, Integer> mapa = new HashMap<>();
        Random rnd = new Random();
        for (String i : ingredientes) {
            mapa.put(i, 1 + rnd.nextInt(maxUnidades));
        }
        return mapa;
    }

    public Set<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public Map<String, Integer> getInventario() {
        return inventario;
    }

    public String getNomeMeiga() {
        return nomeMeiga;
    }

    public String getAlcume() {
        return alcume;
    }

    @Override
    public String toString() {
        return nomeMeiga + " (" + alcume + ")";
    }

    public int lanzarFeitizos() {
        int puntos = 0;
        List<Feitizo> ordenados = new ArrayList<>(feitizosFavoritos);
        ordenados.sort(Comparator.comparingInt(Feitizo::getDificultade).reversed());

        for (Feitizo f : ordenados) {
            boolean sePuedeLanzar = true;
            for (String ing : f.getIngredientes()) {
                if (!inventario.containsKey(ing) || inventario.get(ing) <= 0) {
                    sePuedeLanzar = false;
                    break;
                }
            }
            if (sePuedeLanzar) {
                for (String ing : f.getIngredientes()) {
                    int nuevoValor = inventario.get(ing) - 1;
                    if (nuevoValor == 0) {
                        inventario.remove(ing);
                    } else {
                        inventario.put(ing, nuevoValor);
                    }
                }
                puntos += f.getDificultade();
                System.out.println(nomeMeiga + " lanza o feitizo: " + f.getNomeFeitizo());
            } else {
                System.out.println(nomeMeiga + " NON pode lanzar " + f.getNomeFeitizo());
            }
        }

        return puntos;
    }

    // Extra: Meigas que comparten ingrediente en feitizos favoritos
    public static List<Meiga> meigasConIngredienteFavorito(Collection<Meiga> meigas, String ingrediente) {
        List<Meiga> lista = new ArrayList<>();
        for (Meiga m : meigas) {
            for (Feitizo f : m.feitizosFavoritos) {
                if (f.getIngredientes().contains(ingrediente)) {
                    lista.add(m);
                    break;
                }
            }
        }
        return lista;
    }

    // Recomendar feitizo novo con ingrediente
    public static Feitizo recomendarFeitizo(Collection<Feitizo> todos, Meiga m, String ingrediente) {
        for (Feitizo f : todos) {
            if (f.getIngredientes().contains(ingrediente) && !m.getFeitizosFavoritos().contains(f)) {
                return f;
            }
        }
        return null;
    }

    // Buscar feitizos que comparten ingredientes
    public static List<Feitizo> feitizosCompatibles(Feitizo base, Collection<Feitizo> todos) {
        List<Feitizo> lista = new ArrayList<>();
        for (Feitizo f : todos) {
            if (!f.equals(base)) {
                for (String ing : f.getIngredientes()) {
                    if (base.getIngredientes().contains(ing)) {
                        lista.add(f);
                        break;
                    }
                }
            }
        }
        return lista;
    }

    // Recomendar feitizos segundo ingredientes favoritos
    public static Set<Feitizo> recomendarFeitizosPorInventario(Meiga m, Collection<Feitizo> todos) {
        Set<Feitizo> recomendados = new HashSet<>();
        for (Feitizo f : todos) {
            if (!m.getFeitizosFavoritos().contains(f)) {
                for (String ing : f.getIngredientes()) {
                    if (m.getInventario().containsKey(ing)) {
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
        return Collections.max(Feitizo.ingredientesVecesUsados(feitizos).entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }

    // NOVO: Total de feitizos lanzados
    public int totalFeitizosLanzados() {
        return feitizosLanzados.size();
    }

    // NOVO: Dificultade media dos feitizos lanzados
    public double dificultadeMediaLanzados() {
        if (feitizosLanzados.isEmpty())
            return 0.0;
        int total = 0;
        for (Feitizo f : feitizosLanzados) {
            total += f.getDificultade();
        }
        return (double) total / feitizosLanzados.size();
    }

    // NOVO: Feitizo máis usado
    public Feitizo feitizoMaisUsado() {
        if (feitizosLanzados.isEmpty())
            return null;
        Map<Feitizo, Integer> conta = new HashMap<>();
        for (Feitizo f : feitizosLanzados) {
            conta.put(f, conta.getOrDefault(f, 0) + 1);
        }
        return Collections.max(conta.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public List<Feitizo> getFeitizosLanzados() {
        return feitizosLanzados;
    }
}

package ud6.practicas.festivalmeigas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Festival {
    private List<Meiga> meigas;
    private Set<Feitizo> feitizos;

    public Festival() {
        this.meigas = new ArrayList<>();
        this.feitizos = new HashSet<>();
    }

    public void engadirMeiga(Meiga m) {
        meigas.add(m);
    }

    public void engadirFeitizo(Feitizo f) {
        feitizos.add(f);
    }

    public Meiga buscarMeigaPorNome(String nome) {
        for (Meiga m : meigas) {
            if (m.getNomeMeiga().equalsIgnoreCase(nome)) {
                return m;
            }
        }
        return null;
    }

    public Feitizo buscarFeitizoPorNome(String nome) {
        for (Feitizo f : feitizos) {
            if (f.getNomeFeitizo().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public List<Feitizo> feitizosConIngrediente(String ingrediente) {
        List<Feitizo> resultado = new ArrayList<>();
        for (Feitizo f : feitizos) {
            if (f.getIngredientes().contains(ingrediente)) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public void cargarFeitizosFavoritosRandom(int cant) {
        for (Meiga m : meigas) {
            Set<Feitizo> rnds = Meiga.getFeitizosRnd(feitizos, cant); // Se obtiene un conjunto de feitizos aleatorios
            for (Feitizo f : rnds) {
                m.engadirFeitizoFavorito(f);
            }
        }
    }

    public void cargarInventariosRandom(int maxUnidades) {
        Set<String> ingredientes = new HashSet<>();
        for (Feitizo f : feitizos) {
            ingredientes.addAll(f.getIngredientes());
        }
        for (Meiga m : meigas) {
            Map<String, Integer> inventario = Meiga.getIngredientesRnd(ingredientes, maxUnidades);
            for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
                m.engadirIngrediente(entry.getKey(), entry.getValue());
            }
        }
    }

    // Meigas que comparten un ingrediente en un feitizo favorito
    public Map<String, Set<Meiga>> meigasPorIngrediente() {
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

    // Recomendar un feitizo nuevo que use un ingrediente dado
    public static Map<Meiga, List<Feitizo>> recomendarFeitizosPorIngrediente(Collection<Meiga> meigas,
            Collection<Feitizo> feitizos, String ingrediente) {
        Map<Meiga, List<Feitizo>> recomendados = new HashMap<>();
        for (Meiga meiga : meigas) {
            List<Feitizo> recomendadosMeiga = new ArrayList<>();
            for (Feitizo feitizo : feitizos) {
                if (feitizo.getIngredientes().contains(ingrediente)
                        && !meiga.getFeitizosFavoritos().contains(feitizo)) {
                    recomendadosMeiga.add(feitizo);
                }
            }
            recomendados.put(meiga, recomendadosMeiga);
        }
        return recomendados;
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

    public static List<Feitizo> recomendarPorPreferencias(Meiga meiga, Collection<Feitizo> todosFeitizos) {
        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo f : todosFeitizos) {
            for (String ing : f.getIngredientes()) {
                if (meiga.getInventario().containsKey(ing)) {
                    recomendados.add(f);
                    break;
                }
            }
        }
        return recomendados;
    }

    public Set<Meiga> getMeigas() {
        return new HashSet<>(meigas);
    }

    public Set<Feitizo> getFeitizos() {
        return new HashSet<>(feitizos);
    }

    // Ingrediente más usado
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

    public int contarIngredientesMeiga(Meiga meiga) {
        Set<String> ingredientesUnicos = new HashSet<>();
        for (Feitizo f : meiga.getFeitizosFavoritos()) {
            ingredientesUnicos.addAll(f.getIngredientes());
        }
        return ingredientesUnicos.size();
    }

    public List<Feitizo> recomendarFeitizosLanzables(Meiga meiga, Collection<Feitizo> todosFeitizos) {
        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo f : todosFeitizos) {
            if (meiga.getInventario().keySet().containsAll(f.getIngredientes())) {
                recomendados.add(f);
            }
        }
        return recomendados;
    }

    public Feitizo obterFeitizoMaisPopular() {
        Map<Feitizo, Integer> contador = new HashMap<>();
        for (Meiga meiga : meigas) {
            for (Feitizo f : meiga.getFeitizosFavoritos()) {
                contador.put(f, contador.getOrDefault(f, 0) + 1);
            }
        }
        return contador.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null); // Retorna el feitizo más popular o null si no hay favoritos
    }

    public void eliminarFeitizoDeFavoritos(Feitizo feitizo) {
        for (Meiga meiga : meigas) {
            meiga.eliminarFeitizoFavorito(feitizo); // Suponiendo que hay un método en Meiga
        }
    }

    public List<Meiga> clasificarMeigasPorIngredientesUnicos() {
        List<Meiga> clasificacion = new ArrayList<>(meigas);
        clasificacion.sort((m1, m2) -> {
            int m1Ingredientes = contarIngredientesMeiga(m1);
            int m2Ingredientes = contarIngredientesMeiga(m2);
            return Integer.compare(m2Ingredientes, m1Ingredientes); // Orden descendente
        });
        return clasificacion;
    }

    public boolean tieneTodosLosIngredientes(Meiga meiga, Feitizo feitizo) {
        return meiga.getInventario().keySet().containsAll(feitizo.getIngredientes());
    }

    public List<Meiga> meigasConIngredientesRaros() {
        Map<String, Integer> cuentaIngredientes = new HashMap<>();
        for (Meiga meiga : meigas) {
            for (String ingrediente : meiga.getInventario().keySet()) {
                cuentaIngredientes.put(ingrediente, cuentaIngredientes.getOrDefault(ingrediente, 0) + 1);
            }
        }

        List<Meiga> resultado = new ArrayList<>();
        for (Meiga meiga : meigas) {
            for (String ingrediente : meiga.getInventario().keySet()) {
                if (cuentaIngredientes.get(ingrediente) == 1) {
                    resultado.add(meiga);
                    break;
                }
            }
        }
        return resultado;
    }

}
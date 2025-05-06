package ud6.practicas.festivalmeigas;

import java.util.*;

public class Festival {
    private List<Meiga> meigas;
    private Set<Feitizo> feitizos;

    public Festival() {
        this.meigas = new ArrayList<>();
        this.feitizos = new HashSet<>();
    }

    public static void main(String[] args) {
        Festival festival = new Festival();
        List<Meiga> listaMeigas = crearMeigas(); // Debes definir este método
        Set<Feitizo> conjuntoFeitizos = crearFeitizos(); // Debes definir este método

        for (Meiga m : listaMeigas) {
            m.getFeitizosFavoritos().addAll(Meiga.getFeitizosRnd(conjuntoFeitizos, 3));
            m.getInventario().putAll(Meiga.getIngredientesRnd(Feitizo.todosIngredientes(conjuntoFeitizos), 3));
        }

    }

    public void engadirMeiga(Meiga m) {
        meigas.add(m);
    }

    public void engadirFeitizo(Feitizo f) {
        feitizos.add(f);
    }

    public Meiga buscarMeigaPorNome(String nome) {
        for (Meiga m : meigas) {
            if (m.getNomeMeiga().equalsIgnoreCase(nome)) return m;
        }
        return null;
    }

    public Feitizo buscarFeitizoPorNome(String nome) {
        for (Feitizo f : feitizos) {
            if (f.getNomeFeitizo().equalsIgnoreCase(nome)) return f;
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
            Set<Feitizo> rnds = Meiga.getFeitizosRnd(feitizos, cant);
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
                .orElse(null);
    }

    public void eliminarFeitizoDeFavoritos(Feitizo feitizo) {
        for (Meiga meiga : meigas) {
            meiga.eliminarFeitizoFavorito(feitizo);
        }
    }

    public List<Meiga> clasificarMeigasPorIngredientesUnicos() {
        List<Meiga> clasificacion = new ArrayList<>(meigas);
        clasificacion.sort((m1, m2) -> Integer.compare(
                contarIngredientesMeiga(m2), contarIngredientesMeiga(m1)));
        return clasificacion;
    }

    public boolean tenTodosOsIngredientes(Meiga meiga, Feitizo feitizo) {
        return meiga.getInventario().keySet().containsAll(feitizo.getIngredientes());
    }

    public List<Meiga> meigasConIngredientesRaros() {
        Map<String, Integer> conta = new HashMap<>();
        for (Meiga meiga : meigas) {
            for (String ingrediente : meiga.getInventario().keySet()) {
                conta.put(ingrediente, conta.getOrDefault(ingrediente, 0) + 1);
            }
        }

        List<Meiga> resultado = new ArrayList<>();
        for (Meiga meiga : meigas) {
            for (String ingrediente : meiga.getInventario().keySet()) {
                if (conta.get(ingrediente) == 1) {
                    resultado.add(meiga);
                    break;
                }
            }
        }
        return resultado;
    }

    // Métodos auxiliares ficticios, debes implementarlos según tu caso:
    private static List<Meiga> crearMeigas() {
        return new ArrayList<>(); // Implementar según sea necesario
    }

    private static Set<Feitizo> crearFeitizos() {
        return new HashSet<>(); // Implementar según sea necesario
    }
}

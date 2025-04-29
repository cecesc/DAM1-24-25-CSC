package ud6.practicas.diadotraballador;

import java.util.*;

public class DiaDoTraballador {
    private List<Persoa> persoas;
    private Set<Tarefa> tarefas;

    public DiaDoTraballador() {
        this.persoas = new ArrayList<>();
        this.tarefas = new HashSet<>();
    }

    public void engadirPersoa(Persoa p) {
        persoas.add(p);
    }

    public void engadirTarefa(Tarefa t) {
        tarefas.add(t);
    }

    public List<Tarefa> tarefasQuePodeFacer(Persoa p) {
        List<Tarefa> realizables = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (p.podeRealizar(t)) {
                realizables.add(t);
            }
        }
        return realizables;
    }

    public Map<String, Set<Persoa>> persoasPorFerramenta() {
        Map<String, Set<Persoa>> mapa = new HashMap<>();
        for (Persoa p : persoas) {
            for (String ferramenta : p.getFerramentas().keySet()) {
                mapa.putIfAbsent(ferramenta, new HashSet<>());
                mapa.get(ferramenta).add(p);
            }
        }
        return mapa;
    }

    public static String ferramentaMaisUsada(Collection<Tarefa> tarefas) {
        Map<String, Integer> conta = new HashMap<>();
        for (Tarefa t : tarefas) {
            for (String ferramenta : t.getFerramentas()) {
                conta.put(ferramenta, conta.getOrDefault(ferramenta, 0) + 1);
            }
        }
        String maxFerramenta = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : conta.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxFerramenta = entry.getKey();
            }
        }
        return maxFerramenta;
    }

    public static Map<Persoa, List<Tarefa>> recomendarPorFerramenta(Collection<Persoa> persoas, Collection<Tarefa> tarefas, String ferramenta) {
        Map<Persoa, List<Tarefa>> recomendadas = new HashMap<>();
        for (Persoa p : persoas) {
            List<Tarefa> lista = new ArrayList<>();
            for (Tarefa t : tarefas) {
                if (t.getFerramentas().contains(ferramenta) && !p.getTarefasFavoritas().contains(t)) {
                    lista.add(t);
                }
            }
            recomendadas.put(p, lista);
        }
        return recomendadas;
    }

    public static Map<String, List<Tarefa>> tarefasPorFerramenta(Collection<Tarefa> tarefas) {
        Map<String, List<Tarefa>> mapa = new HashMap<>();
        for (Tarefa t : tarefas) {
            for (String ferramenta : t.getFerramentas()) {
                mapa.putIfAbsent(ferramenta, new ArrayList<>());
                mapa.get(ferramenta).add(t);
            }
        }
        return mapa;
    }
}

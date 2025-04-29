package ud6.practicas.diadotraballador;

import java.util.*;

public class Persoa {
    private String nome;
    private Map<String, Integer> ferramentas; // ferramenta → unidades
    private Set<Tarefa> tarefasFavoritas;

    public Persoa(String nome) {
        this.nome = nome;
        this.ferramentas = new HashMap<>();
        this.tarefasFavoritas = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Integer> getFerramentas() {
        return ferramentas;
    }

    public Set<Tarefa> getTarefasFavoritas() {
        return tarefasFavoritas;
    }

    public void engadirFerramenta(String ferramenta, int unidades) {
        ferramentas.put(ferramenta, ferramentas.getOrDefault(ferramenta, 0) + unidades);
    }

    public void engadirTarefaFavorita(Tarefa t) {
        tarefasFavoritas.add(t);
    }

    public boolean podeRealizar(Tarefa t) {
        for (String f : t.getFerramentas()) {
            if (!ferramentas.containsKey(f) || ferramentas.get(f) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}

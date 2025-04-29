package ud6.practicas.diadotraballador;

import java.util.Set;

public class Tarefa {
    private String nome;
    private Set<String> ferramentas;

    public Tarefa(String nome, Set<String> ferramentas) {
        this.nome = nome;
        this.ferramentas = ferramentas;
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getFerramentas() {
        return ferramentas;
    }

    @Override
    public String toString() {
        return nome + " -> " + ferramentas;
    }
}

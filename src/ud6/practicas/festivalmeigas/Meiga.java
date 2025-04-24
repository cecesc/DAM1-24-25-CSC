package ud6.practicas.festivalmeigas;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Meiga {

    private String nome;
    private String alcumeMaxico;
    private Set<Feitizo> feitizosFavoritos = new TreeSet<>(Comparator.comparing(Feitizo::toString));

    public Meiga(String nome, String alcumeMaxico) {
        this.nome = nome;
        this.alcumeMaxico = alcumeMaxico;
    }

    public boolean engadirFavorito(Feitizo feitizo) {
        return feitizosFavoritos.add(feitizo);
    }

    public Set<Feitizo> getFeitizosFavoritos() {
        return feitizosFavoritos;
    }

    public String getNome() {
        return nome;
    }

    public String getAlcumeMaxico() {
        return alcumeMaxico;
    }

    @Override
    public String toString() {
        return nome + " («" + alcumeMaxico + "»)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meiga)) return false;
        Meiga meiga = (Meiga) o;
        return nome.equals(meiga.nome) && alcumeMaxico.equals(meiga.alcumeMaxico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, alcumeMaxico);
    }
}

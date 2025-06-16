//Autor: Celia Sanmartín Chapela

package ud6.cscexamenrec.musicollab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Musico implements Comparable<Musico> {
    private String nombre;
    private String alias; // único
    private List<String> instrumentos; // sin repetidos
    private Set<Cancion> repertorio;

    public Musico(String nombre, String alias, List<String> instrumentos, Set<Cancion> repertorio) {
        this.nombre = nombre;
        this.alias = alias;
        // Evitamos duplicados manteniendo una copia limpia
        this.instrumentos = new ArrayList<>(new HashSet<>(instrumentos));
        this.repertorio = repertorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }

    public Set<Cancion> getRepertorio() {
        return repertorio;
    }

    @Override
    public int compareTo(Musico otro) {
        return this.alias.compareToIgnoreCase(otro.alias);
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s): %s", alias, nombre, instrumentos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Musico)) return false;
        Musico m = (Musico) obj;
        return alias.equals(m.alias);
    }

    @Override
    public int hashCode() {
        return alias.hashCode();
    }}
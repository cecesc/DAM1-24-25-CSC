//Autor: Celia Sanmartín Chapela

package ud6.cscexamenrec.musicollab;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Musico implements Comparable<Musico> {
    protected String nombre;
    protected String alias;
    protected List<String> instrumentos;
    protected Collection<Musico> repertorio;

    public Musico(String nombre, String alias, List<String> instrumentos, Collection<Musico> repertorio) {
        this.nombre = nombre;
        this.alias = alias;
        this.instrumentos = instrumentos;
        this.repertorio = new HashSet<>();
    }

    @Override
    public String toString() {
        return alias + "(" + nombre + "): " + instrumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public int compareTo(Musico o) {
        return this.nombre.compareTo(o.nombre);
    }
}

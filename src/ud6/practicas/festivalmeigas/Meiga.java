package ud6.practicas.festivalmeigas;

import java.util.Arrays;
import java.util.Comparator;

public class Meiga implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Meiga s1 = (Meiga) o1;
        Meiga s2 = (Meiga) o2;
        int resultado = Arrays.compare(s1.ListaFeitizo, s2.ListaFeitizo);
        return (resultado != 0) ? resultado : s1.nome.compareToIgnoreCase(s2.nome);
    }

    protected String nome;
    protected String[] ListaFeitizo;

    public Meiga(String nome, String[] listaFeitizo) {
        this.nome = nome;
        ListaFeitizo = listaFeitizo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Meiga other = (Meiga) obj;
        if (!Arrays.equals(ListaFeitizo, other.ListaFeitizo))
            return false;
        return true;

    }

}

package ud5.interfacesejercicios.ep0913_futbolista;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator{
    @Override
    public int compare(Object a, Object b) {
        Futbolista n1=((Futbolista)a);
        Futbolista n2=((Futbolista)a);
        return a.nombre.compareTo(b.nombre);
    }
 
    }



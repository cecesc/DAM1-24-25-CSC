package ud5.interfacesejercicios.ep0913_futbolista;

import java.util.Comparator;

public class ComparadorPorEdad implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Futbolista s1 = (Futbolista) o1;
        Futbolista s2 = (Futbolista) o2;
        return s1.edad.compareTo(s2.edad);
    }
}

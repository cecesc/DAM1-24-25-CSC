package ud6.apuntescolecciones;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class E1212 {
    public static void main(String[] args) {
        Set<Cliente> conjuntoClientesA = new TreeSet<>();
        Cliente marta = new Cliente("111", "Marta", "12/02/2000");
        conjuntoClientesA.add(marta);
        conjuntoClientesA.add(new Cliente("115", "Jorge", "16/03/1999"));
        conjuntoClientesA.add(new Cliente("112", "Manolo", "01/10/2002"));
        conjuntoClientesA.add(new Cliente("118", "Miguel", "16/03/1999"));
        conjuntoClientesA.add(new Cliente("132", "Marcos", "01/10/2002"));

        Set<Cliente> conjuntoClientesB = new TreeSet<>();
        conjuntoClientesB.add(marta);
        conjuntoClientesB.add(new Cliente("115", "Jorge", "16/03/1999"));
        conjuntoClientesB.add(new Cliente("112", "Carlos", "01/10/2002"));
        conjuntoClientesB.add(new Cliente("113", "Sofía", "16/03/1999"));
        conjuntoClientesB.add(new Cliente("142", "Vero", "01/10/2002"));

        System.out.println(union(conjuntoClientesA, conjuntoClientesB));
        System.out.println(interseccion(conjuntoClientesA, conjuntoClientesB));
        System.out.println((Object) marta);
        System.out.println(marta.hashCode());
    }

    public static <E> Set<E> union(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> aux = new TreeSet<E>(conjunto1);
        aux.addAll(conjunto2);

        return aux;
    }

    static <E> Set<E> interseccion(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> interseccion = new TreeSet<>(conjunto1);
        interseccion.retainAll(conjunto2);
        return interseccion;
}

    static <E> Set<E> except(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> except = new TreeSet<>(conjunto2);
        except.removeAll(conjunto1);
        return except;
}

}
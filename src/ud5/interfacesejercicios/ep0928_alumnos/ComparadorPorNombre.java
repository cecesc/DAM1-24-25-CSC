package ud5.interfacesejercicios.ep0928_alumnos;

import java.util.Comparator;


public class ComparadorPorNombre implements Comparator {
       @Override
    public int compare(Object o1, Object o2) {
        Alumno s1 = ((Alumno) o1);
        Alumno s2 = ((Alumno) o2);
        return s1.nombre.compareToIgnoreCase(s2.nombre);
    }
    }


package ud5.interfacesejercicios.ep0928_alumnos;

import java.util.Comparator;

public class ComparadorPorEdad implements Comparator {
@Override
    public int compare(Object o1, Object o2) {
        Alumno s1 = (Alumno) o1;
        Alumno s2 = (Alumno) o2;
        return Integer.compare(s1.edad, s2.edad);
    }
}
/* static class ComparadorPorEdad implements Comparator<Alumno> {
        public int compare(Alumno a, Alumno b) {
            return Integer.compare(a.edad, b.edad);
        } */
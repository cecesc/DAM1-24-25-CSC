package ud5.interfacesejercicios.ep0928_alumnos;

import java.util.Comparator;

class Alumno implements Comparable {
    String nombre;
    String apellido;
    int edad;
    double notaMedia;

    public Alumno(String nombre, String apellido, int edad, double notaMedia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " - " + edad + " años - Nota: " + notaMedia;
    }

    @Override
    public int compareTo(Object o) {
        Alumno alum = (Alumno) o;
        int resultado = apellido.compareTo(alum.apellido);
        return resultado;
    }
/*
class Alumno implements Comparable<Alumno>
 @Override
    public int compareTo(Alumno otro) {
        return this.apellido.compareTo(otro.apellido);
    } */

    static class ComparadorPorNota implements Comparator<Alumno> {
        public int compare(Alumno a, Alumno b) {
            return Double.compare(a.notaMedia, b.notaMedia);
        }
    }

    
}
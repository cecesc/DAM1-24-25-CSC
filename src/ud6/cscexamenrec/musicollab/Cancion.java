//Autor: Celia Sanmartín Chapela

package ud6.cscexamenrec.musicollab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cancion implements Comparable<Cancion> {
        protected String nombre;
        protected String autor;
        protected String estilo;
        List<String> instrumentosRequeridos;

        public Cancion(String nombre, String autor, String estilo, String[] instrumentosRequeridos) {
                this.nombre = nombre;
                this.autor = autor;
                this.estilo = estilo;
                this.instrumentosRequeridos = List.of(instrumentosRequeridos);
        }

        public Cancion(String nombre, String autor, String estilo, List<String> instrumentosRequeridos) {
                this.nombre = nombre;
                this.autor = autor;
                this.estilo = estilo;
                this.instrumentosRequeridos = instrumentosRequeridos;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public String getEstilo() {
                return estilo;
        }

        public void setEstilo(String estilo) {
                this.estilo = estilo;
        }

        public List<String> getInstrumentosRequeridos() {
                return instrumentosRequeridos;
        }

        public void setInstrumentosRequeridos(List<String> instrumentosRequeridos) {
                this.instrumentosRequeridos = instrumentosRequeridos;
        }

        @Override
        public String toString() {
                return "'" + nombre + "' (" + autor + " ) - " + estilo + " | Instrumentos:" + instrumentosRequeridos;
        }

        public static List<String> sinRepetidos(List<String> instrumentosRequeridos) {
                Set<String> instRequeSR = new LinkedHashSet<>(instrumentosRequeridos);
                return new ArrayList<>(instRequeSR);
        }

        public static Collection<String> instrumentosDistintos(Collection<Cancion> canciones) {
                Set<String> instrumentosDistintos = new TreeSet<>();
                for (Cancion cancion : canciones) {
                        instrumentosDistintos.addAll(cancion.instrumentosRequeridos);
                }
                return instrumentosDistintos;
        }

        public static void main(String[] args) {
                // Canciones de ejemplo
                List<Cancion> canciones = Arrays.asList(
                                new Cancion("Bohemian Rhapsody", "Queen", "Rock",
                                                List.of("voz", "piano", "guitarra", "batería")),
                                new Cancion("Billie Jean", "Michael Jackson", "Pop",
                                                List.of("voz", "bajo", "batería")),
                                new Cancion("Imagine", "John Lennon", "Balada",
                                                List.of("voz", "piano")),
                                new Cancion("Smells Like Teen Spirit", "Nirvana", "Grunge",
                                                List.of("voz", "guitarra", "bajo", "batería")),
                                new Cancion("Yesterday", "The Beatles", "Pop",
                                                List.of("voz", "guitarra")),
                                new Cancion("Sweet Child O'Mine", "Guns N' Roses", "Rock",
                                                List.of("voz", "guitarra", "bajo", "batería")),
                                new Cancion("Rolling in the Deep", "Adele", "Pop",
                                                List.of("voz", "piano", "batería")),
                                new Cancion("Hotel California", "Eagles", "Rock",
                                                List.of("voz", "guitarra", "bajo", "batería")));

                // Ordenar canciones por nombre
                Collections.sort(canciones);
                System.out.println("\nCanciones ordenadas por nombre:");
                System.out.println("===============================\n");
                canciones.forEach(System.out::println);

                // Ordenar canciones alfabéticamente por estilo musical, luego por autor y luego
                // por nombre
                System.out.println("\nCanciones ordenadas por estilo musical, luego por autor y luego por nombre:");
                System.out.println("===========================================================================\n");

                // TODO Tu código aquí

                canciones.forEach(System.out::println);

                // Obtener lista de instrumentos distintos
                System.out.println("\nLista de instrumentos distintos:");
                System.out.println("================================\n");
                System.out.println(instrumentosDistintos(canciones));

                System.out.println("\n");
        }

        @Override
        public int compareTo(Cancion o) {
                return this.nombre.compareTo(o.nombre);
        }

}

//Autor: Celia Sanmartín Chapela

package ud6.cscexamenrec.musicollab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppMusicCollab {

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

                // Músicos de ejemplo
                List<Musico> musicos = new ArrayList<>(Arrays.asList(
                                new Musico("Ana López", "BassQueen", List.of("bajo", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(1),
                                                                canciones.get(5)))),
                                new Musico("Carlos Ruiz", "GuitarHero", List.of("guitarra", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(4),
                                                                canciones.get(7)))),
                                new Musico("Luisa Pérez", "DrumStar", List.of("batería"),
                                                new HashSet<>(Arrays.asList(canciones.get(1), canciones.get(3),
                                                                canciones.get(6)))),
                                new Musico("Pablo Martín", "PianoMaster", List.of("piano"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(2),
                                                                canciones.get(6)))),
                                new Musico("Sofía Vega", "Vocalist", List.of("voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(2), canciones.get(4),
                                                                canciones.get(7)))),
                                new Musico("Mario Silva", "SaxKing", List.of("saxofón"),
                                                new HashSet<>(List.of(canciones.get(3)))),
                                new Musico("Elena Díaz", "MultiInstrumentalist", List.of("guitarra", "piano", "voz"),
                                                new HashSet<>(Arrays.asList(canciones.get(0), canciones.get(2),
                                                                canciones.get(7))))));

                // Músicos para "Bohemian Rhapsody"
                Cancion bohemian = canciones.get(0);
                List<Musico> candidatos = musicosParaCancion(bohemian, musicos);
                System.out.println("\nMúsicos para '" + bohemian.getNombre() + "':");
                System.out.println("=====================================\n");
                candidatos.forEach(System.out::println);

                // Canciones que puede tocar un grupo de músicos
                List<Musico> grupo = List.of(musicos.get(1), musicos.get(0), musicos.get(2));
                List<Cancion> posibles = cancionesPosibles(grupo, canciones);
                System.out.println("\nCanciones posibles para el grupo:");
                System.out.println("=================================\n");
                posibles.forEach(System.out::println);

                System.out.println("\n");
        }

        public static List<Musico> musicosParaCancion(Cancion c, List<Musico> musicos) {
        List<Musico> resultado = new ArrayList<>();
        for (Musico m : musicos) {
            if (m.getRepertorio().contains(c)) {
                for (String instrumento : c.getInstrumentosRequeridos()) {
                    if (m.getInstrumentos().contains(instrumento)) {
                        resultado.add(m);
                        break;
                    }
                }
            }
        }
        Collections.sort(resultado);
        return resultado;
    }

    public static List<Cancion> cancionesPosibles(List<Musico> grupo, List<Cancion> canciones) {
        List<Cancion> posibles = new ArrayList<>();

        for (Cancion cancion : canciones) {
            Set<String> instrumentosFaltantes = new HashSet<>(cancion.getInstrumentosRequeridos());

            // Generar lista de músicos que conocen la canción
            List<Musico> disponibles = new ArrayList<>();
            for (Musico m : grupo) {
                if (m.getRepertorio().contains(cancion)) {
                    disponibles.add(m);
                }
            }

            // Asignación de instrumentos
            Set<Musico> usados = new HashSet<>();
            for (String instrumento : cancion.getInstrumentosRequeridos()) {
                boolean asignado = false;
                for (Musico m : disponibles) {
                    if (m.getInstrumentos().contains(instrumento)) {
                        if (!usados.contains(m) || (instrumento.equals("voz") && m.getInstrumentos().size() > 1)) {
                            instrumentosFaltantes.remove(instrumento);
                            if (!instrumento.equals("voz")) usados.add(m);
                            asignado = true;
                            break;
                        }
                    }
                }
                if (!asignado) break;
            }

            if (instrumentosFaltantes.isEmpty()) {
                posibles.add(cancion);
            }
        }

        Collections.sort(posibles);
        return posibles;
    }
}
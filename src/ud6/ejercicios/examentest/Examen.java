package ud6.ejercicios.examentest;

import java.util.Set;
import java.util.LinkedHashSet;

public class Examen {
    private String titulo;
    protected Set<Pregunta> preguntas;

    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new LinkedHashSet<>();
    }

    public boolean addPregunta(Pregunta p) {
        return preguntas.add(p);
    }

    public int numPreguntas() {
        return preguntas.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(titulo + "\n");
        int num = 1;
        for (Pregunta p : preguntas) {
            sb.append(num++).append(". ").append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}

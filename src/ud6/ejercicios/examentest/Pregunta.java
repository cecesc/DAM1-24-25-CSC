package ud6.ejercicios.examentest;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Pregunta {
    private String enunciado;
    protected List<String> respuestas;
    private int indiceCorrecto;

    public Pregunta(String enunciado, List<String> respuestas, int indiceCorrecto) {
        if (respuestas == null || respuestas.size() < 2) {
            throw new IllegalArgumentException("Debe haber al menos dos respuestas.");
        }
        if (indiceCorrecto < 0 || indiceCorrecto >= respuestas.size()) {
            throw new IllegalArgumentException("Índice de respuesta correcta fuera de rango.");
        }
        this.enunciado = enunciado;
        this.respuestas = new ArrayList<>(respuestas);
        this.indiceCorrecto = indiceCorrecto;
    }

    public boolean corregir(int respuestaUsuario) {
        return respuestaUsuario == indiceCorrecto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(enunciado + "\n");
        for (int i = 0; i < respuestas.size(); i++) {
            char letra = (char) ('a' + i);
            sb.append(letra).append(") ").append(respuestas.get(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pregunta)) return false;
        Pregunta otra = (Pregunta) o;
        return enunciado.equals(otra.enunciado) && respuestas.equals(otra.respuestas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enunciado, respuestas);
    }
}

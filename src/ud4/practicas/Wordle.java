package ud4.practicas;

import java.util.Objects;

public class Wordle {
    private String palabra;
    private int vecesOculta;
    private int vecesAcertada;
    private int vecesUsada;

    // Constructor
    public palabra(String palabra) {
        this.palabra = palabra;
        this.vecesOculta = 0;
        this.vecesAcertada = 0;
        this.vecesUsada = 0;
    }

    // Getters y setters
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getVecesOculta() {
        return vecesOculta;
    }

    public void setVecesOculta(int vecesOculta) {
        this.vecesOculta = vecesOculta;
    }

    public int getVecesAcertada() {
        return vecesAcertada;
    }

    public void setVecesAcertada(int vecesAcertada) {
        this.vecesAcertada = vecesAcertada;
    }

    public int getVecesUsada() {
        return vecesUsada;
    }

    public void setVecesUsada(int vecesUsada) {
        this.vecesUsada = vecesUsada;
    }

    // Método para mostrar las estadísticas
    public void estadisticas() {
        System.out.println("Palabra: " + palabra);
        System.out.println("Veces Oculta: " + vecesOculta);
        System.out.println("Veces Acertada: " + vecesAcertada);
        System.out.println("Veces Usada: " + vecesUsada);
    }

    // Sobrescribir toString para mostrar la palabra
    @Override
    public String toString() {
        return palabra;
    }

    // Método para comparar palabras
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        wordle palabra1 = (wordle) o;
        return Objects.equals(palabra, palabra1.wordle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palabra);
    }
}

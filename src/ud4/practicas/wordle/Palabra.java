package ud4.practicas.wordle;

public class Palabra {
    private String texto;
    private int vecesOculta;
    private int vecesAcertada;
    private int vecesIntentada;

    public Palabra(String texto) {
        this.texto = texto;
        this.vecesOculta = 0;
        this.vecesAcertada = 0;
        this.vecesIntentada = 0;
    }

    public String getTexto() {
        return texto;
    }

    public void incrementarOculta() {
        vecesOculta++;
    }

    public void incrementarAcertada() {
        vecesAcertada++;
    }

    public void incrementarIntentada() {
        vecesIntentada++;
    }

    public void estadisticas() {
        System.out.println("Palabra: " + texto);
        System.out.println("Veces como palabra oculta: " + vecesOculta);
        System.out.println("Veces acertada: " + vecesAcertada);
        System.out.println("Veces intentada: " + vecesIntentada);
    }

    @Override
    public String toString() {
        return texto;
    }
}



package ud6.ejercicios.limpiezaplaya;

import java.io.Serializable;

public class Playa implements Serializable {
    private String nome;
    private String concello;

    public Playa(String nome, String concello) {
        this.nome = nome;
        this.concello = concello;
    }

    public String getNome() {
        return nome;
    }

    public String getConcello() {
        return concello;
    }

    @Override
    public String toString() {
        return nome + " (" + concello + ")";
    }
}

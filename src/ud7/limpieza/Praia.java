package ud7.limpieza;

import java.io.Serializable;

public class Praia implements Serializable {
    private String nome;
    private String municipio;

    public Praia(String nome, String municipio) {
        this.nome = nome;
        this.municipio = municipio;
    }

    public String getNome() {
        return nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    @Override
    public String toString() {
        return nome + " (" + municipio + ")";
    }
}
